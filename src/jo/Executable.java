package jo;

import jo.exception.InvalidTypeException;

public class Executable {
    public static void main(String[] args) {
        JeuxOlympiques jo = new JeuxOlympiques(2021);
        try {
            jo.load_csv("./donnees.csv");
            System.out.println(jo.getEpreuves());
        } catch (InvalidTypeException e) {
            System.out.println("Problème de chargement des données");
        }
    }
}
