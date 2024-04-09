import java.util.List;

public interface Participant {
    public void participer(Epreuve epv);
    public String getNom();
    public List<Object> getParticipants();
    public int getScore();
    public void setScore(int score);
}