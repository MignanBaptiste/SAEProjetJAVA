package jo.sport;

public class VolleyBall extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     * @param nbjoueurs Le nombre de joueurs dans le sport.
     */
    public VolleyBall (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 3;
        this.coeffAgilite = 5;
        this.coeffForce = 2;
    }
}