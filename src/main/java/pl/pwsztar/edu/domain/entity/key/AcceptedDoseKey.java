package pl.pwsztar.edu.domain.entity.key;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AcceptedDoseKey implements Serializable {
    @Column(name = "id_client")
    private Long clientId;

    public AcceptedDoseKey() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcceptedDoseKey that = (AcceptedDoseKey) o;
        return Objects.equals(getClientId(), that.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId());
    }
}
