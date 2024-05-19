package jo;

import java.util.ArrayList;
import java.util.List;

import jo.epreuve.*;

public class JeuxOlympiques{

    private int annee;
    private List<Epreuve> lesepreuves;

    /**
     * Le constructeur
     * @param annee
     */
    public JeuxOlympiques(int annee){
        this.annee = annee;
        this.lesepreuves = new ArrayList<>();
    }

    /**
     * 
     * @return toutes les épreuves
     */
    public List<Epreuve> getEpreuves(){
        return this.lesepreuves;
        
    }

    /**
     * Ajoute l'épreuve dans la liste d'épreuves
     * @param epv
     */
    public void addEpreuve(Epreuve epv){
        this.lesepreuves.add(epv);
        
    }

    /**
     * Fait participer un athlète à une épreuve donnée
     * @param ath
     * @param epv
     */
    public void participerAthlete(Athlete ath, Individuelle epv){ //AMELIORER
        epv.addParticipant(ath);

    }

    /**
     * Fait participer une équipe à une épreuve donnée
     * @param equ
     * @param epv
     */
    public void participerEquipe(Equipe equ, Epreuve epv){ //IDEM
        epv.addParticipant(equ);

    }

    /**
     * Renvoie le score d'un athlète
     * @param ath
     * @return 
     */
    public int getScoreAthlete(Athlete ath){
        return ath.getScore();

    }

    /**
     * Renvoie le score d'un équipe
     * @param equ
     * @return 
     */
    public int getScoreEquipe(Equipe equ){
        return equ.getScore();
        
    }

    /**
     * Modifie le score d'une équipe
     * @param equ
     * @return 
     */
    public void setScoreEquipe(Equipe equ, int score){
        equ.setScore(score);

    }

    /**
     * Modifie le score d'un athlète
     * @param ath
     * @return 
     */
    public void setScoreAthlète(Athlete ath, int score){
        ath.setScore(score);

    }

    public int getAnnee(){
        return this.annee;
    }
}