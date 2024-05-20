import jo.*;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

public class TestsJeuxOlympiques {
    private JeuxOlympiques jeuxOlympiques;
    private Pays france;
    private Pays espagne;
    private Athlete ath1;
    private Athlete ath2;
    private Equipe equipe1;
    private Equipe equipe2;
    private Epreuve epreuve1;
    private Epreuve epreuve2;

    @Before
    public void setUp() {
        jeuxOlympiques = new JeuxOlympiques(2024);
        france = new Pays("France");
        espagne = new Pays("Espagne");
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        equipe1 = new Equipe("Equipe1", france);
        equipe2 = new Equipe("Equipe2", espagne);
        epreuve1 = new Epreuve(Sexe.HOMME, new Natation("Natation", 5));
        epreuve2 = new Epreuve(Sexe.FEMME, new VolleyBall("VolleyBall", 12));
    }

    // Teste le constructeur et l'initialisation des listes
    @Test
    public void testConstructeur() {
        assertEquals(2024, jeuxOlympiques.getAnnee());
        assertNotNull(jeuxOlympiques.getEpreuves());
        assertNotNull(jeuxOlympiques.getAthletes());
        assertNotNull(jeuxOlympiques.getEquipes());
    }

    // Teste l'ajout d'un athlète
    @Test
    public void testAjoutAthlete() {
        jeuxOlympiques.addAthlete(ath1);
        jeuxOlympiques.addAthlete(ath2);
        List<Athlete> athletes = jeuxOlympiques.getAthletes();
        assertEquals(2, athletes.size());
        assertEquals(ath1, athletes.get(0));
        assertEquals(ath2, athletes.get(1));
    }

    // Teste l'ajout d'une équipe
    @Test
    public void testAjoutEquipe() {
        jeuxOlympiques.addEquipe(equipe1);
        jeuxOlympiques.addEquipe(equipe2);
        List<Equipe> equipes = jeuxOlympiques.getEquipes();
        assertEquals(2, equipes.size());
        assertEquals(equipe1, equipes.get(0));
        assertEquals(equipe2, equipes.get(1));
    }

    // Teste l'ajout d'une épreuve
    @Test
    public void testAjoutEpreuve() {
        jeuxOlympiques.addEpreuve(epreuve1);
        jeuxOlympiques.addEpreuve(epreuve2);
        List<Epreuve> epreuves = jeuxOlympiques.getEpreuves();
        assertEquals(2, epreuves.size());
        assertEquals(epreuve1, epreuves.get(0));
        assertEquals(epreuve2, epreuves.get(1));
    }

    // Teste la participation d'un athlète à une épreuve
    @Test
    public void testParticiperAthlete() {
        jeuxOlympiques.addEpreuve(epreuve1);
        jeuxOlympiques.participerAthlete(ath1, epreuve1);
        List<Athlete> participants = epreuve1.getParticipants();
        assertEquals(1, participants.size());
        assertEquals(ath1, participants.get(0));
    }

    // Teste la participation d'une équipe à une épreuve
    @Test
    public void testParticiperEquipe() {
        jeuxOlympiques.addEpreuve(epreuve2);
        jeuxOlympiques.participerEquipe(equipe1, epreuve2);
        List<Equipe> participants = epreuve2.getParticipants();
        assertEquals(1, participants.size());
        assertEquals(equipe1, participants.get(0));
    }

    // Teste la récupération du score d'un athlète
    @Test
    public void testScoreAthlete() {
        ath1.setScore(50);
        assertEquals(84, jeuxOlympiques.getScoreAthlete(ath1));
    }

    // Teste la récupération du score d'une équipe
    @Test
    public void testScoreEquipe() {
        equipe1.setScore(100);
        assertEquals(100, jeuxOlympiques.getScoreEquipe(equipe1));
    }

    // Teste le classement des athlètes en fonction de leur score
    @Test
    public void testClassementAthletes() {
        jeuxOlympiques.addAthlete(ath1);
        jeuxOlympiques.addAthlete(ath2);
        ath1.setScore(50);
        ath2.setScore(100);
        List<Athlete> classement = jeuxOlympiques.classementAth();
        assertEquals(ath2, classement.get(0)); // ath2 doit être classé premier
        assertEquals(ath1, classement.get(1)); // ath1 doit être classé deuxième
    }

    // Teste le classement des équipes en fonction de leur score
    @Test
    public void testClassementEquipes() {
        jeuxOlympiques.addEquipe(equipe1);
        jeuxOlympiques.addEquipe(equipe2);
        equipe1.setScore(200);
        equipe2.setScore(100);
        List<Equipe> classement = jeuxOlympiques.classementEqu();
        assertEquals(equipe1, classement.get(0)); // equipe1 doit être classée première
        assertEquals(equipe2, classement.get(1)); // equipe2 doit être classée deuxième
      }
    }
    
