package jo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import jo.exception.InvalidTypeException;

// Classe représentant les Jeux Olympiques
public class JeuxOlympiques {

    private int annee; // L'année des Jeux Olympiques
    private List<Epreuve> lesEpreuves; // Liste des épreuves des Jeux Olympiques

    /**
     * Constructeur de la classe JeuxOlympiques.
     * 
     * @param annee L'année des Jeux Olympiques.
     */
    public JeuxOlympiques(int annee) {
        this.annee = annee;
        this.lesEpreuves = new ArrayList<>();
    }

    /**
     * Renvoie l'année des Jeux Olympiques.
     * 
     * @return int L'année des Jeux Olympiques.
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Renvoie toutes les épreuves des Jeux Olympiques.
     * 
     * @return List<Epreuve> Liste de toutes les épreuves des Jeux Olympiques.
     */
    public List<Epreuve> getEpreuves() {
        return this.lesEpreuves;
    }

    /**
     * Ajoute une épreuve à la liste des épreuves des Jeux Olympiques.
     * 
     * @param epv L'épreuve à ajouter.
     */
    public void addEpreuve(Epreuve epv) {
        this.lesEpreuves.add(epv);
    }

    /**
     * Calcule le nombre de médailles par pays.
     * 
     * @return HashMap<Pays, HashMap<String, Integer>> Nombre de médailles par pays.
     */
    public HashMap<Pays, HashMap<String, Integer>> medaillesParPays() {
        HashMap<Pays, HashMap<String, Integer>> res = new HashMap<>();
        HashSet<Equipe> equipesTraitees = new HashSet<>();
        
        // Parcours de toutes les épreuves
        for (Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                if (participant instanceof Equipe) {
                    Equipe equipe = (Equipe) participant;
                    // Vérifier si l'équipe a déjà été traitée
                    if (!equipesTraitees.contains(equipe)) {
                        Pays pays = equipe.getPays();
                        // Mise à jour des médailles pour le pays de l'équipe
                        HashMap<String, Integer> medailles = res.getOrDefault(pays, new HashMap<>());
                        medailles.merge("Medailles d'or", equipe.getClassement().getOr(), Integer::sum);
                        medailles.merge("Medailles d'argent", equipe.getClassement().getArgent(), Integer::sum);
                        medailles.merge("Medailles de bronze", equipe.getClassement().getBronze(), Integer::sum);
                        res.put(pays, medailles);
                        // Ajouter l'équipe à l'ensemble des équipes traitées
                        equipesTraitees.add(equipe);
                    }
                }
            }
        }
        return res;
    }

    
    /**
     * Renvoie la liste des pays classés par nombre de médailles d'or.
     * 
     * @return List<Pays> Liste des pays classés par nombre de médailles d'or.
     */
    public List<Pays> medaillesOr() {
        List<Pays> res = new ArrayList<>();
        HashMap<Pays, Integer> medaillesOr = new HashMap<>();
        HashSet<Equipe> equipesTraitees = new HashSet<>();
        
        // Parcours de toutes les épreuves
        for (Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                if (participant instanceof Equipe) {
                    Equipe equipe = (Equipe) participant;
                    // Vérifier si l'équipe a déjà été traitée
                    if (!equipesTraitees.contains(equipe)) {
                        Pays pays = equipe.getPays();
                        // Mise à jour du nombre de médailles d'or pour le pays de l'équipe
                        medaillesOr.merge(pays, equipe.getClassement().getOr(), Integer::sum);
                        // Ajouter l'équipe à l'ensemble des équipes traitées
                        equipesTraitees.add(equipe);
                    }
                }   
            }
        }
    
        // Tri des pays en fonction du nombre de médailles d'or
        res.addAll(medaillesOr.keySet());
        res.sort((p1, p2) -> medaillesOr.get(p2).compareTo(medaillesOr.get(p1)));
        return res;
    }


    /**
     * Renvoie la liste des pays classés par nombre total de médailles.
     * 
     * @return List<Pays> Liste des pays classés par nombre total de médailles.
     */
    public List<Pays> medaillesTotales() {
        List<Pays> res = new ArrayList<>();
        HashMap<Pays, Integer> medaillesTotales = new HashMap<>();
        HashSet<Equipe> equipesTraitees = new HashSet<>();
        
        // Parcours de toutes les épreuves
        for (Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                if (participant instanceof Equipe) {
                    Equipe equipe = (Equipe) participant;
                    // Vérifier si l'équipe a déjà été traitée
                    if (!equipesTraitees.contains(equipe)) {
                        Pays pays = equipe.getPays();
                        // Calcul du nombre total de médailles pour le pays de l'équipe
                        int total = equipe.getClassement().getOr() + equipe.getClassement().getArgent()
                                + equipe.getClassement().getBronze();
                        // Mise à jour du nombre total de médailles pour le pays
                        medaillesTotales.merge(pays, total, Integer::sum);
                        // Ajouter l'équipe à l'ensemble des équipes traitées
                        equipesTraitees.add(equipe);
                    }
                }
            }
        }
        
        // Tri des pays en fonction du nombre total de médailles
        res.addAll(medaillesTotales.keySet());
        res.sort((p1, p2) -> medaillesTotales.get(p2).compareTo(medaillesTotales.get(p1)));
        return res;
    }
}





