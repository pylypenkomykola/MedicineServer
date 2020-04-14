package pl.pwsztar.edu.domain.dto;

import pl.pwsztar.edu.domain.entity.Client;
import pl.pwsztar.edu.domain.entity.key.AcceptedDoseKey;

import java.io.Serializable;

public class AcceptedDoseDto implements Serializable {
    private AcceptedDoseKey id;
    private Client client;
    private boolean accepted;
    private boolean delayed;

    public AcceptedDoseDto() {
    }

    public AcceptedDoseKey getId() {
        return id;
    }

    public void setId(AcceptedDoseKey id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isDelayed() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }
}
