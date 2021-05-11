package helpotus.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void equalWhenSameUsername() {
        User first = new User("testing");
        User second = new User("testing");
        assertTrue(first.equals(second));
    }

    @Test
    public void notEqualWhenSameUsername() {
        User first = new User("testing");
        User second = new User("tester");
        assertFalse(first.equals(second));

    }

    @Test
    public void notEqualWhendifferentObject() {
        User first = new User("testing");
        Object object = new Object();
        assertFalse(first.equals(object));

    }

}
