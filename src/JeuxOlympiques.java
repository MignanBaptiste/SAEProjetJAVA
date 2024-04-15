public class JeuxOlympiques{

    private int annee;

    public JeuxOlympiques(int annee){
        this.annee = annee;
    }

    /* Retourne les épreuves dans la liste d'épreuves */
    public epreuves getEpreuves(){
        
    }

    /* Ajoute une épreuve dans la la liste d'épreuves */
    public void addEpreuve(Epreuve epv){
        epreuves.add(epv);
    }

    /* Fait participer un athlète à une épreuve donnée */
    public void participerAthlete(Athlete ath, Epreuve epv){

    }

    /*  Fait participer une équipe à une épreuve donnée*/
    public void participerEquipe(Equipe equ, Epreuve epv){

    }

    /* Renvoy le score d'un athlète */
    public int getScoreAthlete(Athlete ath){

    }

    /* Renvoy le score d'un équipe */
    public int getScoreEquipe(Equipe equ){
        
    }

    /* Modifie le score d'une équipe */
    public int setScoreEquipe(Equipe equ){

    }

    /* Modifie le score d'un athlète */
    public int setScoreAthlète(Athlete ath){

    }
}