package world.cup.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Organisme {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="Organisme_id")
    private Long idOrganisme;
    @Column(name="Libelle")
    private String libelle;

    public Organisme() {

    }

    public Long getIdOrganisme() {
        return idOrganisme;
    }

    public void setIdOrganisme(Long idOrganisme) {
        this.idOrganisme = idOrganisme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    @Override
    public String toString() {
        return "Organisme{" +
                "idOrganisme=" + idOrganisme +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public Organisme(Long idOrganisme, String libelle) {
        this.idOrganisme = idOrganisme;
        this.libelle = libelle;
    }
}
