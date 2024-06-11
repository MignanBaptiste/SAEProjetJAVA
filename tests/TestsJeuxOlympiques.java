import jo.*;
import jo.exception.InvalidTypeException;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
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

    @Test
    public void testAddEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        assertEquals(2, jeux2024.getEpreuves().size());
    }

    @Test
    public void testGetEpreuve() {
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        jeux2024.addEpreuve(ep1);
        List<Epreuve> epreuves = jeux2024.getEpreuves();
        assertEquals(ep1, epreuves.get(0));
    }

    @Test
    public void testMedaillesParPays() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException e) {
            e.printStackTrace();
        }
        // Ajout des résultats (pour simuler)
        equipeFrance.getPays().getClassement().addOr(2);
        equipeFrance.getPays().getClassement().addArgent(1);
        equipeUSA.getPays().getClassement().addBronze(1);
        // Vérification du nombre de médailles
        HashMap<Pays, Classement> medailles = jeux2024.medaillesParPays();
        assertEquals(2, medailles.get(france).getOr());
        assertEquals(1, medailles.get(france).getArgent());
        assertEquals(0, medailles.get(france).getBronze());
        assertEquals(0, medailles.get(usa).getOr());
        assertEquals(0, medailles.get(usa).getArgent());
        assertEquals(1, medailles.get(usa).getBronze());
    }

    @Test
    public void testMedaillesOr() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException e) {
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

    @Test
    public void testMedaillesTotales() {
        // Création d'épreuves
        Epreuve ep1 = new Epreuve<>(Sexe.HOMME, athletisme);
        Epreuve ep2 = new Epreuve<>(Sexe.FEMME, athletisme);
        // Ajout des épreuves
        jeux2024.addEpreuve(ep1);
        jeux2024.addEpreuve(ep2);
        // Ajout des équipes aux épreuves
        try {
            ep1.addParticipant(equipeFrance);
            ep1.addParticipant(equipeUSA);
            ep2.addParticipant(equipeFrance);
        } catch (InvalidTypeException e) {
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
}
