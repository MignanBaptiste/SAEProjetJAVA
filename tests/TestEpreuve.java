import jo.epreuve.*;
import jo.sport.*;
import jo.Sexe;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestEpreuve {
    @Test
    public void test(){
        VolleyBall volleyBall = new VolleyBall("Volley", 14);
        Individuelle individuelle = new Individuelle(Sexe.HOMME, volleyBall);
        Collective collective = new Collective(Sexe.FEMME, volleyBall);
        assertEquals(individuelle.getSexe(), Sexe.HOMME);
        assertEquals(collective.getSexe(), Sexe.FEMME);
        assertEquals(volleyBall, individuelle.getSport());
        assertEquals(volleyBall, collective.getSport());
        assertEquals(null, individuelle.getParticipants());
        assertEquals(null, collective.getParticipants());
        assertEquals(null, individuelle.gagnant());
        assertEquals(null, collective.gagnant());
        assertEquals(null, individuelle.classement());
        assertEquals(null, collective.classement());
    }
}
