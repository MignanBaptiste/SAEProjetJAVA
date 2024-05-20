package jo.sport;

/**
 * Cette classe représente un sport abstrait.
 */
public abstract class Sport {
    private String categorie; // La catégorie du sport
    private int nbjoueurs; // Le nombre de joueurs dans le sport

    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     * @param nbjoueurs Le nombre de joueurs dans le sport.
     */
    public Sport(String categorie, int nbjoueurs){
        this.categorie = categorie;
        this.nbjoueurs = nbjoueurs;
    }

    /**
     * Renvoie la catégorie du sport.
     * @return La catégorie du sport.
     */
    public String getCategorie(){
        return this.categorie;
    }

    /**
     * Renvoie le nombre de joueurs dans le sport.
     * @return Le nombre de joueurs dans le sport.
     */
    public int getNbjoueurs(){
        return this.nbjoueurs;
    }
}

