package helpotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuokailuTest {

    Ruokailu ruoka;
//    public RuokailuTest() {
//    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    @Before
    public void setUp() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
    }

    @Test
    public void dateCorrect() {
        assertEquals("20-02-2002", ruoka.getDate());
    }

    @Test
    public void foodCorrect() {
        assertEquals("banaani", ruoka.getFood());
    }

    @Test
    public void quantityCorrect() {
        assertEquals(1, ruoka.getQuantity());
    }

    @Test
    public void quantityGrowsCorrect() {
        ruoka.addQuantity();
        assertEquals(2, ruoka.getQuantity());
    }

    @Test
    public void quantityGrowsMultipleCorrect() {
        ruoka.addQuantity(4);
        assertEquals(5, ruoka.getQuantity());
    }

    @Test
    public void SetUpCorrect() {
        assertEquals("Pvm:20-02-2002, ruoka-aine:banaani", ruoka.toString());
    }
//    @After
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
