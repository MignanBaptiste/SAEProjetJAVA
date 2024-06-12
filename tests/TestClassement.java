import jo.*;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestClassement {
    private Pays france;

    @Before
    public void setUp() {
        france = new Pays("France");
    }

    @Test
    public void testAddOr() {
        france.getClassement().addOr(6);
        assertEquals(6, france.getClassement().getOr());
    }

    @Test
    public void testAddArgent() {
        france.getClassement().addArgent(8);
        assertEquals(8, france.getClassement().getArgent());
    }

    @Test
    public void testAddBronze() {
        france.getClassement().addBronze(10);
        assertEquals(10, france.getClassement().getBronze());
    }

    @Test
    public void testEquals() {
        france.getClassement().addOr(6);
        france.getClassement().addArgent(8);
        france.getClassement().addBronze(10);
        Classement c = new Classement();
        c.addOr(6);
        c.addArgent(8);
        c.addBronze(10);
        assertEquals(france.getClassement(), c);
        c.addBronze(1);
        assertNotEquals(france.getClassement(), c);
    }

    @Test
    public void testHashCode() {
        france.getClassement().addOr(6);
        france.getClassement().addArgent(8);
        france.getClassement().addBronze(10);
        Classement c = new Classement();
        c.addOr(4);
        c.addArgent(2);
        c.addBronze(0);
        assertEquals(france.getClassement().hashCode(), (31*6*8*10+17)/17);
        assertEquals(c.hashCode(), 1);
    }

    @Test
    public void testToString() {
        france.getClassement().addOr(6);
        france.getClassement().addArgent(8);
        france.getClassement().addBronze(10);
        Classement c = new Classement();
        c.addOr(4);
        c.addArgent(2);
        c.addBronze(0);
        assertEquals(france.getClassement().toString(), "Médailles d'or : 6, Médailles d'argent : 8, Médailles de bronze : 10");
        assertEquals(c.toString(), "Médailles d'or : 4, Médailles d'argent : 2, Médailles de bronze : 0");
    }
    
    
}
