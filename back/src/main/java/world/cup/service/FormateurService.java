package world.cup.service;

import world.cup.models.Formateur;
import world.cup.responses.MessageResponse;

import java.util.List;



public interface FormateurService {
	public MessageResponse save(Formateur formateur);
	public MessageResponse update(Formateur formateur);
	public MessageResponse delete(Long id);
	public List<Formateur> findAll();
	public Formateur findById(Long id);
}
