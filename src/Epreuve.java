import java.util.List;

public abstract class Epreuve {
    private String sexe;
    private Sport sport;
    private List<Participant> participants;
    public Epreuve(String sexe, Sport sport){}
    public String getSexe(){return "";}
    public Sport getSport(){return null;}
    public void addParticipant(Participant participant){};
    public List<Participant> getParticipants(){return null;}
    public Participant gagnant(){return null;}
    public List<Participant> classement(){return null;}
}
