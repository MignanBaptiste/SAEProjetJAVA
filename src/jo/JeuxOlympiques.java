package jo;
public class JeuxOlympiques{

    private int annee;

    /**
     * Le constructeur
     * @param annee
     */
    public JeuxOlympiques(int annee){
        this.annee = annee;
    }

    /**
     * 
     * @return toutes les épreuves
     */
    public epreuves getEpreuves(){
        
    }

    /**
     * Ajoute l'épreuve dans la liste d'épreuves
     * @param epv
     */
    public void addEpreuve(Epreuve epv){
        
    }

    /**
     * Fait participer un athlète à une épreuve donnée
     * @param ath
     * @param epv
     */
    public void participerAthlete(Athlete ath, Epreuve epv){

    }

    /**
     * Fait participer une équipe à une épreuve donnée
     * @param equ
     * @param epv
     */
    public void participerEquipe(Equipe equ, Epreuve epv){

    }

    /**
     * Renvoie le score d'un athlète
     * @param ath
     * @return 
     */
    public int getScoreAthlete(Athlete ath){

    }

    /**
     * Renvoie le score d'un équipe
     * @param equ
     * @return 
     */
    public int getScoreEquipe(Equipe equ){
        
    }

    /**
     * Modifie le score d'une équipe
     * @param equ
     * @return 
     */
    public void setScoreEquipe(Equipe equ){

    }

    /**
     * Modifie le score d'un athlète
     * @param ath
     * @return 
     */
    public void setScoreAthlète(Athlete ath){

    }
}