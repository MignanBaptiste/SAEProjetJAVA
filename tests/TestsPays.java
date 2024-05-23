import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

public class TestsPays {
    private Pays france;
    private Equipe equ1;
    private Equipe equ2;
    private Athlete ath1;
    private Athlete ath2;

    @Before
    public void setUp() {
        france = new Pays("France");
        equ1 = new Equipe("equ1", france);
        equ2 = new Equipe("equ2", france);
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
    }

    /** On veut pouvoir créer un nouveau pays  */
    @Test
    public void testPays(){
        assertNotNull(france);
    }

    /** On veut obtenir le nom du pays */
    @Test
    public void testGetNomPays(){
        assertEquals("France", france.getNom());
    }

    /** On veut pouvoir ajouter une équipe au pays */
    @Test
    public void testAjouteEquipe(){
        france.ajouteEquipe(equ1);
        assertEquals(1, france.getEquipes().size());
    }

    /** On veut pouvoir ajouter un athlète au pays */
    @Test
    public void testAjouteAthlete(){
        france.ajouteAthlete(ath1);
        assertEquals(1, france.getAthletes().size());
    }

    /** On veut obtenir les équipes du pays */
    @Test
    public void testGetEquipes(){
        france.ajouteEquipe(equ1);
        france.ajouteEquipe(equ2);
        assertEquals(Arrays.asList(equ1, equ2), france.getEquipes());
    }

    /** On veut obtenir les athlètes du pays */
    @Test
    public void testGetAthletes(){
        france.ajouteAthlete(ath1);
        france.ajouteAthlete(ath2);
        assertEquals(Arrays.asList(ath1, ath2), france.getAthletes());
    }
}
