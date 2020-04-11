package pl.pwsztar.edu.domain.entity;


import pl.pwsztar.edu.domain.entity.key.ClientDoseKey;

import javax.persistence.*;

@Entity
@Table(name="dose_of_client"  , schema = "medicine")
public class ClientDose{
    @EmbeddedId
    private ClientDoseKey id;

    @ManyToOne
    @MapsId("id_client")
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @MapsId("id_cure")
    @JoinColumn(name = "id_cure")
    private Cure cure;

    @Column(name="name")
    private String name;

    @Column(name="daily_of_dose")
    private Integer dailyDose;

    @Column(name="dose_timestamp")
    private Integer doseTimestamp;

    @Column(name="number_of_dose")
    private Integer doseNumber;

    public ClientDose() {
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
