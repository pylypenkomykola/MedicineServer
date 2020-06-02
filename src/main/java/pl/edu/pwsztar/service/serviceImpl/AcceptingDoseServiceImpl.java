package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.cure.CureDto;
import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.ClientDose;
import pl.edu.pwsztar.domain.entity.Cure;
import pl.edu.pwsztar.domain.entity.key.AcceptedDoseKey;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.AcceptedDoseRepository;
import pl.edu.pwsztar.domain.repository.ClientRepository;
import pl.edu.pwsztar.domain.repository.CureRepository;
import pl.edu.pwsztar.service.AcceptingDoseService;


import javax.mail.internet.InternetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AcceptingDoseServiceImpl implements AcceptingDoseService {
    private final AcceptedDoseRepository doseRepository;
    private final ClientRepository clientRepository;
    private final CureRepository cureRepository;

    private final Convert<List<ClientDose>, List<Cure>> clientDoseMapper;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");


    @Autowired
    public AcceptingDoseServiceImpl(AcceptedDoseRepository doseRepository,
                                    ClientRepository clientRepository,
                                    CureRepository cureRepository,
                                    Convert<List<ClientDose>, List<Cure>> clientDoseMapper){
        this.doseRepository = doseRepository;
        this.clientRepository = clientRepository;
        this.cureRepository = cureRepository;

        this.clientDoseMapper = clientDoseMapper;
    }

    public void sendNotification(Client client, Cure cure){
        String email = "medicine.notification@gmail.com";
        String password = "198343583";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        javax.mail.Session session = javax.mail.Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(email, password);
                    }
                });

        try {
            javax.mail.Message message = new javax.mail.internet.MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    javax.mail.Message.RecipientType.TO,
                    javax.mail.internet.InternetAddress.parse(client.getEmail())
            );
            message.setSubject("Medicine: " +cure.getName());
            message.setText("Take your medicine called:" + cure.getName() +
                    "\nin dose number: " + cure.getDoseNumber());

            javax.mail.Transport.send(message);

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean acceptingCure(Long userId, CureDto cureDto) {
        Client client = clientRepository.findClient(userId);
        Cure cure = cureRepository.findCure(cureDto.getName(),cureDto.getDailyDose(),cureDto.getDoseNumber(),cureDto.getDoseTimestamp());

        String currentTime = dateFormat.format(new Date());
        Optional<AcceptedDose> checkAcceptedDose = Optional.ofNullable(doseRepository.findInfo(client.getClientId(),cure.getCureId()));
        int maxDelay = 1;

        int minutes = (Integer.parseInt(currentTime.substring(11,13)) * 60) + Integer.parseInt(currentTime.substring(14,16));
        float cureTime = (24/(float)cure.getDoseTimestamp())*60;



        if(minutes%cureTime == 0){
            AcceptedDose acceptedDose = new AcceptedDose.Builder().id(new AcceptedDoseKey(client.getClientId(),cure.getCureId())).accepted(true).delayed(false).client(client).cure(cure).date(currentTime).build();
            if(checkAcceptedDose.isEmpty() || !checkAcceptedDose.get().getDate().equals(currentTime)) {
                doseRepository.save(acceptedDose);
                return true;
            }
        } else if (minutes%cureTime < maxDelay){
            AcceptedDose acceptedDose = new AcceptedDose.Builder().id(new AcceptedDoseKey(client.getClientId(),cure.getCureId())).accepted(true).delayed(true).client(client).cure(cure).date(currentTime).build();
            if(checkAcceptedDose.isEmpty() || !checkAcceptedDose.get().getDate().equals(currentTime)) {
                doseRepository.save(acceptedDose);
                return true;
            }
        }

        return false;
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 1000 * 60)
    public void acceptingDose(){
        String currentTime = dateFormat.format(new Date());
        int minutes = (Integer.parseInt(currentTime.substring(11,13)) * 60) + Integer.parseInt(currentTime.substring(14,16));

        int notificationTime = 1; // minutes before take a cure
        int maxDelay = 1; // minutes with max delay time

        List<Client> clients = clientRepository.findAll();

        for(Client client: clients){
            List<Cure> cures = clientDoseMapper.convert(client.getDose());
            for(Cure cure: cures){
                float notify = ((24/(float)cure.getDoseTimestamp())*60)-notificationTime;
                float cureTime = (24/(float)cure.getDoseTimestamp())*60;

                System.out.println("Notify: "+ notify +"\nCure time: "+ cureTime);

                if((int)(notify%minutes)==0){
                    sendNotification(client,cure);
                }
                if((int)(minutes%cureTime) == maxDelay){
                    AcceptedDose acceptedDose = new AcceptedDose.Builder().id(new AcceptedDoseKey(client.getClientId(),cure.getCureId())).accepted(false).delayed(false).client(client).cure(cure).date(currentTime).build();
                    doseRepository.save(acceptedDose);
                }
            }
        }
    }
}