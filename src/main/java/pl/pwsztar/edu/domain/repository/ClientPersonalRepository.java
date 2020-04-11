package pl.pwsztar.edu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pwsztar.edu.domain.entity.ClientPersonal;

@Repository
public interface ClientPersonalRepository extends JpaRepository<ClientPersonal,Long> , CrudRepository<ClientPersonal,Long> {
}
