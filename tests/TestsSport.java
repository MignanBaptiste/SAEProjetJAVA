import jo.sport.*;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestsSport {
    @Test 

    public void testAthletisme() {
        Athletisme a = new Athletisme("Athletisme", 24);
        assertEquals(a.getCategorie(), "Athletisme");
        assertEquals(a.getNbjoueurs(), 24);
    }

    @Test 

    public void testEscrime() {
        Escrime e = new Escrime("Escrime", 4);
        assertEquals(e.getCategorie(), "Escrime");
        assertEquals(e.getNbjoueurs(), 4);

    }

    @Test 

    public void testHandball() {
        Handball h = new Handball("Handball", 14);
        assertEquals(h.getCategorie(), "Handball");
        assertEquals(h.getNbjoueurs(), 14);

    }

    @Test 

    public void testNatation() {
        Natation n = new Natation("Natation", 5);
        assertEquals(n.getCategorie(), "Natation");
        assertEquals(n.getNbjoueurs(), 5);

    }

    @Test 

    public void testVolleyBall() {
        VolleyBall v = new VolleyBall("VolleyBall", 12);
        assertEquals(v.getCategorie(), "VolleyBall");
        assertEquals(v.getNbjoueurs(), 12);

    }
}

