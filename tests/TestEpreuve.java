import jo.*;
import jo.exception.InvalidTypeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.HashMap;

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

    /** Test de l'ajout d'un participant individuel */
    @Test
    public void testAddParticipantIndividuel() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        try {
            individuelle.addParticipant(ath1);
        } catch (InvalidTypeException e) {
            // gestion de l'exception
        }
        assertEquals(1, individuelle.getParticipants().size());
        assertEquals(ath1, individuelle.getParticipants().get(0));
    }

    /** Test de l'ajout d'une équipe comme participant */
    @Test
    public void testAddParticipantEquipe() {
        Pays france = new Pays("France");
        Equipe equipe = new Equipe(france);
        try {
            collective.addParticipant(equipe);
        } catch (InvalidTypeException e) {
            // gestion de l'exception
        }
        assertEquals(1, collective.getParticipants().size());
        assertEquals(equipe, collective.getParticipants().get(0));
    }

    /** Test du résultat de l'épreuve 
     * @throws InvalidTypeException */
    @Test
    public void testResultats() throws InvalidTypeException {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france); 
        Equipe equipe = new Equipe(france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        collective.addParticipant(equipe);
        
        // Calcul manuel des scores attendus
        int scoreAttendu = 0;
        scoreAttendu += ath1.getForce() * volleyBall.getCoeffForce();
        scoreAttendu += ath1.getAgilite() * volleyBall.getCoeffAgilite();
        scoreAttendu += ath1.getEndurance() * volleyBall.getCoeffEndurance();
        scoreAttendu += ath2.getForce() * volleyBall.getCoeffForce();
        scoreAttendu += ath2.getAgilite() * volleyBall.getCoeffAgilite();
        scoreAttendu += ath2.getEndurance() * volleyBall.getCoeffEndurance();
        
        // Vérification du résultat obtenu
        HashMap<Equipe, Integer> resultats = collective.resultats();
        assertEquals(1, resultats.size());
        assertEquals((Integer)scoreAttendu, resultats.get(equipe));
    }

    /** Test du classement de l'épreuve */
    @Test
    public void testClassementEpreuve() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france); 
        Equipe equipe = new Equipe(france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        try {
            collective.addParticipant(equipe);
        } catch (InvalidTypeException e) {
            // gestion de l'exception
        }
        
        // Vérification du classement
        assertEquals(1, collective.classementEpv().size());
        assertEquals(equipe, collective.classementEpv().get(0));
    }

    /** Test de récupération des participants */
    @Test
    public void testGetParticipants() {
        Pays france = new Pays("France");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france); 
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france); 
        Equipe equipe = new Equipe(france);
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
