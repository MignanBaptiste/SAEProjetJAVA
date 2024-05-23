package jo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import jo.exception.InvalidTypeException;

// Classe représentant les Jeux Olympiques
public class JeuxOlympiques{

    private int annee; // L'année des Jeux Olympiques
    private List<Pays> lespays;
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

    public List<Pays> getPays(){
        return this.lespays;
    }

    public void ajoutPays(Pays pays){
        this.lespays.add(pays);
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
    public List<Athlete> getAthletes(){
        return this.lesAthletes;
        
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
    public void participerAthlete(Athlete ath, Epreuve<Athlete> epv){ 
        try {
            epv.addParticipant(ath);
        } catch (InvalidTypeException e) {
            // erreur
        }
    }

    /**
     * Fait participer une équipe à une épreuve donnée.
     * @param equ L'équipe à faire participer.
     * @param epv L'épreuve à laquelle l'équipe participe.
     */
    public void participerEquipe(Equipe equ, Epreuve<Equipe> epv){
        try {
            epv.addParticipant(equ);
        } catch (InvalidTypeException e) {
            // erreur
        }
    }

    public HashMap<Pays, HashMap<String, Integer>> medaillesParPays(){
        HashMap<Pays, HashMap<String, Integer>> res = new HashMap<>();
        for (Pays p: this.lespays){
            int or = 0;
            int argent = 0;
            int bronze = 0;
            for (Equipe e: p.getEquipes()){
                or += e.getClassement().getOr();
                argent += e.getClassement().getArgent();
                bronze += e.getClassement().getBronze();
            }
            HashMap<String, Integer> temp = new HashMap<>();
            temp.put("Medailles d'or", or);
            temp.put("Medailles d'argent", argent);
            temp.put("Medailles de bronze", bronze);
            res.put(p, temp);
        }
        return res;
    }

    public List<Pays> medaillesOr(){
        List<Pays> res = new ArrayList<>(this.lespays);
        HashMap<Pays, Integer> temp = new HashMap<>();
        for (Pays p: this.lespays){
            int or = 0;
            for (Equipe e: p.getEquipes()){
                or += e.getClassement().getOr();
            }
            temp.put(p, or);
        }
        res.sort((p1, p2) -> temp.get(p2).compareTo(temp.get(p1)));
        return res;
    }

    public List<Pays> medaillesTotales(){
        List<Pays> res = new ArrayList<>(this.lespays);
        HashMap<Pays, Integer> temp = new HashMap<>();
        for (Pays p: this.lespays){
            int total = 0;
            for (Equipe e: p.getEquipes()){
                total += e.getClassement().getOr() + e.getClassement().getArgent() + e.getClassement().getBronze();
            }
            temp.put(p, total);
        }
        res.sort((p1, p2) -> temp.get(p2).compareTo(temp.get(p1)));
        return res;
    }
}
