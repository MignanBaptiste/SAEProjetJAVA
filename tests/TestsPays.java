import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class TestsPays {
    /** On veut pouvoir créer un nouveau pays */
    @Test
    public void testPays(){
        Pays france = new Pays("France");
        Pays espagne = new Pays("Espagne");
    }

    /** On veut obtenir le nom du pays */
    @Test
    public void testGetNomPays(){
        Pays france = new Pays("France");
        Pays espagne = new Pays("Espagne");
        assertEquals("France", france.getNom());
        assertEquals("Espagne", espagne.getNom());
    }

    /** On veut ajouter une équipe à la liste des équipes du pays */
    @Test
    public void testAjouteEquipe(){
        Pays france = new Pays("France");
        Pays espagne = new Pays("Espagne");
        Equipe equ1 = new Equipe("equ1", france);
        Equipe equ2 = new Equipe("equ2", france);
        Equipe equ3 = new Equipe("equ3", espagne);
        Equipe equ4 = new Equipe("equ4", espagne);
        france.ajouteEquipe(equ1);
        france.ajouteEquipe(equ2);
        espagne.ajouteEquipe(equ3);
        espagne.ajouteEquipe(equ4);
    }

    /** On veut obtenir la liste des équipes du pays */
    @Test
    public void testGetEquipes(){
        Pays france = new Pays("France");
        Pays espagne = new Pays("Espagne");
        Equipe equ1 = new Equipe("equ1", france);
        Equipe equ2 = new Equipe("equ2", france);
        Equipe equ3 = new Equipe("equ3", espagne);
        Equipe equ4 = new Equipe("equ4", espagne);
        france.ajouteEquipe(equ1);
        france.ajouteEquipe(equ2);
        espagne.ajouteEquipe(equ3);
        espagne.ajouteEquipe(equ4);
        assertEquals(Arrays.asList(equ1, equ2), france.getEquipes());
        assertEquals(Arrays.asList(equ3, equ4), espagne.getEquipes());
    }

    /** On veut ajouter un athlète à la liste des athlètes du pays */
    @Test
    public void testAjouteAthlete(){
        Pays france = new Pays("France");
        Pays espagne = new Pays("Espagne");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        Athlete ath3 = new Athlete("García", "Jesús Ángel", Sexe.HOMME, 39, 58, 84, 54, france);
        Athlete ath4 = new Athlete("Canales", "Elia", Sexe.FEMME, 64, 43, 56, 67, france);
        france.ajouteAthlete(ath1);
        france.ajouteAthlete(ath2);
        espagne.ajouteAthlete(ath3);
        espagne.ajouteAthlete(ath4);
    }

    /** On veut obtenir la liste des athlètes du pays */
    @Test
    public void testGetAthlete(){
        Pays france = new Pays("France");
        Pays espagne = new Pays("Espagne");
        Athlete ath1 = new Athlete("Manaudou", "Florent", Sexe.HOMME, 56, 87, 78, 34, france);
        Athlete ath2 = new Athlete("Riner", "Teddy", Sexe.HOMME, 89, 67, 53, 45, france);
        Athlete ath3 = new Athlete("García", "Jesús Ángel", Sexe.HOMME, 39, 58, 84, 54, france);
        Athlete ath4 = new Athlete("Canales", "Elia", Sexe.FEMME, 64, 43, 56, 67, france);
        france.ajouteAthlete(ath1);
        france.ajouteAthlete(ath2);
        espagne.ajouteAthlete(ath3);
        espagne.ajouteAthlete(ath4);
        assertEquals(Arrays.asList(ath1, ath2), france.getAthletes());
        assertEquals(Arrays.asList(ath3, ath4), espagne.getAthletes());
    }
}
