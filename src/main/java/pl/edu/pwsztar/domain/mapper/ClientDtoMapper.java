package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.cure.ClientDto;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.mapper.converter.Convert;

@Component
public class ClientDtoMapper implements Convert<ClientDto, Client> {
    @Override
    public Client convert(ClientDto client){
        return new Client.Builder()
                .name(client.getName())
                .surname(client.getSurname())
                .email(client.getEmail())
                .password(client.getPassword())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}
