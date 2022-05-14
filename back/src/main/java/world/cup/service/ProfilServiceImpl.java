package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Profil;
import world.cup.repositories.ProfilRepository;
import world.cup.responses.MessageResponse;


@Service
public class ProfilServiceImpl implements ProfilService{
	@Autowired
	ProfilRepository profilRepository;
	@Transactional
	@Override
	public MessageResponse save(Profil profil) {
		boolean existe = profilRepository.existsByLibelle(profil.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Ce profil existe déja !");
        }
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse update(Profil profil) {
		boolean existe = profilRepository.existsById(profil.getIdProfil());
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Ce profil existe déja !");

        }
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Profil profil = findById(id);
        if (profil==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        profilRepository.delete(profil);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}
	@Transactional
	@Override
	public List<Profil> findAll() {
		 return profilRepository.findAll();

	}
	@Transactional
	@Override
	public Profil findById(Long id) {
		Profil profil = profilRepository.findById(id).orElse(null);
        return profil;
	}

}
