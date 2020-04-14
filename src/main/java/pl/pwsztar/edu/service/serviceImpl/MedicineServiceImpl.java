package pl.pwsztar.edu.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwsztar.edu.domain.dto.*;
import pl.pwsztar.edu.domain.entity.*;
import pl.pwsztar.edu.domain.mapper.converter.Convert;
import pl.pwsztar.edu.domain.repository.*;
import pl.pwsztar.edu.service.MedicineService;

import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {
    private Convert<AcceptedDose, AcceptedDoseDto> acceptedDoseMapper;
    private Convert<ClientDose, ClientDoseDto> clientDoseMapper;
    private Convert<Client, ClientDto> clientMapper;
    private Convert<Cure, CureDto> cureMapper;

    private AcceptedDoseRepository acceptedDoseRepository;
    private ClientDoseRepository clientDoseRepository;
    private ClientRepository clientRepository;
    private CureRepository cureRepository;

    @Autowired
    public MedicineServiceImpl(Convert<AcceptedDose, AcceptedDoseDto> acceptedDoseMapper, Convert<ClientDose, ClientDoseDto> clientDoseMapper, Convert<Client, ClientDto> clientMapper , Convert<Cure, CureDto> cureMapper, AcceptedDoseRepository acceptedDoseRepository, ClientDoseRepository clientDoseRepository, ClientRepository clientRepository, ClientRepository clientPersonalRepository, CureRepository cureRepository) {
        this.acceptedDoseMapper = acceptedDoseMapper;
        this.clientDoseMapper = clientDoseMapper;
        this.clientMapper = clientMapper;
        this.cureMapper = cureMapper;
        this.acceptedDoseRepository = acceptedDoseRepository;
        this.clientDoseRepository = clientDoseRepository;
        this.clientRepository = clientPersonalRepository;
        this.cureRepository = cureRepository;
    }

    @Override
    public void register(Client personal) {
        clientRepository.save(personal);
    }

    @Override
    public boolean login(Client personal) {
        ClientDto personalDto = clientMapper.convert(personal);
        Optional<String> checkPassword = Optional.of(clientRepository.findByKey(personalDto.getEmail()));
        String password = checkPassword.orElse("");

        if(!password.isEmpty() && personalDto.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
