import jo.JeuxOlympiques;
import org.junit.*;

public class TestLoadSave{
    private JeuxOlympiques jo;
    
    @Before
    public void setUp(){
        this.jo = new JeuxOlympiques(2021);
    }

    @Test
    public void testLoadCSV(){
        this.jo.load_csv("../donnees.csv");
    }
}