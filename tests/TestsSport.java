import jo.sport.*;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TestsSport {
    // Test pour la classe Athletisme
    @Test 
    public void testAthletisme() {
        Athletisme a = new Athletisme("Athletisme");
        assertEquals(a.getCategorie(), "Athletisme");
        assertEquals(a.getCoeffForce(), 4);
        assertEquals(a.getCoeffAgilite(), 3);
        assertEquals(a.getCoeffEndurance(), 3);
    }

    // Test pour la classe Escrime
    @Test 
    public void testEscrime() {
        Escrime e = new Escrime("Escrime");
        assertEquals(e.getCategorie(), "Escrime");
        assertEquals(e.getCoeffForce(), 2);
        assertEquals(e.getCoeffAgilite(), 5);
        assertEquals(e.getCoeffEndurance(), 3);
    }

    // Test pour la classe Handball
    @Test 
    public void testHandball() {
        Handball h = new Handball("Handball");
        assertEquals(h.getCategorie(), "Handball");
        assertEquals(h.getCoeffForce(), 4);
        assertEquals(h.getCoeffAgilite(), 4);
        assertEquals(h.getCoeffEndurance(), 3);
    }

    // Test pour la classe Natation
    @Test 
    public void testNatation() {
        Natation n = new Natation("Natation");
        assertEquals(n.getCategorie(), "Natation");
        assertEquals(n.getCoeffForce(), 3);
        assertEquals(n.getCoeffAgilite(), 2);
        assertEquals(n.getCoeffEndurance(), 5);
    }

    // Test pour la classe VolleyBall
    @Test 
    public void testVolleyBall() {
        VolleyBall v = new VolleyBall("VolleyBall");
        assertEquals(v.getCategorie(), "VolleyBall");
        assertEquals(v.getCoeffForce(), 3);
        assertEquals(v.getCoeffAgilite(), 5);
        assertEquals(v.getCoeffEndurance(), 2);
    }
}
