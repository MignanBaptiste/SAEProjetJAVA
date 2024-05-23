package jo.sport;

public class Natation extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     * @param nbjoueurs Le nombre de joueurs dans le sport.
     */
    public Natation (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 3;
        this.coeffAgilite = 2;
        this.coeffForce = 5;
    }
}
