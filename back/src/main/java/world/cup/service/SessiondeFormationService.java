package world.cup.service;

import world.cup.models.Session_de_formation;
import world.cup.responses.MessageResponse;

import java.util.List;




public interface SessiondeFormationService {
	
	public MessageResponse save(Session_de_formation SessFormation);
	public MessageResponse update(Session_de_formation SessFormation);
	public MessageResponse delete(Long id);
	public List<Session_de_formation> findAll();
	public Session_de_formation findById(Long id);

}
