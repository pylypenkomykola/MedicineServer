package pl.edu.pwsztar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwsztar.domain.entity.ClientDose;

@Repository
public interface ClientDoseRepository extends JpaRepository<ClientDose,Long>, CrudRepository<ClientDose,Long> {
}
