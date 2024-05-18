package jo;
import java.util.ArrayList;
import java.util.List;

public class Pays {
    private String nomPays;
    private List<Equipe> equipes;
    private List<Athlete> athletes;   

    /**
     * Créer un nouveau pays avec une liste d'équipes
     * et une liste d'athlètes vide.
     * @param pays
     */
    public Pays(String pays) {
        this.nomPays = pays;
        this.equipes = new ArrayList<>();
        this.athletes = new ArrayList<>();
    }

    /**
     * Renvoie le nom du pays.
     * @return
     */
    public String getNom() {

    }

    /**
     * Renvoie la liste des equipes du pays.
     * @return
     */
    public List<Equipe> getEquipes() {

    }

    /**
     * Renvoie la liste des athlètes du pays.
     * @return
     */
    public List<Athlete> getAthletes() {

    }
    
    /**
     * Permet d'ajouter une équipe à la liste d'équipes du pays
     * @param equipe
     */
    public void ajouteEquipe(Equipe equipe) {

    }

    /**
     * Permet d'ajouter un athlète à la liste des athlètes
     * @param athlete
     */
    public void ajouteAthlete(Athlete athlete) {

    }
}
