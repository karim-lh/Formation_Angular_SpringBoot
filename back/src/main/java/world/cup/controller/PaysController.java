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
import world.cup.models.Pays;
import world.cup.responses.MessageResponse;
import world.cup.service.PaysServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
public class PaysController {
	@Autowired(required = false)
    private PaysServiceImpl paysService;

    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping
    public List<Pays> findAll() {
        return paysService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Pays pays) {
        return paysService.save(pays);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id,@RequestBody Pays pays) {
    	pays.setIdPays(id);
        return paysService.update(pays);
    }

   @GetMapping("/{code}")
    public Pays findById(@PathVariable("code") Long id) {
        return paysService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return paysService.delete(id);
    }
}
