package jo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jo.exception.InvalidTypeException;
import jo.sport.Sport;

/** Class permettant de créer une épreuve ayant des participants */
public class Epreuve<T extends Participant>{
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
     * Renvoie le gagnant de l'épreuve
     * @return Participant
     */
    public HashMap<T, Integer> resultats(){
        HashMap<T, Integer> res = new HashMap<>();
        for(T participant: this.participants){
            int score = 0;
            score = participant.getForce() * this.sport.getCoeffForce();
            score += participant.getAgilite() * this.sport.getCoeffAgilite();
            score += participant.getEndurance() * this.sport.getCoeffEndurance();
            res.put(participant, score);
        }
        List<T> participantsTri = new ArrayList<>(this.participants);
        participantsTri.sort((p1, p2) -> res.get(p2).compareTo(res.get(p1)));
        participantsTri.get(0).getEquipe().getClassement().addOr(1);
        participantsTri.get(1).getEquipe().getClassement().addArgent(1);
        participantsTri.get(2).getEquipe().getClassement().addBronze(1);
        return res;
    }

    public List<T> classementEpv(){
        HashMap<T, Integer> res = this.resultats();
        List<T> participantsTri = new ArrayList<>(this.participants);
        participantsTri.sort((p1, p2) -> res.get(p2).compareTo(res.get(p1))); //Tri par ordre décroissant des scores
        return participantsTri;
    }
}
