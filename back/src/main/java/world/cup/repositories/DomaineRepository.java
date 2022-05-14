package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import world.cup.models.Domaine;


public interface DomaineRepository extends JpaRepository<Domaine, Long> {
	
		boolean existsByLibelle(String libelle);

}
