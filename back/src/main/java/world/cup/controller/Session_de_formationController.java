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
import world.cup.models.Session_de_formation;
import world.cup.responses.MessageResponse;
import world.cup.service.SessiondeFormationServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/sessionformation")
public class Session_de_formationController {
	@Autowired(required = false)
    private SessiondeFormationServiceImpl sessiondeFormationService;

    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping
    public List<Session_de_formation> findAll() {
        return sessiondeFormationService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Session_de_formation session_de_formation) {
        return sessiondeFormationService.save(session_de_formation);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id,@RequestBody Session_de_formation session_de_formation) {
    	session_de_formation.setIdSession(id);
        return sessiondeFormationService.update(session_de_formation);
    }

   @GetMapping("/{code}")
    public Session_de_formation findById(@PathVariable("code") Long id) {
        return sessiondeFormationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return sessiondeFormationService.delete(id);
    }

}
