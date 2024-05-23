package jo.sport;

public class Handball extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     * @param nbjoueurs Le nombre de joueurs dans le sport.
     */
    public Handball (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 4;
        this.coeffAgilite = 4;
        this.coeffForce = 3;
    }
}