package world.cup.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pays {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="Pays_id")
    private Long idPays;

    @Column(name="Libelle")
    private String libelle;

    public Pays(Long idPays, String libelle) {
        this.idPays = idPays;
        this.libelle = libelle;
    }

    public Pays() {

    }

    public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}