package world.cup.models;

import javax.persistence.*;

@Entity
public class Formation {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="Formation_id")
    private Long idFormation;
    @Column(name="Titre")
    private String titre;
    @Column(name="Type_formation")
    private String type_formation;
    @Column(name="Nb_session")
    private Long nb_session;
    @Column(name="Duree")
    private int duree;
    @Column(name="Budget")
    private Double budget;


    @ManyToOne
    private Domaine domaine;


    @ManyToOne
    private Session_de_formation Sessionformations;


    public Formation(Long idFormation, String titre, String type_formation, Long nb_session, int duree, Double budget, Domaine domaine, Session_de_formation sessionformations) {
        this.idFormation = idFormation;
        this.titre = titre;
        this.type_formation = type_formation;
        this.nb_session = nb_session;
        this.duree = duree;
        this.budget = budget;
        this.domaine = domaine;
        Sessionformations = sessionformations;
    }

    public Formation() {
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public Long getNb_session() {
        return nb_session;
    }

    public void setNb_session(Long nb_session) {
        this.nb_session = nb_session;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Session_de_formation getSessionformations() {
        return Sessionformations;
    }

    public void setSessionformations(Session_de_formation sessionformations) {
        Sessionformations = sessionformations;
    }
}

