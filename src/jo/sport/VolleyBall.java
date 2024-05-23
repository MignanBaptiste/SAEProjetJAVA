package jo.sport;

public class VolleyBall extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport
     * @param coeffForce Coefficient de force pour ce sport
     * @param coeffAgilite Coefficient d'agilité pour ce sport
     * @param coeffEndurance Coefficient d'endurance pour ce sport
     */
    public VolleyBall (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 3;
        this.coeffAgilite = 5;
        this.coeffForce = 2;
    }
}