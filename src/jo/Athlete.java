package jo;
import java.util.ArrayList;
import java.util.List;

public class Athlete implements Participant{
    private String nomAthlete;
    private String prenomAthlete;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    private int score;
    private Pays pays;

    /**
     * Créer un nouvel athlète
     * @param nom
     * @param prenom
     * @param sexe
     * @param force
     * @param agilite
     * @param endurance
     * @param score
     */
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance, int score, Pays pays) {
        this.nomAthlete = nom;
        this.prenomAthlete = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.score = score;
        this.pays = pays;
    }

    /**
     * Revoie le nom de l'athlète
     * @return
     */
    public String getNomAthlete() {
        return this.nomAthlete;
    }

    /**
     * Renvoie le prenom de l'athlète
     * @return
     */
    public String getPrenomAthlete() {
        return this.prenomAthlete;
    }

    /**
     * Renvoie le sexe de l'athlète
     * @return
     */
    public String getSexe() {
        return this.sexe;
    }

    /**
     * Renvoie la force de l'athlète
     * @return
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Renvoie l'agilité de l'athlète
     * @return
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Renvoie l'endurance de l'athlète
     * @return
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Renvoie le score de l'athlète
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Renovie le pays auquel appartient l'athlète
     * @return
     */
    public Pays getPays() {
        return this.pays;
    }
}