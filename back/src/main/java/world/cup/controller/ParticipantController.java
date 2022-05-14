package world.cup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.cup.models.Participant;
import world.cup.responses.MessageResponse;
import world.cup.service.ParticipantServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
public class ParticipantController {
	@Autowired(required = false)
    private ParticipantServiceImpl participantService;

    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping
    public List<Participant> findAll() {
        return participantService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Participant participant) {
        return participantService.save(participant);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id,@RequestBody Participant participant) {
    	participant.setIdParticipant(id);
        return participantService.update(participant);
    }

   @GetMapping("/{code}")
    public Participant findById(@PathVariable("code") Long id) {
        return participantService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return participantService.delete(id);
    }
}
