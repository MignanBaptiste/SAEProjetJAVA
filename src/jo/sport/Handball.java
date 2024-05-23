package jo.sport;

public class Handball extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     * @param coeffForce Coefficient de force pour ce sport
     * @param coeffAgilite Coefficient d'agilité pour ce sport
     * @param coeffEndurance Coefficient d'endurance pour ce sport
     */
    public Handball (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 4;
        this.coeffAgilite = 4;
        this.coeffForce = 3;
    }
}