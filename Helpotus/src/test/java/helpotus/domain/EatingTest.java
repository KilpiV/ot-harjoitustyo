package helpotus.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class EatingTest {

    Eating ruoka;

    @Test
    public void dateCorrect() {
        ruoka = new Eating("20-02-2002", "banaani", new User("testaaja"));
        assertEquals("20-02-2002", ruoka.getDate());
    }

    @Test
    public void UserCorrect() {
        User user = new User("testaaja");
        ruoka = new Eating("20-02-2002", "banaani", user);
        assertEquals(user, ruoka.getUser());
    }

    @Test
    public void UsernameCorrect() {
        User user = new User("testaaja");
        ruoka = new Eating("20-02-2002", "banaani", user);
        assertEquals("testaaja", ruoka.getUser().getUsername());
    }

    @Test
    public void foodCorrect() {
        ruoka = new Eating("20-02-2002", "banaani", new User("testaaja"));
        assertEquals("banaani", ruoka.getFood());
    }

    @Test
    public void SetUpCorrect() {
        ruoka = new Eating("20-02-2002", "banaani", new User("testaaja"));
        assertEquals("Pvm:20-02-2002, ruoka-aine:banaani", ruoka.toString());
    }
}
