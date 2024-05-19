package jo.epreuve;
import java.util.ArrayList;
import java.util.List;

import jo.Sexe;
import jo.sport.Sport;
/** Class permettant de créer une épreuve ayant des participants */
public abstract class Epreuve {
    private Sexe sexe;
    private Sport sport;
    private List<Object> participants;
    /**
     * Permet de créer une épreuve
     * @param sexe
     * @param sport
     */
    public Epreuve(Sexe sexe, Sport sport){
        this.sexe = sexe;
        this.sport = sport;
        this.participants = new ArrayList<>();
    }
    /**
     * Renvoie le sexe de l'épreuve
     * @return String
     */
    public Sexe getSexe(){return this.sexe;}
    /**
     * Renvoie le sport de l'épreuve
     * @return Sport
     */
    public Sport getSport(){return this.sport;}
    /**
     * Permet d'ajouter un participant à une épreuve
     * @param participant
     */
    public void addParticipant(Object participant){this.participants.add(participant);}
    /**
     * Renvoie la liste des participants à l'épreuve
     * @return List<Participant>
     */
    public List<Object> getParticipants(){return this.participants;}
    /**
     * Renvoie le gagnant de l'épreuve
     * @return Participant
     */
    public Participant gagnant(){return null;}
    /**
     * Renvoie la liste des participants triée selon leur classement
     * @return
     */
    public List<Participant> classement(){return null;}
}
