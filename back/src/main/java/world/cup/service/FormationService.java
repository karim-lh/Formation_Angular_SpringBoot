package world.cup.service;

import world.cup.models.Formation;
import world.cup.responses.MessageResponse;

import java.util.List;





public interface FormationService {
	
	public MessageResponse save(Formation formation);
	public MessageResponse update(Long id,Formation formation);
	public MessageResponse delete(Long id);
	public List<Formation> findAll();
	public Formation findById(Long id);

}
