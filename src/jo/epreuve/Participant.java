package jo.epreuve;

/** Interface Participant contenant les méthodes pour qu'un(e) Athlète/Equipe participe à une épreuve */
public interface Participant {
    /**
     * Permet d'ajouter un participant à une épreuve
     * @param epv
     */
    public void participer(Epreuve epv);
    /**
     * Renvoie le nom d'un participant
     * @return String
     */
    public String getNom();
    /**
     * Renvoie le score d'un participant
     * @return
     */
    public int getScore();
    /**
     * Permet de définir le score d'un athlète
     * @param score
     */
    public void setScore(int score);
}