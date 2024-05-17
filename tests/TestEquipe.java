package tests;
import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

public class TestEquipe {
    /** On veut pouvoir créer une nouvelle équipe  */
    @Test
    public void testEquipe(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
    }

    /** On veut obtenir le nom de l'équipe */
    @Test
    public void testGetNomEquipe(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        assertEquals("equ1", equ1.getNomEquipe());
    }

    /** On veut obtenir le score de l'équipe */
    @Test
    public void testGetScore(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        assertEquals(0, equ1.getScore());

        equ1.setScore(100);
        assertEquals(100, equ1.getScore());
    }

    /** On veut obtenir le pays de l'équipe */
    @Test
    public void testGetPays(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        assertEquals(france, equ1.getPays());
    }

    /** On veut pouvoir ajouter un athlète à l'équipe */
    @Test
    public void testAddAthletes(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        equ1.addAthlete(new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france));
    }

    /** On veut obtenir les athlètes de l'équpe */
    @Test
    public void testGetAthletes(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        Equipe equ1 = new Equipe("equ1", france);
        equ1.addAthlete(ath1);
        assertEquals(Arrays.asList(ath1, ath2), equ1.getAthletes());
    }
}
