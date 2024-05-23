package jo.sport;

public class Escrime extends Sport{
    
    /**
     * Constructeur pour initialiser un nouveau sport.
     * @param categorie La catégorie du sport.
     * @param nbjoueurs Le nombre de joueurs dans le sport.
     */
    public Escrime (String categorie, int nbjoueurs){
        super(categorie);
        this.coeffForce = 2;
        this.coeffAgilite = 5;
        this.coeffForce = 3;
    }
}