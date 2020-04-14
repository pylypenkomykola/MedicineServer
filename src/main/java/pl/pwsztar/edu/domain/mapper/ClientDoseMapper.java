package pl.pwsztar.edu.domain.mapper;

import org.springframework.stereotype.Component;
import pl.pwsztar.edu.domain.dto.ClientDoseDto;
import pl.pwsztar.edu.domain.entity.ClientDose;
import pl.pwsztar.edu.domain.mapper.converter.Convert;

@Component
public class ClientDoseMapper implements Convert<ClientDose, ClientDoseDto> {
    @Override
    public ClientDoseDto convert(ClientDose clientDose){
        ClientDoseDto clientDoseDto = new ClientDoseDto();

        clientDoseDto.setClient(clientDose.getClient());
        clientDoseDto.setCure(clientDose.getCure());
        clientDoseDto.setDailyDose(clientDose.getDailyDose());
        clientDoseDto.setDoseNumber(clientDose.getDoseNumber());
        clientDoseDto.setDoseTimestamp(clientDose.getDoseTimestamp());
        clientDoseDto.setId(clientDose.getId());
        clientDoseDto.setName(clientDose.getName());

        return clientDoseDto;
    }
}
