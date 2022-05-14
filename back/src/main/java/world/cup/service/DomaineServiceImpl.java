package world.cup.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.cup.models.Domaine;
import world.cup.repositories.DomaineRepository;
import world.cup.responses.MessageResponse;


@Service
public class DomaineServiceImpl implements DomaineService{

@Autowired
private DomaineRepository domaineRepository;

    @Transactional
    @Override
    public MessageResponse save(Domaine domaine) {
        boolean existe = domaineRepository.existsByLibelle(domaine.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette domaine existe déja !");
        }
        domaineRepository.save(domaine);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }


    @Transactional
    @Override
    public MessageResponse update(Long id, Domaine domaine) {
        boolean existe = domaineRepository.existsById(id);
        if (!existe){
            //boolean existe1 = domaineRepository.existsByLibelle(domaine.getLibelle());
            return new MessageResponse(false,"Echec !","Cette domaine existe déja !");

        }
        domaineRepository.save(domaine);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Domaine domaine = findById(id);
        if (domaine==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        domaineRepository.delete(domaine);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Domaine> findAll() {

        return domaineRepository.findAll();
    }

    @Override
    public Domaine findById(Long id) {
        Domaine domaine = domaineRepository.findById(id).orElse(null);
        return domaine;
    }
}