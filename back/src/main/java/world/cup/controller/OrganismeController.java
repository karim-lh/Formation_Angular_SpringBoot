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
import world.cup.models.Organisme;
import world.cup.responses.MessageResponse;
import world.cup.service.OrganismeServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/organisme")
public class OrganismeController {
	@Autowired(required = false)
    private OrganismeServiceImpl organismeService;

    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping
    public List<Organisme> findAll() {
        return organismeService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Organisme organisme) {
        return organismeService.save(organisme);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id,@RequestBody Organisme organisme) {
    	organisme.setIdOrganisme(id);
        return organismeService.update(organisme);
    }

   @GetMapping("/{code}")
    public Organisme findById(@PathVariable("code") Long id) {
        return organismeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return organismeService.delete(id);
    }
}
