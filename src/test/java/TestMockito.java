import domaine.Sport;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestMockito {

    public Sport s1,s2;
    public String[] lst;

    @BeforeClass
    public void setup(){
        s1 = new Sport(1, "Ski");
        s2 = new Sport(3, "Ski");
        lst = new String[]{s1.getNom(),s2.getNom()};
    }
    @Test
    public void testConcatenation() {
        Assert.assertEquals("SkiSki",s1.concatenerString(lst));
    }
    public void testDao(){

    }
}
