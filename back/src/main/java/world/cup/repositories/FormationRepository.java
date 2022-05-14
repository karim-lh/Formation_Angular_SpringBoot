package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import world.cup.models.Formation;


public interface FormationRepository extends JpaRepository<Formation, Long> {

	boolean existsByTitre(String Titre);

} 
