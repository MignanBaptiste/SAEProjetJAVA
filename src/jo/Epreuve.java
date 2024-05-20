package jo;

import java.util.ArrayList;
import java.util.List;

import jo.exception.InvalidTypeException;
import jo.sport.Sport;

/** Class permettant de créer une épreuve ayant des participants */
public class Epreuve<T>{
    private Sexe sexe;
    private Sport sport;
    private List<T> participants;
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
    public void addParticipant(T participant) throws InvalidTypeException {
        if(!(this.participants.isEmpty())){
            if(participant instanceof Athlete && participants.get(0) instanceof Athlete){
                this.participants.add(participant);
            }
            else if(participant instanceof Equipe && participants.get(0) instanceof Equipe){
                this.participants.add(participant);
            }
            else{
                throw new InvalidTypeException();
            }
        } //Ces 2 tests permettent de créer des épreuves constituées uniquement d'équipe ou uniquement d'athlete
        else if(this.participants.isEmpty()){
            this.participants.add(participant);}
    }
    
    /**
     * Renvoie la liste des participants à l'épreuve
     * @return List<Participant>
     */
    public List<T> getParticipants(){return this.participants;}
    
    /**
     * Renvoie le gagnant de l'épreuve (pas d'information sur le comment du choix du gagnat, nous la laisson donc vide)
     * @return Participant
     */
    public T gagnant(){return null;}
}
