
package helpotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
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
