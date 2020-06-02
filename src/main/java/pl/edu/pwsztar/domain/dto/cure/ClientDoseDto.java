package pl.edu.pwsztar.domain.dto.cure;


import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.Cure;
import pl.edu.pwsztar.domain.entity.key.ClientDoseKey;

import java.io.Serializable;


public class ClientDoseDto implements Serializable {
    private Client client;
    private Cure cure;

    public ClientDoseDto() {
    }

    private ClientDoseDto(Builder builder) {
        this.client = builder.client;
        this.cure = builder.cure;
    }

    public Client getClient() {
        return client;
    }

    public Cure getCure() {
        return cure;
    }

    public static final class Builder{
        private Client client;
        private Cure cure;

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Builder cure(Cure cure){
            this.cure = cure;
            return this;
        }

        public ClientDoseDto build(){
            return new ClientDoseDto(this);
        }
    }
}
