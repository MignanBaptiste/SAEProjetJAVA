package jo;
public class Epreuve {
    private String sexe;
    private Sport sport;
    private abstract List<Object> participants;
    public Epreuve(String sexe, Sport sport){

    }
    public String getSexe(){
        return "";
    }
    public Sport getSport(){
        return Sport();
    }
    public abstract void addParticipant();
}
