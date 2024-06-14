import jo.*;
import jo.exception.AlreadyInException;
import jo.exception.InvalidSexeException;
import jo.exception.InvalidTypeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

//import java.util.HashMap;

import java.util.List;

public class TestsJeuxOlympiques {

    private JeuxOlympiques jeux2024;
    private Pays france;
    private Pays usa;
    private Equipe equipeFrance;
    private Equipe equipeUSA;
    private Athletisme athletisme;

    @Before
    public void setUp() {
        jeux2024 = new JeuxOlympiques(2024);
        france = new Pays("France");
        usa = new Pays("USA");
        equipeFrance = new Equipe(new VolleyBall(null), france);
        equipeUSA = new Equipe(new VolleyBall(null), usa);
        athletisme = new Athletisme("Athlétisme");
    }

    @Test
    public void testJeuxOlympiques() {
        assertNotNull(jeux2024);
    }

    @Test
    public void testGetAnnee() {
        assertEquals(2024, jeux2024.getAnnee());
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testAddEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        assertEquals(2, jeux2024.getEpreuves().size());
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testGetEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        jeux2024.addEpreuve(ep1);
        List<Epreuve> epreuves = jeux2024.getEpreuves();
        assertEquals(ep1, epreuves.get(0));
    }

    // @SuppressWarnings("unchecked")
    // @Test
    // public void testMedaillesParPays() {
    //     // Création d'épreuves
    //     @SuppressWarnings("rawtypes")
    //     Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
    //     @SuppressWarnings("rawtypes")
    //     Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
    //     // Ajout des épreuves
    //     jeux2024.addEpreuve(ep1);
    //     jeux2024.addEpreuve(ep2);
    //     // Ajout des équipes aux épreuves
    //     try {
    //         ep1.addParticipant(equipeFrance);
    //         ep1.addParticipant(equipeUSA);
    //         ep2.addParticipant(equipeFrance);
    //     } catch (InvalidTypeException e) {
    //         e.printStackTrace();
    //     }
    //     // Ajout des résultats (pour simuler)
    //     equipeFrance.getPays().getClassement().addOr(2);
    //     equipeFrance.getPays().getClassement().addArgent(1);
    //     equipeUSA.getPays().getClassement().addBronze(1);
    //     // Vérification du nombre de médailles
    //     HashMap<Pays, Classement> medailles = jeux2024.medaillesParPays();
    //     assertEquals(2, medailles.get(france).getOr());
    //     assertEquals(1, medailles.get(france).getArgent());
    //     assertEquals(0, medailles.get(france).getBronze());
    //     assertEquals(0, medailles.get(usa).getOr());
    //     assertEquals(0, medailles.get(usa).getArgent());
    //     assertEquals(1, medailles.get(usa).getBronze());
    // }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testMedaillesOr() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        try {
            equipeFrance.addAthlete(ath1);
            equipeUSA.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion des erreurs
        }
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            e.printStackTrace();
        }
        // Ajout des résultats (pour simuler)
        equipeFrance.getPays().getClassement().addOr(2);
        equipeUSA.getPays().getClassement().addBronze(1);
        // Vérification du classement par médailles d'or
        List<Pays> medaillesOr = jeux2024.medaillesOr();
        assertEquals(france, medaillesOr.get(0));
        assertEquals(usa, medaillesOr.get(1));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testMedaillesTotales() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, france);
        try {
            equipeFrance.addAthlete(ath1);
            equipeUSA.addAthlete(ath2);
        } catch (InvalidSexeException | AlreadyInException e) {
            // gestion des erreurs
        }
        
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException | InvalidSexeException | AlreadyInException e) {
            e.printStackTrace();
        }
        // Ajout des résultats (pour simuler)
        equipeFrance.getPays().getClassement().addOr(2);
        equipeFrance.getPays().getClassement().addArgent(1);
        equipeUSA.getPays().getClassement().addBronze(1);
        // Vérification du classement par médailles totales
        List<Pays> medaillesTotales = jeux2024.medaillesTotales();
        assertEquals(france, medaillesTotales.get(0));
        assertEquals(usa, medaillesTotales.get(1));
    }

    @Test
    public void testResetClassement() {
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        jeux2024.addAthlete(ath1);
        france.getClassement().addBronze(23);
        assertEquals(france.getClassement().getBronze(), 23);
        jeux2024.resetClassement();
        assertEquals(france.getClassement().getBronze(), 0);
    }

    // Test pour la méthode equals
    @Test
    public void testEquals() {
        JeuxOlympiques jeux2023 = new JeuxOlympiques(2023);
        JeuxOlympiques jeux2024Num2 = new JeuxOlympiques(2024);
        assertNotEquals(jeux2024, jeux2023);
        assertEquals(jeux2024, jeux2024Num2);
    }

    // Test pour la méthode hashCode
    @Test
    public void testHashCode() {
        assertEquals(jeux2024.hashCode(), (31*2024)/17);
        assertNotEquals(jeux2024.hashCode(), 58);
    }

    // Test pour la méthode toString
    @Test
    public void testToString() {
        assertEquals(jeux2024.toString(), "Jeux Olympique de 2024");
        assertNotEquals(jeux2024.toString(), "Vive les Jeux Olympiques !");
    }

    public void testLoad_csv(){
        JeuxOlympiques jo = new JeuxOlympiques(0);
        try{
            jo.load_csv("tests/donnees.csv");
        }
        catch(InvalidTypeException e){
            System.out.println("Problème de chargement des données");
        }
        assertEquals(jo.getNbAthletes(), 400);
        assertEquals(jo.getNbEquipes(), 40);
        assertEquals(jo.getNbPays(), 10);
        assertEquals(jo.getNbEpreuves(), 16);
    }

    @Test
    public void testSimulation(){
    }
}

