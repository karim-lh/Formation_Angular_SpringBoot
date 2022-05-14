package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import world.cup.models.Formateur;


public interface FormateurRepository extends JpaRepository<Formateur, Long>{
	boolean existsByNom(String nom);
}
