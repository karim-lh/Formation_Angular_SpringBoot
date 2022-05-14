package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import world.cup.models.Participant;


public interface ParticipantRepository extends JpaRepository<Participant, Long>{
	boolean existsByNom(String nom);
}
