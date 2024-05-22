package jo;

public class Executable {
    public static void main(String[] args) {
        JeuxOlympiques jo = new JeuxOlympiques(2021);
        jo.load_csv("../donnees.csv");
    }
}
