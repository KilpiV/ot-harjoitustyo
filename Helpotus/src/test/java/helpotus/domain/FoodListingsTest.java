package helpotus.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoodListingsTest {

    FakeUserDao userDao;
    FakeEatingDao eatingDao;
    FoodListings listings;

    @Before
    public void setUp() {
        userDao = new FakeUserDao();
        eatingDao = new FakeEatingDao();
        listings = new FoodListings(eatingDao, userDao);
    }

    @Test
    public void existingUserCanLogin() {
        assertTrue(listings.login("tester"));
        assertEquals("tester", listings.getLoggedUser().getUsername());
    }

    @Test
    public void nonExistingUserCantLogin() {
        assertFalse(listings.login("missing"));
        assertEquals(null, listings.getLoggedUser());
    }

    @Test
    public void loggedUserCanLogOut() {
        listings.login("tester");
        listings.logout();
        assertEquals(null, listings.getLoggedUser());
    }

    @Test
    public void cantMakeUserIfNameNotUnique() {
        assertFalse(listings.createUser("tester"));
    }

    @Test
    public void newUserCanLogin() {
        assertTrue(listings.createUser("Testing"));
        assertTrue(listings.login("Testing"));
        assertEquals("Testing", listings.getLoggedUser().getUsername());
    }

}
