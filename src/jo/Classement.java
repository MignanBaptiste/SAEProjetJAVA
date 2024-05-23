package jo;

public class Classement {

    private int medailleOr;
    private int medailleArgent;
    private int medailleBronze;

    public Classement(){
        this.medailleOr = 0;
        this.medailleArgent = 0;
        this.medailleBronze = 0;
    }

    public int getOr(){
        return this.medailleOr;
    }

    public int getArgent(){
        return this.medailleArgent;
    }

    public int getBronze(){
        return this.medailleBronze;
    }

    public void addOr(int nb){
        this.medailleOr += nb;
    }

    public void addArgent(int nb){
        this.medailleArgent += nb;
    }

    public void addBronze(int nb){
        this.medailleBronze += nb;
    }
    
}
