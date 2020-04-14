package pl.pwsztar.edu.domain.mapper;

import org.springframework.stereotype.Component;
import pl.pwsztar.edu.domain.dto.ClientDto;
import pl.pwsztar.edu.domain.entity.Client;
import pl.pwsztar.edu.domain.mapper.converter.Convert;

@Component
public class ClientMapper implements Convert<Client, ClientDto> {
    @Override
    public ClientDto convert(Client client){
        ClientDto clientDto = new ClientDto();

        clientDto.setDose(client.getDose());
        clientDto.setClientId(client.getClientId());
        clientDto.setAcceptedDoses(client.getAcceptedDoses());

        clientDto.setEmail(client.getEmail());
        clientDto.setName(client.getName());
        clientDto.setPassword(client.getPassword());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setSurname(client.getSurname());

        return clientDto;
    }
}
