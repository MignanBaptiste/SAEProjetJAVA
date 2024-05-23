package jo;

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

    public Equipe getEquipe();

    public Pays getPays();

    public int getForce();

    public int getAgilite();

    public int getEndurance();
    
}