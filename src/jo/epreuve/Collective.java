package jo.epreuve;

import jo.Sexe;
import jo.sport.Sport;

/** Class d'épreuve collective, hérite de la classe Epreuve */
public class Collective extends Epreuve{
    /**
     * Permet de créer une épreuve collective
     * @param sexe
     * @param sport
     */
    public Collective(Sexe sexe, Sport sport){super(sexe, sport);}
}
