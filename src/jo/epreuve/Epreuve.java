package jo.epreuve;
import java.util.ArrayList;
import java.util.List;
/** Class permettant de créer une épreuve ayant des participants */
public abstract class Epreuve {
    private String sexe;
    private Sport sport;
    private List<Participant> participants;
    /**
     * Permet de créer une épreuve
     * @param sexe
     * @param sport
     */
    public Epreuve(String sexe, Sport sport){
        this.sexe = sexe;
        this.sport = sport;
        this.participants = new ArrayList<>();
    }
    /**
     * Renvoie le sexe de l'épreuve
     * @return String
     */
    public String getSexe(){return this.sexe;}
    /**
     * Renvoie le sport de l'épreuve
     * @return Sport
     */
    public Sport getSport(){return this.sport;}
    /**
     * Permet d'ajouter un participant à une épreuve
     * @param participant
     */
    public void addParticipant(Participant participant){this.participants.add(participant);}
    /**
     * Renvoie la liste des participants à l'épreuve
     * @return List<Participant>
     */
    public List<Participant> getParticipants(){return this.participants;}
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
