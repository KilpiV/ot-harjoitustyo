package helpotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuokailuTest {

    Ruokailu ruoka;

    @Test
    public void dateCorrect() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
        assertEquals("20-02-2002", ruoka.getDate());
    }
    
    @Test
    public void UserCorrect() {
        User user = new User("testaaja");
        ruoka = new Ruokailu("20-02-2002", "banaani", user);
        assertEquals(user, ruoka.getUser());
    }
    
    @Test
    public void UsernameCorrect() {
        User user = new User("testaaja");
        ruoka = new Ruokailu("20-02-2002", "banaani", user);
        assertEquals("testaaja", ruoka.getUser().getUsername());
    }

    @Test
    public void foodCorrect() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
        assertEquals("banaani", ruoka.getFood());
    }

    @Test
    public void quantityCorrect() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
        assertEquals(1, ruoka.getQuantity());
    }

    @Test
    public void quantityGrowsCorrect() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
        ruoka.addQuantity();
        assertEquals(2, ruoka.getQuantity());
    }

    @Test
    public void quantityGrowsMultipleCorrect() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
        ruoka.addQuantity(4);
        assertEquals(5, ruoka.getQuantity());
    }

    @Test
    public void SetUpCorrect() {
        ruoka = new Ruokailu("20-02-2002", "banaani", new User("testaaja"));
        assertEquals("Pvm:20-02-2002, ruoka-aine:banaani", ruoka.toString());
    }
    
        @Test
    public void SetUpCorrectWithQuatity() {
        ruoka = new Ruokailu("20-02-2002", "banaani", 2, new User("testaaja"));
        assertEquals(2, ruoka.getQuantity());
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
