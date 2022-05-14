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
import world.cup.models.Formation;
import world.cup.responses.MessageResponse;
import world.cup.service.FormationServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/formation")
public class FormationController {
	@Autowired
    private FormationServiceImpl formationService;

    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping
    public List<Formation> findAll() {
        return formationService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Formation formation) {
        return formationService.save(formation);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id, @RequestBody Formation formation) {
    	formation.setIdFormation(id);
        return formationService.update(id,formation);
    }

   @GetMapping("/{code}")
    public Formation findById(@PathVariable("code") Long id) {
        return formationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return formationService.delete(id);
    }

}
