import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

public class TestEquipe {
    @Test
    public void testEquipe(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
    }

    @Test
    public void testGetNomEquipe(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        assertEquals("equ1", equ1.getNomEquipe());
    }

    @Test
    public void testGetScore(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        assertEquals(0, equ1.getScore());

        equ1.setScore(100);
        assertEquals(100, equ1.getScore());
    }

    @Test
    public void testGetPays(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        assertEquals(france, equ1.getPays());
    }

    @Test
    public void testAddAthletes(){
        Pays france = new Pays("France");
        Equipe equ1 = new Equipe("equ1", france);
        equ1.addAthlete(new Athletes("Manaudou", "Florent", "male", 56, 87, 78, 34));
    }

    @Test
    public void testGetAthletes(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45);
        Equipe equ1 = new Equipe("equ1", france);
        equ1.addAthlete(ath1);
        assertEquals(Arrays.asList(ath1, ath2), equ1.getAthletes());
    }
}
