import jo.Epreuve;
import jo.Participant;
import java.util.ArrayList;
import java.util.List;

public class JeuxOlympiques{

    private int annee;
    private List<Epreuve>epreuves;

    /**
     * Le constructeur
     * @param annee
     */
    public JeuxOlympiques(int annee){
        this.annee = annee;
        this.epreuves = new ArrayList<>();
    }

    /**
     * 
     * @return toutes les épreuves
     */
    public List<Epreuve> getEpreuves(){
        List<Epreuve> liste = new ArrayList<Epreuve>() ;
        for(int i=0; i< epreuves.size(); ++i){
            liste.add(epreuves.get(i));
        }
        return liste;

    }

    /**
     * Ajoute l'épreuve dans la liste d'épreuves
     * @param epv
     */
    public void addEpreuve(Epreuve epv){
        this.epreuves.add(epv);
    }

    /**
     * Fait participer un athlète à une épreuve donnée
     * @param ath
     * @param epv
     */
    public void participerAthlete(Athlete ath, Epreuve epv){
        epv.addParticipant(ath);
    }

    /**
     * Fait participer une équipe à une épreuve donnée
     * @param equ
     * @param epv
     */
    public void participerEquipe(Equipe equ){

    }

    /**
     * Renvoie le score d'un athlète
     * @param ath
     * @return 
     */
    public int getScoreAthlete(Athlete ath){
        return getScoreAthlete(ath);
    }

    /**
     * Renvoie le score d'un équipe
     * @param equ
     * @return 
     */
    public int getScoreEquipe(Equipe equ){
        return getScoreEquipe(equ);
    }

    /**
     * Modifie le score d'une équipe
     * @param equ
     * @return 
     */
    public void setScoreEquipe(Equipe equ){
        setScore(getScoreEquipe(equ));
    }

    /**
     * Modifie le score d'un athlète
     * @param ath
     * @return 
     */
    public void setScoreAthlète(Athlete ath){
        
    }
}