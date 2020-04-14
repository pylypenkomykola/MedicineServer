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

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="password")
    private String password;

    public Client() {
    }

    @OneToMany(mappedBy = "client")
    private Set<AcceptedDose> acceptedDoses;

    @OneToMany(mappedBy = "client")
    private Set<ClientDose> dose;

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
