import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class TestsPays {
    private Pays france;
    private Pays espagne;

    @Before
    public void setUp() {
        france = new Pays("France");
        espagne = new Pays("Espagne");
    }

    /** Test de création d'un nouveau pays et de l'obtention de son nom */
    @Test
    public void testPays(){
        assertEquals("France", france.getNom());
        assertEquals("Espagne", espagne.getNom());
    }

    /** Test d'ajout et de récupération des équipes du pays */
    @Test
    public void testEquipes(){
        Equipe equ1 = new Equipe("equ1", france);
        Equipe equ2 = new Equipe("equ2", france);
        Equipe equ3 = new Equipe("equ3", espagne);
        Equipe equ4 = new Equipe("equ4", espagne);
        
        france.ajouteEquipe(equ1);
        france.ajouteEquipe(equ2);
        espagne.ajouteEquipe(equ3);
        espagne.ajouteEquipe(equ4);
        
        List<Equipe> equipesFrance = france.getEquipes();
        List<Equipe> equipesEspagne = espagne.getEquipes();
        
        assertEquals(2, equipesFrance.size());
        assertEquals(2, equipesEspagne.size());
        assertEquals(Arrays.asList(equ1, equ2), equipesFrance);
        assertEquals(Arrays.asList(equ3, equ4), equipesEspagne);
    }

    /** Test d'ajout et de récupération des athlètes du pays */
    @Test
    public void testAthletes(){
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        Athlete ath3 = new Athlete("Garcia", "Jesus", Sexe.HOMME, 39, 58, 84, 54, espagne);
        Athlete ath4 = new Athlete("Canales", "Elia", Sexe.FEMME, 64, 43, 56, 67, espagne);
        
        france.ajouteAthlete(ath1);
        france.ajouteAthlete(ath2);
        espagne.ajouteAthlete(ath3);
        espagne.ajouteAthlete(ath4);
        
        List<Athlete> athletesFrance = france.getAthletes();
        List<Athlete> athletesEspagne = espagne.getAthletes();
        
        assertEquals(2, athletesFrance.size());
        assertEquals(2, athletesEspagne.size());
        assertEquals(Arrays.asList(ath1, ath2), athletesFrance);
        assertEquals(Arrays.asList(ath3, ath4), athletesEspagne);
    }
}

