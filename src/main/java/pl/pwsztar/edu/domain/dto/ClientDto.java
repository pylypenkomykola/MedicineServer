package pl.pwsztar.edu.domain.dto;

import pl.pwsztar.edu.domain.entity.AcceptedDose;
import pl.pwsztar.edu.domain.entity.Client;
import pl.pwsztar.edu.domain.entity.ClientDose;

import java.io.Serializable;
import java.util.Set;

public class ClientDto implements Serializable {
    private Long clientId;
    private Set<AcceptedDose> acceptedDoses;
    private Set<ClientDose> dose;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;


    public ClientDto() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


    public Set<AcceptedDose> getAcceptedDoses() {
        return acceptedDoses;
    }

    public void setAcceptedDoses(Set<AcceptedDose> acceptedDoses) {
        this.acceptedDoses = acceptedDoses;
    }

    public Set<ClientDose> getDose() {
        return dose;
    }

    public void setDose(Set<ClientDose> dose) {
        this.dose = dose;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
