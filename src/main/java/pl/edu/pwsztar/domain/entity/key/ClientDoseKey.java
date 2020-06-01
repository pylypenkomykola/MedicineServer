package pl.edu.pwsztar.domain.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientDoseKey implements Serializable {
    @Column(name = "id_client")
    private Long clientId;

    @Column(name = "id_cure")
    private Long cureId;

    public ClientDoseKey() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCureId() {
        return cureId;
    }

    public void setCureId(Long cureId) {
        this.cureId = cureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDoseKey that = (ClientDoseKey) o;
        return Objects.equals(getClientId(), that.getClientId()) &&
                Objects.equals(getCureId(), that.getCureId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getCureId());
    }
}
