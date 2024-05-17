package jo;
import java.util.ArrayList;
import java.util.List;

public class Equipe implements Participant{
    private String nomEquipe;
    private int score;
    private final Pays pays;
    private List<Athlete> athletes;

    /**
     * Création d'une nouvelle équipe
     * possédant un nom, un score, un pays, et une liste d'athlètes.
     * @param ath
     */
    public Equipe(String nomEquipe, Pays pays) {
        this.nomEquipe = nomEquipe;
        this.pays = pays;
        this.score = 0;
        this.athletes = new ArrayList<>();
    }

    /**
     * Renvoie le nom de l'équipe
     * @return
     */
    public String getNomEquipe() {
        return this.nomEquipe;
    }

    /**
     * Renvoie le score de l'équipe
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Renoive le pays auquel appartient l'équipe
     * @return
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * Renvoie la liste des athlètes de l'équipe
     * @return
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }

    /**
     * Ajoute un athlète à l'équipe
     * @param ath
     */
    public void addAthlete(Athlete ath) {
        this.athletes.add(ath);
    }
}
