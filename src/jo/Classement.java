package jo;

/**
 * Représente le classement d'une équipe ou d'un participant dans une compétition.
 */
public class Classement {

    private int medailleOr; // Le nombre de médailles d'or
    private int medailleArgent; // Le nombre de médailles d'argent
    private int medailleBronze; // Le nombre de médailles de bronze

    /**
     * Initialise un classement avec aucun médaille.
     */
    public Classement(){
        this.medailleOr = 0;
        this.medailleArgent = 0;
        this.medailleBronze = 0;
    }

    /**
     * Renvoie le nombre de médailles d'or.
     * @return Le nombre de médailles d'or.
     */
    public int getOr(){
        return this.medailleOr;
    }

    /**
     * Renvoie le nombre de médailles d'argent.
     * @return Le nombre de médailles d'argent.
     */
    public int getArgent(){
        return this.medailleArgent;
    }

    /**
     * Renvoie le nombre de médailles de bronze.
     * @return Le nombre de médailles de bronze.
     */
    public int getBronze(){
        return this.medailleBronze;
    }

    /**
     * Ajoute un nombre de médailles d'or au classement.
     * @param nb Le nombre de médailles d'or à ajouter.
     */
    public void addOr(int nb){
        this.medailleOr += nb;
    }

    /**
     * Ajoute un nombre de médailles d'argent au classement.
     * @param nb Le nombre de médailles d'argent à ajouter.
     */
    public void addArgent(int nb){
        this.medailleArgent += nb;
    }

    /**
     * Ajoute un nombre de médailles de bronze au classement.
     * @param nb Le nombre de médailles de bronze à ajouter.
     */
    public void addBronze(int nb){
        this.medailleBronze += nb;
    }

    /**
     * Renvoie le nombre de médailles totales.
     * @return int Le nombre de médailles totales.
     */
    public int totalMedailles(){
        return this.medailleBronze + this.medailleArgent + this.medailleOr;
    }
}

