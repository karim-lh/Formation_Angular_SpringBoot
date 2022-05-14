package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import world.cup.models.Profil;


public interface ProfilRepository extends JpaRepository<Profil, Long>{
	boolean existsByLibelle(String libelle);
}
