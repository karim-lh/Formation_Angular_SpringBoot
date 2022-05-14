package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Participant;
import world.cup.repositories.ParticipantRepository;
import world.cup.responses.MessageResponse;


@Service
public class ParticipantServiceImpl implements ParticipantService {
	@Autowired
	ParticipantRepository participantRepository;
	@Transactional
	@Override
	public MessageResponse save(Participant participant) {
		boolean existe = participantRepository.existsByNom(participant.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cet participant existe déja !");
        }
        participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse update(Participant participant) {
		boolean existe = participantRepository.existsById(participant.getIdParticipant());
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Cet participant existe déja !");}
        participantRepository.save(participant);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Participant participant = findById(id);
        if (participant==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        participantRepository.delete(participant);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}
	@Transactional
	@Override
	public List<Participant> findAll() {
		return participantRepository.findAll();
	}
	@Transactional
	@Override
	public Participant findById(Long id) {
		Participant participant = participantRepository.findById(id).orElse(null);
        return participant;
	}

}
