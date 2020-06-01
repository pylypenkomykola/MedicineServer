package pl.edu.pwsztar.domain.entity;


import pl.edu.pwsztar.domain.entity.key.AcceptedDoseKey;

import javax.persistence.*;

@Entity
@Table(name="accepted_dose"  , schema = "medicine")
public class AcceptedDose{

    @EmbeddedId
    private AcceptedDoseKey id;

    @ManyToOne
    @MapsId("id_client")
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name="accepted")
    private boolean accepted;

    @Column(name="delayed")
    private boolean delayed;

    public AcceptedDose() {
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
