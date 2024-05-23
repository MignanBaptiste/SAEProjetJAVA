package jo.sport;

/**
 * Cette classe représente un sport abstrait.
 */
public abstract class Sport {
    private String categorie; // La catégorie du sport
    protected int coeffForce; // Coefficient de force pour ce sport
    protected int coeffAgilite; // Coefficient d'agilité pour ce sport
    protected int coeffEndurance; // Coefficient d'endurance pour ce sport

    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
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
     * Renvoie le coefficient de force pour ce sport.
     * @return Le coefficient de force pour ce sport.
     */
    public int getCoeffForce(){
        return this.coeffForce;
    }

    /**
     * Renvoie le coefficient d'agilité pour ce sport.
     * @return Le coefficient d'agilité pour ce sport.
     */
    public int getCoeffAgilite(){
        return this.coeffAgilite;
    }

    /**
     * Renvoie le coefficient d'endurance pour ce sport.
     * @return Le coefficient d'endurance pour ce sport.
     */
    public int getCoeffEndurance(){
        return this.coeffEndurance;
    }
}


