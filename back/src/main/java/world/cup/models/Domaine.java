package world.cup.models;



import javax.persistence.*;




@Entity
public class Domaine  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="DomaineId")
    private Long IdDomaine;

    @Column(unique = true,nullable = false)
    private String libelle;

    public Domaine(Long idDomaine, String libelle) {
        IdDomaine = idDomaine;
        this.libelle = libelle;
    }

    public Domaine() {

    }


    public Long getIdDomaine() {
        return IdDomaine;
    }

    public void setIdDomaine(Long idDomaine) {
        IdDomaine = idDomaine;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Domaine{" +
                "IdDomaine=" + IdDomaine +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
