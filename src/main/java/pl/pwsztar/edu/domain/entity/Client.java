package pl.pwsztar.edu.domain.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="client"  , schema = "medicine")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long clientId;

    public Client() {
    }

    @OneToMany(mappedBy = "client")
    private Set<ClientPersonal> personal;

    @OneToMany(mappedBy = "client")
    private Set<AcceptedDose> acceptedDoses;

    @OneToMany(mappedBy = "client")
    private Set<ClientDose> dose;

    public Set<ClientPersonal> getPersonal() {
        return personal;
    }

    public void setPersonal(Set<ClientPersonal> personal) {
        this.personal = personal;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
