package jo;

import java.util.Scanner;

import jo.exception.InvalidTypeException;

public class Executable {
    public static void main(String[] args) {
        JeuxOlympiques jo = new JeuxOlympiques(2021);
        try {
            jo.load_csv("./donnees.csv");
        } catch (InvalidTypeException e) {
            System.out.println("Problème de chargement des données");
        }
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        while (!quitter){

            // Menu
            System.out.println("###################################################################");
            System.out.println("# Que voulez-vous faire ? (écrivez simplement la première lettre) #");
            System.out.println("# V - Voir les données                                            #");
            System.out.println("# S - Simulation des épreuves                                     #");
            System.out.println("# M - Modifier les données                                        #");
            System.out.println("# A - Afficher les médailles des pays                             #");
            System.out.println("# C - Consultation statistiques des résultats                     #");
            System.out.println("# Q - Quitter                                                     #");
            System.out.println("###################################################################");

            String entrer = scanner.next();
            entrer = entrer.toUpperCase();
            // récupération, saisie et modification des données
            if (entrer.equals("V")){
                System.out.println("Il y a " + jo.getNbEpreuves() + " épreuves en " + jo.getAnnee());
                System.out.println("Il y a " + jo.getNbAthletes() + " athlètes qui participe aux " + jo);
                System.out.println("Il y a " + jo.getNbEquipes() + " équipe qui participe aux " + jo);
                System.out.println("Il y a " + jo.getNbPays() + " pays qui participe aux " + jo);
                System.out.println("N'EST PAS FINI POUR LE MOMENT");
            }
            else if (entrer.equals("M")){
                System.out.println("NE MARCHE PAS POUR LE MOMENT");
            }

            // Simulation des épreuves.
            else if (entrer.equals("S")){
                // ...
                System.out.println("NE MARCHE PAS POUR LE MOMENT");
                System.out.println("Les épreuves se sont bien déroulés.");
            }

            // Consultation statistiques des résultats selon divers critères.
            else if (entrer.equals("C")){
                System.out.println("NE MARCHE PAS POUR LE MOMENT");
            }

            // Récupérer les médailles pour les pays.
            else if (entrer.equals("Q")){
                quitter = true;
            }

            else{
                System.out.println(entrer + " n'est pas une option");
            }

        }
        scanner.close();
    }
}
