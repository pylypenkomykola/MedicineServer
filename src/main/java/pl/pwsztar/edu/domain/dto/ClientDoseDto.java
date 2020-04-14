package pl.pwsztar.edu.domain.dto;


import pl.pwsztar.edu.domain.entity.Client;
import pl.pwsztar.edu.domain.entity.Cure;
import pl.pwsztar.edu.domain.entity.key.ClientDoseKey;

import java.io.Serializable;


public class ClientDoseDto implements Serializable {
    private ClientDoseKey id;
    private Client client;
    private Cure cure;
    private String name;
    private Integer dailyDose;
    private Integer doseTimestamp;
    private Integer doseNumber;

    public ClientDoseDto() {
    }

    public ClientDoseKey getId() {
        return id;
    }

    public void setId(ClientDoseKey id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cure getCure() {
        return cure;
    }

    public void setCure(Cure cure) {
        this.cure = cure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDailyDose() {
        return dailyDose;
    }

    public void setDailyDose(Integer dailyDose) {
        this.dailyDose = dailyDose;
    }

    public Integer getDoseTimestamp() {
        return doseTimestamp;
    }

    public void setDoseTimestamp(Integer doseTimestamp) {
        this.doseTimestamp = doseTimestamp;
    }

    public Integer getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(Integer doseNumber) {
        this.doseNumber = doseNumber;
    }
}
