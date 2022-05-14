package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Formation;
import world.cup.repositories.FormationRepository;
import world.cup.responses.MessageResponse;


@Service
public class FormationServiceImpl implements FormationService {


	@Autowired
	FormationRepository formationRepository;

	@Transactional
	@Override
	public MessageResponse save(Formation formation) {
		boolean existe = formationRepository.existsByTitre(formation.getTitre());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");
        }
        formationRepository.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}


	@Transactional
	@Override
	public MessageResponse update(Long id ,Formation formation) {
		boolean existe = formationRepository.existsById(id);
        if (!existe){
            //boolean existe1 = formationRepository.existsByTitre(formation.getTitre());
            return new MessageResponse(false,"Echec !","Cette formation existe déja !");

        }
        formationRepository.save(formation);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Formation formation = findById(id);
        if (formation==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        formationRepository.delete(formation);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

	@Transactional
	@Override
	public List<Formation> findAll() {
		// TODO Auto-generated method stub
		return formationRepository.findAll();
	}

	@Transactional
	@Override
	public Formation findById(Long id) {
		Formation formation = formationRepository.findById(id).orElse(null);
        return formation;
	}
	
}