package jo;

import jo.exception.InvalidTypeException;

/**
 * Représente un athlète participant à des compétitions.
 * Implémente les interfaces Participant et Comparable<Athlete>.
 */
public class Athlete implements Participant {
    private String nomAthlete;
    private String prenomAthlete;
    private Sexe sexe;
    private int force;
    private int agilite;
    private int endurance;
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
     * @param pays Pays de l'athlète.
     */
    public Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, Pays pays) {
        this.nomAthlete = nom;
        this.prenomAthlete = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
        this.pays.ajouteAthlete(this);
    }

    /**
     * Crée un nouvel athlète avec les informations spécifiées (ajout de l'équipe).
     * @param nom Nom de l'athlète.
     * @param prenom Prénom de l'athlète.
     * @param sexe Sexe de l'athlète.
     * @param force Force de l'athlète.
     * @param agilite Agilité de l'athlète.
     * @param endurance Endurance de l'athlète.
     * @param pays Pays de l'athlète.
     * @param equipe Equipe de l'athlète.
     */
    public Athlete(String nom, String prenom, Sexe sexe, int force, int agilite, int endurance, Pays pays, Equipe equipe) {
        this.nomAthlete = nom;
        this.prenomAthlete = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
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
     * Renvoie le nom complet de l'athlète.
     * @return Nom complet de l'athlète.
     */
    public String getNom() {
        return this.nomAthlete + " " + this.prenomAthlete;
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
    * Permet à l'athlète de participer à une épreuve.
    * @param epreuve L'épreuve à laquelle l'athlète participe.
    */
    public void participer(Epreuve epreuve) {
        try {
            epreuve.addParticipant(this);
        } catch (InvalidTypeException e) {
            System.out.println("Impossible de participer à cette épreuve.");
        }
    }
}
