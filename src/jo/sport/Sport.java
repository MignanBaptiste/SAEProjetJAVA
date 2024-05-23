package jo.sport;

/**
 * Cette classe représente un sport abstrait.
 */
public abstract class Sport {
    private String categorie; // La catégorie du sport
    protected int coeffForce;
    protected int coeffAgilite;
    protected int coeffEndurance;

    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     * @param nbjoueurs Le nombre de joueurs dans le sport.
     */
    public Sport(String categorie){
        this.categorie = categorie;
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
    public int getCoeffForce(){
        return this.coeffForce;
    }

    public int getCoeffAgilite(){
        return this.coeffAgilite;
    }

    public int getCoeffEndurance(){
        return this.coeffEndurance;
    }
}

