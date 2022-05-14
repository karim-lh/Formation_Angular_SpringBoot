package world.cup.service;

import world.cup.models.Domaine;
import world.cup.responses.MessageResponse;

import java.util.List;






public interface DomaineService  {
public MessageResponse save(Domaine domaine);
public MessageResponse update(Long id,Domaine domaine);
public MessageResponse delete(Long id);
public List<Domaine> findAll();
public Domaine findById(Long id);

}
