package world.cup.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Session_de_formation {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="Session_id")
    private Long idSession;
    @Column(name="Lieu")
    private String lieu;
    @Column(name="Nb_participant")
    private int nb_participant;
    @Column(name="Datedebut")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    private Date  dateDebut;
    @Column(name="DateFin")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    private Date  dateFin;

    @Column(name="ListeParticipants")
    @ManyToMany( fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "participation",
            joinColumns = {@JoinColumn(name = "session_id")},inverseJoinColumns = {@JoinColumn(name = "participant_id")})
    Set<Participant> participantList=new HashSet<>();


    @ManyToOne
    private Formateur formateur;


    @ManyToOne
    private Organisme organisme;

    public Session_de_formation(Long idSession, String lieu, int nb_participant, Date dateDebut, Date dateFin, Set<Participant> participantList, Formateur formateur, Organisme organisme) {
        this.idSession = idSession;
        this.lieu = lieu;
        this.nb_participant = nb_participant;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.participantList = participantList;
        this.formateur = formateur;
        this.organisme = organisme;
    }

    public Session_de_formation() {

    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNb_participant() {
        return nb_participant;
    }

    public void setNb_participant(int nb_participant) {
        this.nb_participant = nb_participant;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Set<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(Set<Participant> participantList) {
        this.participantList = participantList;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }
}

