package jo.sport;

public class Athletisme extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     * @param coeffForce Coefficient de force pour ce sport
     * @param coeffAgilite Coefficient d'agilité pour ce sport
     * @param coeffEndurance Coefficient d'endurance pour ce sport
     */
    public Athletisme (String categorie){
        super(categorie);
        this.coeffForce = 4;
        this.coeffAgilite = 3;
        this.coeffForce = 3;
    }
}