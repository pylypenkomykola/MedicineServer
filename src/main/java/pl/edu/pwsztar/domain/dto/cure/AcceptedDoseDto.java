package pl.edu.pwsztar.domain.dto.cure;


import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.Cure;


import java.io.Serializable;
import java.util.Set;

public class AcceptedDoseDto implements Serializable {
    private Client client;
    private Cure cure;
    private boolean accepted;
    private boolean delayed;

    public AcceptedDoseDto() {
    }

    private AcceptedDoseDto(Builder builder) {
        this.client = builder.client;
        this.cure = builder.cure;
        this.accepted = builder.accepted;
        this.delayed = builder.delayed;
    }


    public Client getClient() {
        return client;
    }

    public Cure getCure() {
        return cure;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isDelayed() {
        return delayed;
    }

    public static final class Builder{
        private Client client;
        private Cure cure;
        private boolean accepted;
        private boolean delayed;

        public Builder(AcceptedDoseDto copy){
            this.client = copy.getClient();
            this.cure = copy.getCure();
            this.accepted = copy.isAccepted();
            this.delayed = copy.isDelayed();
        }

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Builder cure(Cure cure){
            this.cure = cure;
            return this;
        }

        public Builder accepted(boolean accepted){
            this.accepted = accepted;
            return this;
        }

        public Builder delayed(boolean delayed){
            this.delayed = delayed;
            return this;
        }


        public AcceptedDoseDto build(){
            return new AcceptedDoseDto(this);
        }
    }

}
