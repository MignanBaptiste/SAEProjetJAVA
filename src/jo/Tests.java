package jo;
public class Tests {
    public static void main(String []args){

        JeuxOlympiques jeux2024 = new JeuxOlympiques(2024);
        Athlete ath1 = new Athlete("Dena", "Paul", "Homme", 40, 25, 31, 5);
        Athlete ath2 = new Athlete("Dupond", "Emma", "Femme", 20, 51, 30, 15);
        Equipe equipe1 = new Equipe("Lion", 35);
        Sport hand = new Sport("equipe",6) ;
        Sport volley = new Sport("equipe", 5) ;
        Epreuve epreuveH = new Epreuve("Homme", hand);

    }
}