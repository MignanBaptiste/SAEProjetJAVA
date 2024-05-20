import jo.*;
import jo.exception.InvalidTypeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class TestEpreuve {
    private VolleyBall volleyBall;
    private Epreuve individuelle;
    private Epreuve collective;

    @Before
    public void setUp() {
        volleyBall = new VolleyBall("Volley", 14);
        individuelle = new Epreuve(Sexe.HOMME, volleyBall);
        collective = new Epreuve(Sexe.FEMME, volleyBall);
    }

    /** Test de récupération du sexe de l'épreuve */
    @Test
    public void testGetSexe() {
        assertEquals(Sexe.HOMME, individuelle.getSexe());
        assertEquals(Sexe.FEMME, collective.getSexe());
    }

    /** Test de récupération du sport de l'épreuve */
    @Test
    public void testGetSport() {
        assertEquals(volleyBall, individuelle.getSport());
        assertEquals(volleyBall, collective.getSport());
    }

    /** Test d'ajout des participants (devrait être null au départ) */
    @Test
    public void testAddParticipants() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);

        Equipe equipe = new Equipe("equ1", france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        try {
            individuelle.addParticipant(ath1);
            individuelle.addParticipant(ath2);
            collective.addParticipant(equipe);
            individuelle.addParticipant(equipe); //ne doit pas marcher
            collective.addParticipant(ath2); //ne doit pas marcher
        } catch (InvalidTypeException e) {
        }
        assertEquals(individuelle.getParticipants().size(), 2);
        assertEquals(collective.getParticipants().size(), 1);
        
    }

    /** Test de récupération des participants (devrait être null au départ) */
    @Test
    public void testGetParticipants() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        Equipe equipe = new Equipe("equ1", france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        try {
            individuelle.addParticipant(ath1);
            individuelle.addParticipant(ath2);
            collective.addParticipant(equipe);
            
        } catch (InvalidTypeException e) {}
        
        try {
            individuelle.addParticipant(equipe); //ne doit pas marcher
        } catch (Exception e) {}
        
        try {
            collective.addParticipant(ath2); //ne doit pas marcher
            } catch (Exception e) {}
        assertEquals(individuelle.getParticipants(), Arrays.asList(ath1, ath2));
        assertEquals(collective.getParticipants(), Arrays.asList(equipe));
        
    }
}

