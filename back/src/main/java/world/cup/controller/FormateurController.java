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
import world.cup.models.Formateur;
import world.cup.responses.MessageResponse;
import world.cup.service.FormateurServiceImpl;


//@Controller
//@ResponseBody
@RestController
@CrossOrigin("*")
@RequestMapping("/formateur")
public class FormateurController {

	    @Autowired
	    private FormateurServiceImpl formateurService;

	    //@RequestMapping(value="/formation", method=RequestMethod.GET)
	    @GetMapping
	    public List<Formateur> findAll() {
	        return formateurService.findAll();
	    }

	    @PostMapping
	    public MessageResponse save(@RequestBody Formateur formateur) {
	        return formateurService.save(formateur);
	    }

	    @PutMapping("/{id}")
	    public MessageResponse update(@PathVariable("id")Long id,@RequestBody Formateur formateur) {
	    	formateur.setIdFormateur(id);
	        return formateurService.update(formateur);
	    }

	   @GetMapping("/{code}")
	    public Formateur findById(@PathVariable("code") Long id) {
	        return formateurService.findById(id);
	    }

	    @DeleteMapping("/{id}")
	    public MessageResponse delete(@PathVariable Long id) {
	        return formateurService.delete(id);
	    }
	}


