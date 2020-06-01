package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.cure.CureDto;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.ClientDose;
import pl.edu.pwsztar.domain.entity.Cure;
import pl.edu.pwsztar.domain.entity.key.ClientDoseKey;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.ClientDoseRepository;
import pl.edu.pwsztar.domain.repository.ClientRepository;
import pl.edu.pwsztar.service.ClientDoseService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientDoseServiceImpl implements ClientDoseService {
    private final ClientDoseRepository clientDoseRepository;
    private final ClientRepository clientRepository;

    private final Convert<List<Cure>, List<CureDto>> cureListMapper;

    @Autowired
    public ClientDoseServiceImpl(ClientDoseRepository clientDoseRepository, ClientRepository clientRepository, Convert<List<Cure>, List<CureDto>> cureListMapper){
        this.clientDoseRepository = clientDoseRepository;
        this.clientRepository = clientRepository;
        this.cureListMapper = cureListMapper;
    }

    @Override
    public void addCureForClient(Long userId, Cure cure) {
        Optional<Client> clientExists = clientRepository.findById(userId);


        if (clientExists.isPresent()){
            Client client = clientExists.get();
            ClientDose clientDose = new ClientDose.Builder().clientDoseKey(new ClientDoseKey(client.getClientId(),cure.getCureId())).client(client).cure(cure).build();
            clientDoseRepository.save(clientDose);
        }
    }

    @Override
    public void deleteClientCure(Long userId, Cure cure) {
        Optional<Client> clientExists = clientRepository.findById(userId);

        if (clientExists.isPresent()){
            Client client = clientExists.get();
            ClientDose clientDose = new ClientDose.Builder().clientDoseKey(new ClientDoseKey(client.getClientId(),cure.getCureId())).client(client).cure(cure).build();
            clientDoseRepository.delete(clientDose);
        }
    }

    @Override
    public List<CureDto> getAllCure(Long userId) {
        Optional<List<Cure>> allCure = Optional.ofNullable(clientDoseRepository.getAllCure(userId));

        return allCure.map(cureListMapper::convert).orElse(null);
    }
}
