import jo.*;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestsAthlete {
    private Athlete ath1;
    private Athlete ath2;
    private Athlete ath3;
    private Pays france;

    @Before
    public void setUp() {
        france = new Pays("France");
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        ath3 = new Athlete("Dumerc", "Céline", Sexe.FEMME, 45, 78, 65, france);
    }

    /** On veut pouvoir créer un nouvel athlète */
    @Test
    public void testAthlete() {
        // Test de création d'athlètes
        assertEquals("Manaudou", ath1.getNomAthlete());
        assertEquals("Riner", ath2.getNomAthlete());
        assertEquals("Dumerc", ath3.getNomAthlete());
    }

    /** On veut obtenir le nom de l'athlète */
    @Test
    public void testGetNomAthlete() {
        // Test de récupération du nom de l'athlète
        assertEquals("Manaudou", ath1.getNomAthlete());
        assertEquals("Riner", ath2.getNomAthlete());
        assertEquals("Dumerc", ath3.getNomAthlete());
    }

    /** On veut obtenir le prénom de l'athlète */
    @Test
    public void testGetPrenomAthlete() {
        // Test de récupération du prénom de l'athlète
        assertEquals("Florent", ath1.getPrenomAthlete());
        assertEquals("Teddy", ath2.getPrenomAthlete());
        assertEquals("Céline", ath3.getPrenomAthlete());
    }

    /** On veut obtenir le nom complet d'un athlète */
    @Test
    public void testGetNom() {
        // Test de récupération du nom complet de l'athlète
        assertEquals("Manaudou Florent", ath1.getNom());
        assertEquals("Riner Teddy", ath2.getNom());
        assertEquals("Dumerc Céline", ath3.getNom());
    }

    /** On veut obtenir sex de l'athlète */
    @Test
    public void testGetSexe() {
        // Test de récupération du sexe de l'athlète
        assertEquals(Sexe.HOMME, ath1.getSexe());
        assertEquals(Sexe.HOMME, ath2.getSexe());
        assertEquals(Sexe.FEMME, ath3.getSexe());
    }

    /** On veut obtenir la force de l'athlète */
    @Test
    public void testGetForce() {
        // Test de récupération de la force de l'athlète
        assertEquals(56, ath1.getForce());
        assertEquals(89, ath2.getForce());
        assertEquals(45, ath3.getForce());
    }

    /** On veut obtenir l'agilité de l'athlète */
    @Test
    public void testGetAgilite() {
        // Test de récupération de l'agilité de l'athlète
        assertEquals(87, ath1.getAgilite());
        assertEquals(67, ath2.getAgilite());
        assertEquals(78, ath3.getAgilite());
    }

    /** On veut obtenir l'endurance de l'athlète */
    @Test
    public void testGetEndurance() {
        // Test de récupération de l'endurance de l'athlète
        assertEquals(78, ath1.getEndurance());
        assertEquals(53, ath2.getEndurance());
        assertEquals(65, ath3.getEndurance());
    }

    /** On veut obtenir le pays de l'athlète */
    @Test
    public void testGetPays() {
        // Test de récupération du pays de l'athlète
        assertEquals(france, ath1.getPays());
        assertEquals(france, ath2.getPays());
        assertEquals(france, ath3.getPays());
    }

    /** 
     * Test de participation de l'athlète à une épreuve
     */
    @Test
    public void testParticiper() {
        // Création d'une épreuve individuelle (pour Athlete)
        Sport athletisme = new Athletisme("100m");
        Epreuve<Athlete> epv1 = new Epreuve(Sexe.HOMME, athletisme);

        // Tentative de participation de l'athlète à une épreuve individuelle 
        ath2.participer(epv1);
        assertNotNull(epv1.getParticipants()); // Vérifie si l'athlète a été ajouté à l'épreuve*
    }
}
   
