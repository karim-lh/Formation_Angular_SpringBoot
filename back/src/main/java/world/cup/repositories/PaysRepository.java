package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import world.cup.models.Pays;


public interface PaysRepository extends JpaRepository<Pays, Long> {
	boolean existsByLibelle(String libelle);
}
