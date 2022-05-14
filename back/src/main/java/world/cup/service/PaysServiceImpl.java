package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Pays;
import world.cup.repositories.PaysRepository;
import world.cup.responses.MessageResponse;


@Service
public class PaysServiceImpl implements PaysService {
	@Autowired
	PaysRepository paysRepository;
	@Transactional
	@Override
	public MessageResponse save(Pays pays) {
		boolean existe = paysRepository.existsByLibelle(pays.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Ce pays existe déja !");
        }
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse update(Pays pays) {
		boolean existe = paysRepository.existsById(pays.getIdPays());
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Ce pays existe déja !");

        }
        paysRepository.save(pays);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}
	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Pays pays = findById(id);
        if (pays==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        paysRepository.delete(pays);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}
	@Transactional
	@Override
	public List<Pays> findAll() {
		 return paysRepository.findAll();

	}
	@Transactional
	@Override
	public Pays findById(Long id) {
		Pays pays = paysRepository.findById(id).orElse(null);
        return pays;
	}

}
