package jo;

import java.util.ArrayList;
import java.util.List;

import jo.exception.InvalidTypeException;

// Classe représentant une équipe participant à une compétition
public class Equipe implements Participant{
    private final Pays pays; // Le pays auquel appartient l'équipe
    private List<Athlete> athletes; // La liste des athlètes de l'équipe
    

    /**
     * Création d'une nouvelle équipe avec un nom, un pays et une liste d'athlètes.
     * @param nomEquipe Le nom de l'équipe.
     * @param pays Le pays auquel appartient l'équipe.
     */
    public Equipe(Pays pays) {
        this.pays = pays;
        this.athletes = new ArrayList<>();
    }

    /**
     * Renvoie la liste des athlètes de l'équipe.
     * @return List<Athlete> La liste des athlètes de l'équipe.
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }

    /**
     * Ajoute un athlète à l'équipe et ajoute l'équipe à l'athlète.
     * @param ath L'athlète à ajouter.
     */
    public void addAthlete(Athlete ath) {
        this.athletes.add(ath);
        ath.ajoutEquipe(this);
    }

    @Override
    /**
     * Renvoie le nom du pays de l'équipe.
     * @return String nom du pays de l'équipe.
     */
    public String getNom() {
        return this.pays.getNom();
    }

    @Override
    /**
     * Renvoie l'équipe elle-même.
     * @return Equipe L'équipe elle-même.
     */
    public Equipe getEquipe(){
        return this;
    }

    @Override
    /**
     * Renvoie la somme des forces de tous les athlètes de l'équipe.
     * @return int La somme des forces de tous les athlètes de l'équipe.
     */
    public int getForce(){
        int totalF = 0;
        for(Athlete a : this.athletes){
            totalF += a.getForce();
        }
        return totalF;
    }

    @Override
    /**
     * Renvoie la somme des agilités de tous les athlètes de l'équipe.
     * @return int La somme des agilités de tous les athlètes de l'équipe.
     */
    public int getAgilite(){
        int totalA = 0;
        for(Athlete a : this.athletes){
            totalA += a.getAgilite();
        }
        return totalA;
    }

    @Override
    /**
     * Renvoie la somme des endurances de tous les athlètes de l'équipe.
     * @return int La somme des endurances de tous les athlètes de l'équipe.
     */
    public int getEndurance(){
        int totalE = 0;
        for(Athlete a : this.athletes){
            totalE += a.getEndurance();
        }
        return totalE;
    }

    @Override
    /**
     * Renvoie le pays auquel appartient l'équipe.
     * @return Pays Le pays de l'équipe.
     */
    public Pays getPays() {
        return this.pays;
    }

    @Override
    /**
     * Permet à l'équipe de participer à une épreuve en ajoutant l'équipe comme participant.
     * @param epreuve L'épreuve à laquelle l'équipe participe.
     */
    public void participer(Epreuve epreuve) {
        try {
            epreuve.addParticipant(this);
        } catch (InvalidTypeException e) {
            System.out.println("Impossible de participer à cette épreuve.");
        }
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'équipe.
     * @return La représentation de l'équipe sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return "Cette équipe représente le pays suivant : " + pays.getNom();
    }
}

