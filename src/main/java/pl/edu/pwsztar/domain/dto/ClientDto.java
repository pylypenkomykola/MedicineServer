package pl.edu.pwsztar.domain.dto;

import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.entity.ClientDose;

import java.io.Serializable;
import java.util.Set;

public class ClientDto implements Serializable {
    private Set<AcceptedDose> acceptedDoses;
    private Set<ClientDose> dose;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;


    public ClientDto() {
    }

    private ClientDto(Builder builder) {
        this.acceptedDoses = builder.acceptedDoses;
        this.dose = builder.dose;
        this.email = builder.email;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
    }


    public Set<AcceptedDose> getAcceptedDoses() {
        return acceptedDoses;
    }

    public Set<ClientDose> getDose() {
        return dose;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public static final class Builder{
        private Set<AcceptedDose> acceptedDoses;
        private Set<ClientDose> dose;
        private String email;
        private String name;
        private String surname;
        private String phoneNumber;
        private String password;

        public Builder() {
        }

        public Builder(ClientDto copy) {
            this.acceptedDoses = copy.getAcceptedDoses();
            this.dose = copy.getDose();
            this.email = copy.getEmail();
            this.name = copy.getName();
            this.surname = copy.getSurname();
            this.phoneNumber = copy.getPhoneNumber();
            this.password = copy.getPassword();
        }


        public Builder acceptedDoses(Set<AcceptedDose> acceptedDoses){
            this.acceptedDoses=acceptedDoses;
            return this;
        }

        public Builder dose(Set<ClientDose> dose){
            this.dose=dose;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder surname(String surname){
            this.surname=surname;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public ClientDto build(){
            return new ClientDto(this);
        }
    }
}
