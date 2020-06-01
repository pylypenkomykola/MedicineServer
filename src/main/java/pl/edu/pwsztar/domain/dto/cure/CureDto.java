package pl.edu.pwsztar.domain.dto.cure;

import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.entity.ClientDose;
import pl.edu.pwsztar.domain.entity.Cure;

import java.io.Serializable;
import java.util.Set;

public class CureDto implements Serializable {

    private String name;
    private Integer dailyDose;
    private Integer doseTimestamp;
    private Integer doseNumber;
    private Set<ClientDose> dose;
    private Set<AcceptedDose> acceptedDose;


    public CureDto() {
    }

    public CureDto(Builder builder) {
        this.name = builder.name;
        this.dailyDose = builder.dailyDose;
        this.doseTimestamp = builder.doseTimestamp;
        this.doseNumber = builder.doseNumber;
        this.dose = builder.dose;
        this.acceptedDose = builder.acceptedDose;
    }

    public String getName() {
        return name;
    }

    public Integer getDailyDose() {
        return dailyDose;
    }

    public Integer getDoseTimestamp() {
        return doseTimestamp;
    }

    public Integer getDoseNumber() {
        return doseNumber;
    }

    public Set<ClientDose> getDose() {
        return dose;
    }

    public Set<AcceptedDose> getAcceptedDose() {
        return acceptedDose;
    }

    public static final class Builder{
        private String name;
        private Integer dailyDose;
        private Integer doseTimestamp;
        private Integer doseNumber;
        private Set<ClientDose> dose;
        private Set<AcceptedDose> acceptedDose;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder dailyDose(Integer dailyDose){
            this.dailyDose = dailyDose;
            return this;
        }

        public Builder doseTimestamp(Integer doseTimestamp){
            this.doseTimestamp = doseTimestamp;
            return this;
        }

        public Builder doseNumber(Integer doseNumber){
            this.doseNumber = doseNumber;
            return this;
        }

        public Builder dose(Set<ClientDose> dose){
            this.dose = dose;
            return this;
        }

        public Builder acceptedDose(Set<AcceptedDose> acceptedDose){
            this.acceptedDose = acceptedDose;
            return this;
        }

        public CureDto build(){
            return new CureDto(this);
        }
    }
}
