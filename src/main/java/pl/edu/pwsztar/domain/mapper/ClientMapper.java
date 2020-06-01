package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.cure.ClientDto;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class ClientMapper implements Convert<Client, ClientDto> {
    @Override
    public ClientDto convert(Client client){
        return new ClientDto.Builder()
                .dose(client.getDose())
                .acceptedDoses(client.getAcceptedDoses())
                .name(client.getName())
                .surname(client.getSurname())
                .email(client.getEmail())
                .password(client.getPassword())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}
