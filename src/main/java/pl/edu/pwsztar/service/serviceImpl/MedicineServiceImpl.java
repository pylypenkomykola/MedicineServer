package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.*;
import pl.edu.pwsztar.domain.entity.*;
import pl.edu.pwsztar.domain.mapper.converter.Convert;
import pl.edu.pwsztar.domain.repository.*;
import pl.edu.pwsztar.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
    private Convert<AcceptedDose, AcceptedDoseDto> acceptedDoseMapper;
    private Convert<ClientDose, ClientDoseDto> clientDoseMapper;
    private Convert<Client, ClientDto> clientMapper;
    private Convert<Cure, CureDto> cureMapper;

    private AcceptedDoseRepository acceptedDoseRepository;
    private ClientDoseRepository clientDoseRepository;
    private CureRepository cureRepository;

    @Autowired
    public MedicineServiceImpl(Convert<AcceptedDose, AcceptedDoseDto> acceptedDoseMapper, Convert<ClientDose, ClientDoseDto> clientDoseMapper, Convert<Client, ClientDto> clientMapper , Convert<Cure, CureDto> cureMapper, AcceptedDoseRepository acceptedDoseRepository, ClientDoseRepository clientDoseRepository, CureRepository cureRepository) {
        this.acceptedDoseMapper = acceptedDoseMapper;
        this.clientDoseMapper = clientDoseMapper;
        this.clientMapper = clientMapper;
        this.cureMapper = cureMapper;
        this.acceptedDoseRepository = acceptedDoseRepository;
        this.clientDoseRepository = clientDoseRepository;
        this.cureRepository = cureRepository;
    }


}
