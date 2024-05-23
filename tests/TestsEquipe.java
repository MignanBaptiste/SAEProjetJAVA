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
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
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

    /** On veut obtenir le pays de l'équipe */
    @Test
    public void testGetPays(){
        assertEquals(france, equ1.getPays());
    }

    /** On veut pouvoir ajouter un athlète à l'équipe */
    @Test
    public void testAddAthletes(){
        equ1.addAthlete(new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france));
        assertEquals(1, equ1.getAthletes().size());
    }

    /** On veut obtenir les athlètes de l'équipe */
    @Test
    public void testGetAthletes(){
        equ1.addAthlete(ath1);
        equ1.addAthlete(ath2);
        assertEquals(Arrays.asList(ath1, ath2), equ1.getAthletes());
    }

    /** On veut ajouter une équipe à une épreuve */
    @Test
    public void testParticiper(){
        Sport escrime = new Escrime("Escrime");
        Epreuve epv1 = new Epreuve(Sexe.HOMME, escrime);
        equ1.participer(epv1);
        assertEquals(1, epv1.getParticipants().size());
    }
}
