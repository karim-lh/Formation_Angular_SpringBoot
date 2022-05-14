package world.cup.service;

import world.cup.models.Participant;
import world.cup.responses.MessageResponse;

import java.util.List;



public interface ParticipantService {
	public MessageResponse save(Participant participant);
	public MessageResponse update(Participant participant);
	public MessageResponse delete(Long id);
	public List<Participant> findAll();
	public Participant findById(Long id);
}
