package world.cup.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity

public class Participant {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="Participant_id")
    private Long idParticipant;
    @Column(name="Nom")
    private String nom;
    @Column(name="Prenom")
    private String prenom;
    @Column(name="Email")
    private String email;
    @Column(name="Telephone")
    private Long tel;


    @ManyToOne
    private Profil profil;

    @ManyToOne
    private Pays pays;

    @ManyToOne
    private Organisme organisme;

    public Participant() {

    }

    @Override
    public String toString() {
        return "Participant{" +
                "idParticipant=" + idParticipant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", profil=" + profil +
                ", pays=" + pays +
                ", organisme=" + organisme +
                '}';
    }

    public Participant(Long idParticipant, String nom, String prenom, String email, Long tel, Profil profil, Pays pays, Organisme organisme) {
        this.idParticipant = idParticipant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.profil = profil;
        this.pays = pays;
        this.organisme = organisme;
    }

    public Long getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Long idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }
}
