package world.cup.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Participant;
import world.cup.models.Session_de_formation;
import world.cup.repositories.Session_de_formationRepository;
import world.cup.responses.MessageResponse;


@Service
public class SessiondeFormationServiceImpl implements SessiondeFormationService {
	@Autowired
	Session_de_formationRepository session_de_formationRepository;
	@Transactional
	@Override
	public MessageResponse save(Session_de_formation SessFormation) {
		Set<Participant> participants = SessFormation.getParticipantList();
		SessFormation.setParticipantList(null);
		Long id = session_de_formationRepository.save(SessFormation).getIdSession();
        
        for(Participant participant: participants) {
			session_de_formationRepository.addParticipation(id, participant.getIdParticipant());
        }
        
        
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse update(Session_de_formation SessFormation) {
		boolean existe = session_de_formationRepository.existsById(SessFormation.getIdSession());
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Cette session existe déja !");

        }
        session_de_formationRepository.save(SessFormation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Session_de_formation SessFormation = findById(id);
        if (SessFormation==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        session_de_formationRepository.delete(SessFormation);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}
	@Transactional
	@Override
	public List<Session_de_formation> findAll() {
		return session_de_formationRepository.findAll();
	}
	@Transactional
	@Override
	public Session_de_formation findById(Long id) {
		Session_de_formation SessFormation = session_de_formationRepository.findById(id).orElse(null);
        return SessFormation;
	}

}
