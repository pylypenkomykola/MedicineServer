package pl.edu.pwsztar.domain.dto;

import pl.edu.pwsztar.domain.entity.ClientDose;

import java.io.Serializable;
import java.util.Set;

public class CureDto implements Serializable {
    private Long cureId;
    private String name;
    private String type;
    private Set<ClientDose> dose;


    public CureDto() {
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

    public Set<ClientDose> getDose() {
        return dose;
    }

    public void setDose(Set<ClientDose> dose) {
        this.dose = dose;
    }
}
