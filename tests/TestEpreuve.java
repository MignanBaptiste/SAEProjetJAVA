import jo.*;
import jo.exception.InvalidTypeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class TestEpreuve {
    private VolleyBall volleyBall;
    private Epreuve<Athlete> individuelle; // Mise à jour du type d'Epreuve
    private Epreuve<Equipe> collective; // Mise à jour du type d'Epreuve

    @Before
    public void setUp() {
        volleyBall = new VolleyBall("Volley");
        individuelle = new Epreuve<>(Sexe.HOMME, volleyBall); // Utilisation de type paramétré
        collective = new Epreuve<>(Sexe.FEMME, volleyBall); // Utilisation de type paramétré
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

    /** Test d'ajout des participants */
    @Test
    public void testAddParticipants() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france); 

        Equipe equipe = new Equipe("equ1", france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        try {
            individuelle.addParticipant(ath1);
            individuelle.addParticipant(ath2);
            collective.addParticipant(equipe);
        } catch (InvalidTypeException e) {
            // gestion de l'exception
        }
        assertEquals(2, individuelle.getParticipants().size());
        assertEquals(1, collective.getParticipants().size());
    }

    /** Test de récupération des participants */
    @Test
    public void testGetParticipants() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france); 
        Equipe equipe = new Equipe("equ1", france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        try {
            individuelle.addParticipant(ath1);
            individuelle.addParticipant(ath2);
            collective.addParticipant(equipe);

        } catch (InvalidTypeException e) {
            // gestion de l'exception
        }

        assertEquals(Arrays.asList(ath1, ath2), individuelle.getParticipants());
        assertEquals(Arrays.asList(equipe), collective.getParticipants());

    }
}
