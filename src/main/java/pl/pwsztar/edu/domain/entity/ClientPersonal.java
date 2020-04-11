package pl.pwsztar.edu.domain.entity;


import pl.pwsztar.edu.domain.entity.key.ClientPersonalKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="client_personal"  , schema = "medicine")
public class ClientPersonal{

    @EmbeddedId
    private ClientPersonalKey id;

    @ManyToOne
    @MapsId("id_client")
    @JoinColumn(name = "id_client")
    private Client client;


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

    public ClientPersonal() {
    }

    public ClientPersonalKey getId() {
        return id;
    }

    public void setId(ClientPersonalKey id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
