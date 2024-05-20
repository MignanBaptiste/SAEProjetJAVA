package jo;

import java.util.ArrayList;
import java.util.List;

// Classe représentant un pays participant à une compétition
public class Pays {
    private String nomPays; // Le nom du pays
    private List<Equipe> equipes; // Liste des équipes du pays
    private List<Athlete> athletes; // Liste des athlètes du pays   

    /**
     * Créer un nouveau pays avec une liste d'équipes
     * et une liste d'athlètes vide.
     * @param pays Le nom du pays.
     */
    public Pays(String pays) {
        this.nomPays = pays;
        this.equipes = new ArrayList<>();
        this.athletes = new ArrayList<>();
    }

    /**
     * Renvoie le nom du pays.
     * @return String Le nom du pays.
     */
    public String getNom() {
        return this.nomPays;
    }

    /**
     * Renvoie la liste des équipes du pays.
     * @return List<Equipe> La liste des équipes du pays.
     */
    public List<Equipe> getEquipes() {
        return this.equipes;
    }

    /**
     * Renvoie la liste des athlètes du pays.
     * @return List<Athlete> La liste des athlètes du pays.
     */
    public List<Athlete> getAthletes() {
        return this.athletes;
    }
    
    /**
     * Permet d'ajouter une équipe à la liste d'équipes du pays.
     * @param equipe L'équipe à ajouter.
     */
    public void ajouteEquipe(Equipe equipe) {
        this.equipes.add(equipe);
    }

    /**
     * Permet d'ajouter un athlète à la liste des athlètes du pays.
     * @param athlete L'athlète à ajouter.
     */
    public void ajouteAthlete(Athlete athlete) {
        this.athletes.add(athlete);
    }
}

