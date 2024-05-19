package jo.epreuve;

import jo.Sexe;
import jo.sport.Sport;

/** Class d'épreuve individuelle, hérite de la classe Epreuve */
public class Individuelle extends Epreuve{
    /**
     * Permet de créer une épreuve individuelle
     * @param sexe
     * @param sport
     */
    public Individuelle(Sexe sexe, Sport sport){super(sexe, sport);}
}
