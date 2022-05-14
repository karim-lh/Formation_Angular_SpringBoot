package world.cup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import world.cup.models.Domaine;
import world.cup.responses.MessageResponse;
import world.cup.service.DomaineServiceImpl;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")
public class DomaineController {

    @Autowired
    private final DomaineServiceImpl domaineService;

    public DomaineController(DomaineServiceImpl domaineService) {
        this.domaineService = domaineService;
    }


    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping()
    public List<Domaine> findAll() {
        return domaineService.findAll();
    }

    @PostMapping()
    public MessageResponse save(@RequestBody Domaine domaine) {
        return domaineService.save(domaine);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id,  @RequestBody Domaine domaine) {
    	domaine.setIdDomaine(id);
        return domaineService.update(id,domaine);
    }

   @GetMapping("/{code}")
    public Domaine findById(@PathVariable("code") Long id) {
        return domaineService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return domaineService.delete(id);
    }
}