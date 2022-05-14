package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Organisme;
import world.cup.repositories.OrganismeRepository;
import world.cup.responses.MessageResponse;


@Service
public class OrganismeServiceImpl implements OrganismeService {
	@Autowired
	OrganismeRepository organismeRepository;
	
	@Transactional
	@Override
	public MessageResponse save(Organisme organisme) {
		boolean existe = organismeRepository.existsByLibelle(organisme.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cet organisme existe déja !");
        }
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse update(Organisme organisme) {
		boolean existe = organismeRepository.existsById(organisme.getIdOrganisme());
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Cet organisme existe déja !");

        }
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Organisme organisme = findById(id);
        if (organisme==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        organismeRepository.delete(organisme);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}
	@Transactional
	@Override
	public List<Organisme> findAll() {
        return organismeRepository.findAll();

	}
	@Transactional
	@Override
	public Organisme findById(Long id) {
		Organisme organisme = organismeRepository.findById(id).orElse(null);
        return organisme;
	}

}
