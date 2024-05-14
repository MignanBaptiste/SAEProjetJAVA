package jo.sport;

public abstract class Sport {
    private String categorie;
    private int nbjoueurs;

    /**
     * Permet de créer un tout nouveau sport
     */
    public Sport(String categorie, int nbjoueurs){
        this.categorie = categorie;
        this.nbjoueurs = nbjoueurs;

    }

    /**
     * Renvoie la categorie d'un sport
     * @return la catégorie du sport
     */
    public String getCategorie(){
        return this.categorie;

    }

    /**
     * Renvoie le nombre de joueur d'un sport (ex: 12 joueurs pour le volley sans compter les remplaçants)
     * @return le nombre de joueurs du sport
     */
    public int getNbjoueurs(){
        return this.nbjoueurs;
    }
}
