import jo.*;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestsAthlete {
    private Athlete ath1;
    private Athlete ath2;
    private Athlete ath3;
    private Pays france;

    @Before //Le BeforeEach n'étant pas utilisable lors des version présédentes de junit nous avons décidé d'utiliser Before
    public void setUp() {
        france = new Pays("France");
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        ath3 = new Athlete("Dumerc", "Céline", Sexe.FEMME, 45, 78, 65, 50, france);
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

    /** On veut obtenir le score de l'athlète */
    @Test
    public void testGetScore() {
        // Test de récupération du score de l'athlète
        assertEquals(34, ath1.getScore());
        assertEquals(45, ath2.getScore());
        assertEquals(50, ath3.getScore());
    }

    /** On veut obtenir le pays de l'athlète */
    @Test
    public void testGetPays() {
        // Test de récupération du pays de l'athlète
        assertEquals(france, ath1.getPays());
        assertEquals(france, ath2.getPays());
        assertEquals(france, ath3.getPays());
    }

    /** On veut modifier le score de l'athlète */
    @Test
    public void testSetScore() {
        // Test de modification du score de l'athlète
        ath1.setScore(100);
        ath2.setScore(200);
        ath3.setScore(150);
        assertEquals(134, ath1.getScore());
        assertEquals(245, ath2.getScore());
        assertEquals(200, ath3.getScore());
    }

    /** 
    * Test de participation de l'athlète à une épreuve
    */
    @Test
    public void testParticiper() {
        // Création d'une épreuve individuelle (pour Athlete)
        Sport athletisme = new Athletisme("100m", 1);
        Epreuve epv1 = new Epreuve(Sexe.HOMME, athletisme);

        // Tentative de participation de l'athlète à une épreuve individuelle (qui accepte seulement les athlètes)
        ath2.participer(epv1);
        assertNotNull(epv1.getParticipants()); // Vérifie si l'athlète a été ajouté à l'épreuve
        
        // Création d'une épreuve collective (pour Equipe)
        Sport handball = new Handball("Handball", 7);
        Epreuve epv2 = new Epreuve(Sexe.HOMME, handball);
        Equipe equipe = new Equipe("Equipe de France", france);
        equipe.addAthlete(ath1);
        equipe.addAthlete(ath2);
        // Tentative de participation de l'athlète à une épreuve collective (qui accepte seulement les équipes)
        equipe.participer(epv2);
        ath3.participer(epv2);
        assertEquals(epv2.getParticipants().size(), 1); //On vérifie que l'athlète n'a pas pu être ajouter
    }


    /** On veut trier une liste d'athlètes en fonction de leur score */
    @Test
    public void testCompareTo() {
        // Création d'une liste d'athlètes
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(ath1);
        athletes.add(ath2);
        athletes.add(ath3);

        // Trier la liste d'athlètes
        Collections.sort(athletes);

        // Vérifier si les athlètes sont triés par ordre décroissant de score
        assertEquals(ath3, athletes.get(0)); // ath2 a le score le plus élevé
        assertEquals(ath2, athletes.get(1)); // ath3 a le deuxième score le plus élevé
        assertEquals(ath1, athletes.get(2)); // ath1 a le score le plus bas
    }
}

