package pl.edu.pwsztar.domain.dto.cure;


import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.entity.Client;
import pl.edu.pwsztar.domain.entity.Cure;


import java.io.Serializable;
import java.util.Set;

public class AcceptedDoseDto implements Serializable {
    private boolean accepted;
    private boolean delayed;

    public AcceptedDoseDto() {
    }

    private AcceptedDoseDto(Builder builder) {
        this.accepted = builder.accepted;
        this.delayed = builder.delayed;
    }


    public boolean isAccepted() {
        return accepted;
    }

    public boolean isDelayed() {
        return delayed;
    }

    public static final class Builder{
        private boolean accepted;
        private boolean delayed;

        public Builder(AcceptedDoseDto copy){
            this.accepted = copy.isAccepted();
            this.delayed = copy.isDelayed();
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
