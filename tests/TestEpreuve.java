import jo.*;
import jo.epreuve.Individuelle;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestEpreuve {
    @Test
    public void test(){
        VolleyBall volleyBall = new VolleyBall();
        Individuelle individuelle = new Individuelle("M", volleyBall);
        Collective collective = new Collective("F", volleyBall);
        assertEquals(individuelle.getSexe(), "M");
        assertEquals(collective.getSexe(), "F");
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
