package jo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jo.exception.InvalidTypeException;
import jo.sport.Sport;

/** Class permettant de créer une épreuve ayant des participants */
public class Epreuve<T extends Participant>{
    private Sexe sexe; // Le sexe de l'épreuve
    private Sport sport; // Le sport de l'épreuve
    private List<T> participants; // La liste des participants à l'épreuve

    /**
     * Permet de créer une épreuve.
     * @param sexe Le sexe de l'épreuve.
     * @param sport Le sport de l'épreuve.
     */
    public Epreuve(Sexe sexe, Sport sport){
        this.sexe = sexe;
        this.sport = sport;
        this.participants = new ArrayList<>();
    }

    /**
     * Renvoie le sexe de l'épreuve.
     * @return Sexe Le sexe de l'épreuve.
     */
    public Sexe getSexe(){return this.sexe;}

    /**
     * Renvoie le sport de l'épreuve.
     * @return Sport Le sport de l'épreuve.
     */
    public Sport getSport(){return this.sport;}
    
    /**
     * Permet d'ajouter un participant à une épreuve.
     * @param participant Le participant à ajouter.
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
        } // Ces 2 tests permettent de créer des épreuves constituées uniquement d'équipe ou uniquement d'athlete
        else if(this.participants.isEmpty()){
            this.participants.add(participant);
        }
    }
    
    /**
     * Renvoie la liste des participants à l'épreuve.
     * @return List<Participant> La liste des participants à l'épreuve.
     */
    public List<T> getParticipants(){return this.participants;}
    
    /**
     * Renvoie le résultat de l'épreuve.
     * @return HashMap<T, Integer> Le résultat de l'épreuve.
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
        participantsTri.sort((p1, p2) -> res.get(p2).compareTo(res.get(p1))); //tri par ordre décroissant du nombre de points
        participantsTri.get(0).getEquipe().getPays().getClassement().addOr(1); //on ajoute pour les 3 premiers une médaille
        if (participantsTri.size() >= 2) {participantsTri.get(1).getEquipe().getPays().getClassement().addArgent(1);}
        if (participantsTri.size() >= 3) {participantsTri.get(2).getEquipe().getPays().getClassement().addBronze(1);} 
        return res;
    }

    /**
     * Renvoie le classement de l'épreuve.
     * @return List<T> Le classement de l'épreuve.
     */
    public List<T> classementEpv(){
        HashMap<T, Integer> res = this.resultats();
        List<T> participantsTri = new ArrayList<>(this.participants);
        participantsTri.sort((p1, p2) -> res.get(p2).compareTo(res.get(p1))); // Tri par ordre décroissant des scores
        return participantsTri;
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet Epreuve.
     * @return Représentation sous forme de chaîne.
     */
    public String toString() {
        if (this.sexe.equals(Sexe.FEMME)){
            return "Epreuve de " + this.sport.getCategorie() + " Féminin";
        }
        else{
            return "Epreuve de " + this.sport.getCategorie() + " Masculin";
        }
    }

    @Override
    /**
     * Vérifie si cet objet est égal à l'objet spécifié.
     * 
     * @param o l'objet à comparer avec cet objet
     * @return true si les objets sont égaux, false sinon
     */
    public boolean equals(Object o){
        if (o == null){return false;}
        if (this == o){return true;}
        if (!(o instanceof Epreuve)){return false;}
        Epreuve e = (Epreuve) o;
        return this.sport.equals(e.getSport()) && this.participants.equals(e.getParticipants());
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.sport.hashCode() * this.participants.size()) / 17 ;
    }
}
