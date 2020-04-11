package pl.pwsztar.edu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pwsztar.edu.domain.entity.Cure;

@Repository
public interface CureRepository extends JpaRepository<Cure,Long> , CrudRepository<Cure,Long> {
}
