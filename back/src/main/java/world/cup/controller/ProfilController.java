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
import world.cup.models.Profil;
import world.cup.responses.MessageResponse;
import world.cup.service.ProfilServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/profil")
public class ProfilController {
	@Autowired(required = false)
    private ProfilServiceImpl profilService;

    //@RequestMapping(value="/formation", method=RequestMethod.GET)
    @GetMapping
    public List<Profil> findAll() {
        return profilService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Profil profil) {
        return profilService.save(profil);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable("id")Long id,@RequestBody Profil profil) {
    	profil.setIdProfil(id);
        return profilService.update(profil);
    }

   @GetMapping("/{code}")
    public Profil findById(@PathVariable("code") Long id) {
        return profilService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return profilService.delete(id);
    }
}
