package pl.edu.pwsztar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwsztar.domain.entity.AcceptedDose;
import pl.edu.pwsztar.domain.entity.key.AcceptedDoseKey;

@Repository
public interface AcceptedDoseRepository extends JpaRepository<AcceptedDose, AcceptedDoseKey> , CrudRepository<AcceptedDose,AcceptedDoseKey> {
    @Query("SELECT dose FROM AcceptedDose dose WHERE dose.client.clientId = ?1 AND dose.cure.cureId = ?2")
    AcceptedDose findInfo(Long clientId, Long cureId);
}
