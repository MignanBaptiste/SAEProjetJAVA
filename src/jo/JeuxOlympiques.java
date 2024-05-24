package jo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import jo.exception.InvalidTypeException;
import jo.sport.Athletisme;
import jo.sport.Escrime;
import jo.sport.Handball;
import jo.sport.Natation;
import jo.sport.Sport;
import jo.sport.VolleyBall;

// Classe représentant les Jeux Olympiques
public class JeuxOlympiques{

    private int annee; // L'année des Jeux Olympiques
    private List<Pays> lespays; // Liste des pays participant aux Jeux Olympiques
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
        this.lespays = new ArrayList<>();
    }

    /**
     * Renvoie la liste des pays participant aux Jeux Olympiques.
     * @return List<Pays> Liste des pays participant aux Jeux Olympiques.
     */
    public List<Pays> getPays(){
        return this.lespays;
    }

    /**
     * Ajoute un pays à la liste des pays participant aux Jeux Olympiques.
     * @param pays Le pays à ajouter.
     */
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
     * Renvoie toutes les épreuves des Jeux Olympiques.
     * @return List<Epreuve> Liste de toutes les épreuves des Jeux Olympiques.
     */
    public List<Epreuve> getEpreuves(){
        return this.lesEpreuves;
    }

    /**
     * Ajoute une épreuve à la liste des épreuves des Jeux Olympiques.
     * @param epv L'épreuve à ajouter.
     */
    public void addEpreuve(Epreuve epv){
        this.lesEpreuves.add(epv);
    }

    /**
     * Renvoie tous les athlètes des Jeux Olympiques.
     * @return List<Epreuve> Liste de tous les athlètes des Jeux Olympiques.
     */
    public List<Athlete> getAthletes(){
        return this.lesAthletes;
    }

    /**
     * Ajoute un athlète à la liste des athlètes des Jeux Olympiques.
     * @param ath L'athlète à ajouter.
     */
    public void addAthlete(Athlete ath){
        this.lesAthletes.add(ath);
    }

    /**
     * Renvoie toutes les équipes des Jeux Olympiques.
     * @return List<Equipe> Liste de toutes les équipes des Jeux Olympiques.
     */
    public List<Equipe> getEquipes(){
        return this.lesEquipes;
    }

    /**
     * Ajoute une équipe à la liste des équipes des Jeux Olympiques.
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

    /**
     * Calcule le nombre de médailles par pays.
     * @return HashMap<Pays, HashMap<String, Integer>> Nombre de médailles par pays.
     */
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

    /**
     * Renvoie la liste des pays classés par nombre de médailles d'or.
     * @return List<Pays> Liste des pays classés par nombre de médailles d'or.
     */
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

    /**
     * Renvoie la liste des pays classés par nombre total de médailles.
     * @return List<Pays> Liste des pays classés par nombre total de médailles.
     */
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

    public void load_csv(String chemin) throws InvalidTypeException{
        // Chargement d'un fichier CSV où chaque ligne est une liste
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
    }
        } catch (IOException e) {
            System.out.println("Fichier invalide");
        }
        // Création des instances de class
        for (List<String> liste : records){
            Sexe sexe;
            if (liste.get(2).equals("homme")){
                sexe = Sexe.HOMME;
            }
            else{
                sexe = Sexe.FEMME;
            }
            Sport sport;
            if (liste.get(4).contains("Athlétisme") || liste.get(4).contains("Athétisme")){
                sport = new Athletisme(liste.get(4));
            }
            else if (liste.get(4).contains("Escrime")){
                sport = new Escrime(liste.get(4));
            }
            else if (liste.get(4).contains("Handball")){
                sport = new Handball(liste.get(4));
            }
            else if (liste.get(4).contains("Natation")){
                sport = new Natation(liste.get(4));
            }
            else if (liste.get(4).contains("Volley-Ball")){
                sport = new VolleyBall(liste.get(4));
            }
            else{
                throw new InvalidTypeException();
            }
            Athlete ath = new Athlete(liste.get(0), liste.get(1), sexe, Integer.valueOf(liste.get(5)), Integer.valueOf(liste.get(6)), Integer.valueOf(liste.get(7)), new Pays(liste.get(4)));
            // Si la catégorie de l'épreuve contient ces mots clés, c'est une épreuve collective
            if (liste.get(4).contains("relais") || liste.get(4).contains("Handball") || liste.get(4).contains("Volley-Ball")){
                Epreuve<Equipe> epv = new Epreuve<>(sexe, sport);
                Equipe eqp = new Equipe(ath.getPays().getNom(), ath.getPays());
                eqp.addAthlete(ath);
                epv.addParticipant(eqp);
                this.lesEpreuves.add(epv);
            }
            else{
                Epreuve<Athlete> epv = new Epreuve<>(sexe, sport);
                epv.addParticipant(ath);
                this.lesEpreuves.add(epv);
            }
        }
    }

    public void load_database(){

    }

    public void save_database(){

    }
}

