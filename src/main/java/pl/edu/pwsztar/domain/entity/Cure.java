package pl.edu.pwsztar.domain.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="cure" , schema = "medicine")
public class Cure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cure")
    private Long cureId;

    @Column(name="name")
    private String name;

    @Column(name="daily_of_dose")
    private Integer dailyDose;

    @Column(name="dose_timestamp")
    private Integer doseTimestamp;

    @Column(name="number_of_dose")
    private Integer doseNumber;

    public Cure() {
    }

    public Cure(Builder builder) {
        this.cureId = builder.cureId;
        this.name = builder.name;
        this.dailyDose = builder.dailyDose;
        this.doseTimestamp = builder.doseTimestamp;
        this.doseNumber = builder.doseNumber;
        this.dose = builder.dose;
        this.acceptedDose = builder.acceptedDose;
    }

    @OneToMany(mappedBy = "cure")
    private Set<ClientDose> dose;

    @OneToMany(mappedBy = "cure")
    private Set<AcceptedDose> acceptedDose;

    public Long getCureId() {
        return cureId;
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
        private Long cureId;
        private String name;
        private Integer dailyDose;
        private Integer doseTimestamp;
        private Integer doseNumber;
        private Set<ClientDose> dose;
        private Set<AcceptedDose> acceptedDose;

        public Builder() {
        }

        public Builder(Cure copy){
            this.cureId = copy.getCureId();
            this.name = copy.getName();
            this.dailyDose = copy.getDailyDose();
            this.doseTimestamp = copy.getDoseTimestamp();
            this.doseNumber = copy.getDoseNumber();
            this.dose = copy.getDose();
            this.acceptedDose = copy.getAcceptedDose();
        }


        public Builder cureId(Long cureId){
            this.cureId = cureId;
            return this;
        }

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

        public Cure build(){
            return new Cure(this);
        }
    }

}
