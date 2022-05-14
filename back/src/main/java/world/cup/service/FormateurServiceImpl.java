package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Formateur;
import world.cup.repositories.FormateurRepository;
import world.cup.responses.MessageResponse;


@Service
public class FormateurServiceImpl implements FormateurService{
	@Autowired
	FormateurRepository formateurRepository;
	
	@Transactional
	@Override
	public MessageResponse save(Formateur formateur) {
		boolean existe = formateurRepository.existsByNom(formateur.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Ce formateur existe déja !");
        }
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
    
	@Transactional
	@Override
	public MessageResponse update(Formateur formateur) {
		boolean existe = formateurRepository.existsById(formateur.getIdFormateur());
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Cet formateur existe déja !");

        }
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		 Formateur formateur = findById(id);
	        if (formateur==null){
	            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
	        }
	        formateurRepository.delete(formateur);
	        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}
	
	@Transactional
	@Override
	public List<Formateur> findAll() {
        return formateurRepository.findAll();

	}
	
	@Transactional
	@Override
	public Formateur findById(Long id) {
		Formateur formateur = formateurRepository.findById(id).orElse(null);
        return formateur;
	}

}
