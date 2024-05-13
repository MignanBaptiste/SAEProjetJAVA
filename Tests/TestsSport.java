import jo.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestsSport {
    @Test 

    public void testAthletisme() {
        Athletisme a = new Athletisme("Athlelisme", 24);
        assert a.getCategorie() = "Athletisme";
        assert a.getNbjoueurs() = 22;
    }

    @Test 

    public void testEscrime() {
        Escrime e = new Escrime("Escrime", 4);
        assert e.getCategorie() = "Escrime";
        assert e.getNbjoueurs() = 4;

    }

    @Test 

    public void testHandball() {
        Handball h = new Handball("Handball", 14);
        assert h.getCategorie() = "Handball";
        assert h.getNbjoueurs() = 14;

    }

    @Test 

    public void testNatation() {
        Natation n = new Natation("Natation", 5);
        assert n.getCategorie() = "Natation";
        assert n.getNbjoueurs() = 5;

    }

    @Test 

    public void testVolleyBall() {
        Athletisme v = new VolleyBall("VolleyBall", 12);
        assert v.getCategorie() = "VolleyBall";
        assert v.getNbjoueurs() = 12;

    }
}

