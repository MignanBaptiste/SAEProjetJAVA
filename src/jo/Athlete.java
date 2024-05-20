package jo;

/**
 * Représente un athlète participant à des compétitions.
 * Implémente les interfaces Participant et Comparable<Athlete>.
 */
public class Athlete implements Participant, Comparable<Athlete> {
    private String nomAthlete;
    private String prenomAthlete;
    private Sexe sexe;
    private int force;
    private int agilite;
    private int endurance;
    private int score;
    private Pays pays;
    private Equipe equipe;

    /**
     * Crée un nouvel athlète avec les informations spécifiées.
     * @param nom Nom de l'athlète.
     * @param prenom Prénom de l'athlète.
     * @param sexe Sexe de l'athlète.
     * @param force Force de l'athlète.
     * @param agilite Agilité de l'athlète.
     * @param endurance Endurance de l'athlète.
     * @param score Score initial de l'athlète.
     * @param pays Pays de l'athlète.
     */
    public Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, int score, Pays pays) {
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
     * Crée un nouvel athlète avec les informations spécifiées (ajout de l'équipe).
     * @param nom Nom de l'athlète.
     * @param prenom Prénom de l'athlète.
     * @param sexe Sexe de l'athlète.
     * @param force Force de l'athlète.
     * @param agilite Agilité de l'athlète.
     * @param endurance Endurance de l'athlète.
     * @param score Score initial de l'athlète.
     * @param pays Pays de l'athlète.
     * @param equipe Equipe de l'athlète.
     */
    public Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, int score, Pays pays, Equipe equipe) {
        this.nomAthlete = nom;
        this.prenomAthlete = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.score = score;
        this.pays = pays;
        this.equipe = equipe;
    }

    /**
     * Ajoute une équipe à l'athlète.
     * @param equ Une équipe.
     */
    public void ajoutEquipe(Equipe equ){
        this.equipe = equ;
    }

    /**
     * Renvoie le nom de l'athlète.
     * @return Nom de l'athlète.
     */
    public String getNomAthlete() {
        return this.nomAthlete;
    }

    /**
     * Renvoie le prénom de l'athlète.
     * @return Prénom de l'athlète.
     */
    public String getPrenomAthlete() {
        return this.prenomAthlete;
    }

    /**
     * Renvoie le sexe de l'athlète.
     * @return Sexe de l'athlète.
     */
    public Sexe getSexe() {
        return this.sexe;
    }

    /**
     * Renvoie la force de l'athlète.
     * @return Force de l'athlète.
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Renvoie l'agilité de l'athlète.
     * @return Agilité de l'athlète.
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Renvoie l'endurance de l'athlète.
     * @return Endurance de l'athlète.
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Renvoie le pays auquel appartient l'athlète.
     * @return Pays de l'athlète.
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * Renvoie l'équipe à laquelle appartient l'athlète.
     * @return Équipe de l'athlète.
     */
    public Equipe getEquipe() {
        return this.equipe;
    }

    /**
     * Renvoie le score de l'athlète.
     * @return Score de l'athlète.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Renvoie le nom complet de l'athlète.
     * @return Nom complet de l'athlète.
     */
    public String getNom() {
        return this.nomAthlete + " " + this.prenomAthlete;
    }

    /**
     * Met à jour le score de l'athlète et de son équipe en y ajoutant le score donné en paramètre.
     * @param score Score à ajouter.
     */
    public void setScore(int score) {
        this.score += score;
        this.equipe.setScore(score);
    }

    /**
     * Permet à l'athlète de participer à une épreuve.
     * @param epreuve L'épreuve à laquelle l'athlète participe.
     */
    public void participer(Epreuve epreuve) {
        epreuve.addParticipant(this);
    }

    @Override
    /**
     * Compare cet athlète à un autre athlète pour l'ordre naturel.
     * Les athlètes sont triés par ordre décroissant de score.
     * @param ath L'athlète à comparer.
     * @return Un nombre négatif, zéro ou un nombre positif si cet athlète est respectivement moins performant, égal ou plus performant que l'athlète spécifié.
     */
    public int compareTo(Athlete ath) {
        return ath.getScore() - this.getScore();
    }
}
