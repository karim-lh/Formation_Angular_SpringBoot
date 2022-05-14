package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import world.cup.models.Formateur;
import world.cup.models.Session_de_formation;


public interface Session_de_formationRepository extends JpaRepository<Session_de_formation, Long> {
	
	boolean existsByFormateur(Formateur formateur);
	
	@Query(value = "insert into participation (session_id, participant_id) values(:idSession, :idParticipant)", nativeQuery = true)
	@Modifying
	void addParticipation(@Param("idSession") Long idSession, @Param("idParticipant") Long idParticipant);
	
}


