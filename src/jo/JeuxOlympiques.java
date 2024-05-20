package jo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Classe représentant les Jeux Olympiques
public class JeuxOlympiques{

    private int annee; // L'année des Jeux Olympiques
    private List<Epreuve> lesEpreuves; // Liste des épreuves des Jeux Olympiques
    private List<Athlete> lesAthletes; // Liste des athlètes des Jeux Olympiques
    private List<Equipe> lesEquipes; // Liste des équipes des Jeux Olympiques

    /**
     * Constructeur de la classe JeuxOlympiques.
     * @param annee L'année des Jeux Olympiques.
     */
    public JeuxOlympiques(int annee){
        this.annee = annee;
        this.lesEpreuves = new ArrayList<>();
        this.lesAthletes = new ArrayList<>();
        this.lesEquipes = new ArrayList<>();
    }

    /**
     * Ajoute un athlète à une équipe.
     * @param ath L'athlète à ajouter.
     * @param equ L'équipe à laquelle ajouter l'athlète.
     */
    public void ajoutAth(Athlete ath, Equipe equ){
        equ.addAthlete(ath);
    }

    /**
     * Renvoie toutes les épreuves.
     * @return List<Epreuve> Liste de toutes les épreuves.
     */
    public List<Epreuve> getEpreuves(){
        return this.lesEpreuves;
        
    }

    /**
     * Ajoute une épreuve à la liste des épreuves.
     * @param epv L'épreuve à ajouter.
     */
    public void addEpreuve(Epreuve epv){
        this.lesEpreuves.add(epv);
        
    }

    /**
     * Renvoie tous les athlètes.
     * @return List<Epreuve> Liste de tous les athlètes.
     */
    public List<Epreuve> getAthletes(){
        return this.lesEpreuves;
        
    }

    /**
     * Ajoute un athlète à la liste des athlètes.
     * @param ath L'athlète à ajouter.
     */
    public void addAthlete(Athlete ath){
        this.lesAthletes.add(ath);
        
    }

    /**
     * Renvoie toutes les équipes.
     * @return List<Equipe> Liste de toutes les équipes.
     */
    public List<Equipe> getEquipes(){
        return this.lesEquipes;
        
    }

    /**
     * Ajoute une équipe à la liste des équipes.
     * @param equ L'équipe à ajouter.
     */
    public void addEquipe(Equipe equ){
        this.lesEquipes.add(equ);
        
    }

    /**
     * Fait participer un athlète à une épreuve donnée.
     * @param ath L'athlète à faire participer.
     * @param epv L'épreuve à laquelle l'athlète participe.
     */
    public void participerAthlete(Athlete ath, Epreuve epv){ 
        epv.addParticipant(ath);
    }

    /**
     * Fait participer une équipe à une épreuve donnée.
     * @param equ L'équipe à faire participer.
     * @param epv L'épreuve à laquelle l'équipe participe.
     */
    public void participerEquipe(Equipe equ, Epreuve epv){
        epv.addParticipant(equ);
    }

    /**
     * Renvoie le score d'un athlète.
     * @param ath L'athlète dont on veut le score.
     * @return int Le score de l'athlète.
     */
    public int getScoreAthlete(Athlete ath){
        return ath.getScore();
    }

    /**
     * Renvoie le score d'une équipe.
     * @param equ L'équipe dont on veut le score.
     * @return int Le score de l'équipe.
     */
    public int getScoreEquipe(Equipe equ){
        return equ.getScore();
    }

    /**
     * Met à jour le score d'une équipe en lui ajoutant le score rentré en paramètre.
     * @param equ L'équipe dont on veut mettre à jour le score.
     * @param points Le nombre de points à ajouter au score de l'équipe.
     */
    public void setScoreEquipe(Equipe equ, int points){
        equ.setScore(points);
    }

    /**
     * Met à jour le score d'un athlète et de son équipe en leur ajoutant le nombre de points donné en paramètre.
     * @param ath L'athlète dont on veut mettre à jour le score.
     * @param points Le nombre de points à ajouter au score de l'athlète et de son équipe.
     */
    public void setScoreAthlète(Athlete ath, int points){
        ath.setScore(points);
    }

    /**
     * Renvoie l'année des Jeux Olympiques.
     * @return int L'année des Jeux Olympiques.
     */
    public int getAnnee(){
        return this.annee;
    }

    /**
     * Renvoie le classement des athlètes en fonction de leur score.
     * @return List<Athlete> Le classement des athlètes.
     */
    public List<Athlete> classementAth(){
        List<Athlete> res = new ArrayList<>(this.lesAthletes);
        Collections.sort(res);
        return res;
    }

    /**
     * Renvoie le classement des équipes en fonction de leur score.
     * @return List<Equipe> Le classement des équipes.
     */
    public List<Equipe> classementEqu(){
        List<Equipe> res = new ArrayList<>(this.lesEquipes);
        Collections.sort(res);
        return res;
    }
}
