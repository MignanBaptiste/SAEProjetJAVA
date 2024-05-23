import jo.*;
import jo.sport.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

public class TestsJeuxOlympiques {
    private JeuxOlympiques jo;
    private Pays france;
    private Pays usa;
    private Athlete ath1;
    private Athlete ath2;
    private Equipe equipe1;
    private Equipe equipe2;
    private Epreuve<Athlete> epreuveIndiv;
    private Epreuve<Equipe> epreuveEquipe;
    private Sport natation;
    
    @Before
    public void setUp() {
        // Initialisation des Jeux Olympiques de 2024
        jo = new JeuxOlympiques(2024);
        
        // Création des pays participants
        france = new Pays("France");
        usa = new Pays("USA");
        
        // Création des athlètes
        ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, france);
        ath2 = new Athlete("Phelps", "Michael", Sexe.HOMME, 65, 92, 85, usa);
        
        // Création des équipes
        equipe1 = new Equipe("Equipe de France", france);
        equipe2 = new Equipe("Equipe des USA", usa);

        // Ajout des équipes aux pays respectifs
        france.ajouteEquipe(equipe1);
        usa.ajouteEquipe(equipe2);
        
        // Création de la discipline Natation
        natation = new Natation("Natation");
        
        // Création des épreuves pour athlètes individuels et équipes
        epreuveIndiv = new Epreuve<>(Sexe.HOMME, natation);
        epreuveEquipe = new Epreuve<>(Sexe.HOMME, natation);
        
        // Ajout des pays aux Jeux Olympiques
        jo.ajoutPays(france);
        jo.ajoutPays(usa);
        
        // Ajout des athlètes aux Jeux Olympiques
        jo.addAthlete(ath1);
        jo.addAthlete(ath2);
        
        // Ajout des équipes aux Jeux Olympiques
        jo.addEquipe(equipe1);
        jo.addEquipe(equipe2);
        
        // Ajout des épreuves aux Jeux Olympiques
        jo.addEpreuve(epreuveIndiv);
        jo.addEpreuve(epreuveEquipe);
    }

    @Test
    public void testAjoutPays() {
        // Test de l'ajout d'un pays aux Jeux Olympiques
        Pays japan = new Pays("Japan");
        jo.ajoutPays(japan);
        List<Pays> paysList = jo.getPays();
        assertTrue(paysList.contains(japan));
    }
    
    @Test
    public void testAjoutAthlete() {
        // Test de l'ajout d'un athlète aux Jeux Olympiques
        Athlete ath3 = new Athlete("Bolt", "Usain", Sexe.HOMME, 60, 80, 90, usa);
        jo.addAthlete(ath3);
        List<Athlete> athletesList = jo.getAthletes();
        assertTrue(athletesList.contains(ath3));
    }
    
    @Test
    public void testAjoutEquipe() {
        // Test de l'ajout d'une équipe aux Jeux Olympiques
        Equipe equipe3 = new Equipe("Equipe du Japan", france);
        jo.addEquipe(equipe3);
        List<Equipe> equipeList = jo.getEquipes();
        assertTrue(equipeList.contains(equipe3));
    }

    @Test
    public void testParticipationAthlete() {
        // Test de la participation d'un athlète à une épreuve individuelle
        jo.participerAthlete(ath1, epreuveIndiv);
        assertTrue(epreuveIndiv.getParticipants().contains(ath1));
    }

    @Test
    public void testParticipationEquipe() {
        // Test de la participation d'une équipe à une épreuve
        jo.participerEquipe(equipe1, epreuveEquipe);
        assertTrue(epreuveEquipe.getParticipants().contains(equipe1));
    }

    @Test
    public void testMedaillesParPays() {
        // Test du calcul des médailles par pays
        equipe1.getClassement().addOr(3);
        equipe1.getClassement().addArgent(2);
        equipe1.getClassement().addBronze(1);

        equipe2.getClassement().addOr(2);
        equipe2.getClassement().addArgent(3);
        equipe2.getClassement().addBronze(4);
        
        HashMap<Pays, HashMap<String, Integer>> medailles = jo.medaillesParPays();
        
        // Vérification des médailles pour la France
        assertEquals(3, (int) medailles.get(france).get("Medailles d'or"));
        assertEquals(2, (int) medailles.get(france).get("Medailles d'argent"));
        assertEquals(1, (int) medailles.get(france).get("Medailles de bronze"));
        
        // Vérification des médailles pour les USA
        assertEquals(2, (int) medailles.get(usa).get("Medailles d'or"));
        assertEquals(3, (int) medailles.get(usa).get("Medailles d'argent"));
        assertEquals(4, (int) medailles.get(usa).get("Medailles de bronze"));
    }

    @Test
    public void testMedaillesOr() {
        // Test du classement des pays par médailles d'or
        equipe1.getClassement().addOr(1);
        equipe2.getClassement().addArgent(1);
        equipe2.getClassement().addBronze(1);
        
        List<Pays> paysOr = jo.medaillesOr();
        assertEquals(france, paysOr.get(0));
        assertEquals(usa, paysOr.get(1));
    }

    @Test
    public void testMedaillesTotales() {
        // Test du classement des pays par nombre total de médailles
        equipe1.getClassement().addOr(1);
        equipe1.getClassement().addArgent(5);
        equipe2.getClassement().addBronze(3);
        equipe2.getClassement().addArgent(2);
        
        List<Pays> paysTotales = jo.medaillesTotales();
        assertEquals(france, paysTotales.get(0));
        assertEquals(usa, paysTotales.get(1));
    }
}
