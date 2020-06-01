package pl.edu.pwsztar.domain.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="cure" , schema = "medicine")
public class Cure{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cure")
    private Long cureId;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    public Cure() {
    }

    @OneToMany(mappedBy = "cure")
    private Set<ClientDose> dose;

    public Set<ClientDose> getDose() {
        return dose;
    }

    public void setDose(Set<ClientDose> dose) {
        this.dose = dose;
    }

    public Long getCureId() {
        return cureId;
    }

    public void setCureId(Long cureId) {
        this.cureId = cureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
