package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.cure.ClientDoseDto;
import pl.edu.pwsztar.domain.entity.ClientDose;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class ClientDoseMapper implements Convert<ClientDoseDto, ClientDose> {
    @Override
    public ClientDose convert(ClientDoseDto clientDose){
        return new ClientDose.Builder()
                .cure(clientDose.getCure())
                .client(clientDose.getClient())
                .build();
    }
}
