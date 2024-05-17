package tests;
import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestAthlete {
    /** On veut pouvoir créer un nouvel athlète */
    @Test
    public void testAthlete(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
    }

    /** On veut obtenir le nom de l'athlète */
    @Test
    public void testGetNomAthlete(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals("Manaudou", ath1.getNomAthlete());
        assertEquals("Riner", ath2.getNomAthlete());
    }

    /** On veut obtenir le prénom de l'athlète */
    @Test
    public void testGetPrenomAthlete(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals("Florent", ath1.getPrenomAthlete());
        assertEquals("Teddy", ath2.getPrenomAthlete());
    }

    /** On veut obtenir sex de l'athlète */
    @Test
    public void testGetSexe(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals("male", ath1.getSexe());
        assertEquals("male", ath2.getSexe());
    }

    /** On veut obtenir la force de l'athlète */
    @Test
    public void testGetForce(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals(56, ath1.getForce());
        assertEquals(89, ath2.getForce());
    }

    /** On veut obtenir l'agilité de l'athlète */
    @Test
    public void testGetAgilite(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals(87, ath1.getAgilite());
        assertEquals(67, ath2.getAgilite());
    }

    /** On veut obtenir l'endurance de l'athlète */
    @Test
    public void testGetEndurance(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals(78, ath1.getEndurance());
        assertEquals(53, ath2.getEndurance());
    }

    /** On veut obtenir le score de l'athlète */
    @Test
    public void testGetScore(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals(34, ath1.getScore());
        assertEquals(45, ath2.getScore());
    }

    /** On veut obtenir le pays de l'athlète */
    @Test
    public void testGetPays(){
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", "male", 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", "male", 89, 67, 53, 45, france);
        assertEquals(france, ath1.getPays());
        assertEquals(france, ath2.getPays());
    }
}
