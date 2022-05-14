package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Profil {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="Profil_id")
    private Long idProfil;
    @Column(name="Libelle")
    private String libelle;

    public Profil(Long idProfil, String libelle) {
        this.idProfil = idProfil;
        this.libelle = libelle;
    }

    public Profil() {

    }

    public Long getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Long idProfil) {
        this.idProfil = idProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}