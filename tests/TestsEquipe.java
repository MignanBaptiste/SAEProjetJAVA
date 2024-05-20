import jo.*;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

public class TestsEquipe {
    private Pays france;
    private Athlete ath1;
    private Athlete ath2;
    private Equipe equ1;

    @Before
    public void setUp() {
        france = new Pays("France");
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        equ1 = new Equipe("equ1", france);
    }

    /** On veut pouvoir créer une nouvelle équipe  */
    @Test
    public void testEquipe(){
        assertNotNull(equ1);
    }

    /** On veut obtenir le nom de l'équipe */
    @Test
    public void testGetNomEquipe(){
        assertEquals("equ1", equ1.getNom());
    }

    /** On veut obtenir le score de l'équipe et le modifier */
    @Test
    public void testGetScore(){
        assertEquals(0, equ1.getScore());

        equ1.setScore(100);
        assertEquals(100, equ1.getScore());
    }

    /** On veut obtenir le pays de l'équipe */
    @Test
    public void testGetPays(){
        assertEquals(france, equ1.getPays());
    }

    /** On veut pouvoir ajouter un athlète à l'équipe */
    @Test
    public void testAddAthletes(){
        equ1.addAthlete(new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france));
        assertEquals(equ1.getAthletes().size(), 1);
    }

    /** On veut obtenir les athlètes de l'équpe */
    @Test
    public void testGetAthletes(){
        equ1.addAthlete(ath1);
        equ1.addAthlete(ath2);
        assertEquals(Arrays.asList(ath1, ath2), equ1.getAthletes());
    }

    /** On veut ajouter une équipe à une épreuve */
    @Test
    public void testParticiper(){
        equ1.addAthlete(ath1);
        Sport escrime = new Escrime("Escrime", 1);
        Epreuve epv1 = new Epreuve(Sexe.HOMME, escrime);
        equ1.participer(epv1);
    }
}
