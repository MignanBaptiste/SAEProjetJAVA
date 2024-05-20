package jo;

import java.util.ArrayList;
import java.util.List;

import jo.exception.InvalidTypeException;

// Classe représentant une équipe participant à une compétition
public class Equipe implements Participant, Comparable<Equipe>{
    private String nomEquipe; // Le nom de l'équipe
    private int score; // Le score de l'équipe
    private final Pays pays; // Le pays auquel appartient l'équipe
    private List<Athlete> athletes; // La liste des athlètes de l'équipe

    /**
     * Création d'une nouvelle équipe avec un nom, un pays et une liste d'athlètes.
     * @param nomEquipe Le nom de l'équipe.
     * @param pays Le pays auquel appartient l'équipe.
     */
    public Equipe(String nomEquipe, Pays pays) {
        this.nomEquipe = nomEquipe;
        this.pays = pays;
        this.score = 0;
        this.athletes = new ArrayList<>();
    }

    /**
     * Renvoie le nom de l'équipe.
     * @return String Le nom de l'équipe.
     */
    public String getNom() {
        return this.nomEquipe;
    }

    /**
     * Renvoie le score de l'équipe.
     * @return int Le score de l'équipe.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Met à jour le score de l'équipe en y ajoutant le score donné en paramètre.
     * @param score Le score à ajouter.
     */
    public void setScore(int score) {
        this.score += score;        
    }

    /**
     * Renvoie le pays auquel appartient l'équipe.
     * @return Pays Le pays de l'équipe.
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * Renvoie la liste des athlètes de l'équipe.
     * @return List<Athlete> La liste des athlètes de l'équipe.
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }

    /**
     * Ajoute un athlète à l'équipe et met à jour le score de l'équipe.
     * @param ath L'athlète à ajouter.
     */
    public void addAthlete(Athlete ath) {
        this.athletes.add(ath);
        this.score += ath.getScore();
        ath.ajoutEquipe(this);
    }

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
     * Compare deux équipes en fonction de leur score.
     * @param e L'équipe à comparer.
     * @return int Renvoie un entier négatif, zéro ou positif selon que le score de cette équipe est inférieur, égal ou supérieur à celui de l'équipe comparée.
     */
    @Override
    public int compareTo(Equipe e){
        return e.score - this.score; // Compare les scores pour déterminer l'ordre de tri
    }
}
