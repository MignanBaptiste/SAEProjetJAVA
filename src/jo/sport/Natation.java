package jo.sport;

public class Natation extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     * @param coeffForce Coefficient de force pour ce sport
     * @param coeffAgilite Coefficient d'agilité pour ce sport
     * @param coeffEndurance Coefficient d'endurance pour ce sport
     */
    public Natation (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 3;
        this.coeffAgilite = 2;
        this.coeffForce = 5;
    }
}
