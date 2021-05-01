package helpotus.domain;


import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoodListingsEatingsTest {

    FakeUserDao userDao;
    FakeEatingDao eatingDao;
    FoodListings listings;

    @Before
    public void setUp() {
        userDao = new FakeUserDao();
        eatingDao = new FakeEatingDao();
        listings = new FoodListings(eatingDao, userDao);
        User first = new User("firstTest");
        User second = new User("secondTest");
        userDao.create(first);
        userDao.create(second);
        eatingDao.create(new Eating("01-01-2100", "apple", first));
        listings.login(first.getUsername());
    }
    
    @Test
    public void listIsEmptyWhenFirstLoggedIn() {
        List <Eating> eatings = listings.getDated("01-01-2100");
        assertEquals(1, eatings.size());
        listings.logout();
        listings.createUser("thirdTest");
        listings.login("thirdTest");
        eatings = listings.getDated("01-01-2100");
        assertEquals(0, eatings.size());    
    }
    
    @Test
    public void listIsEmptyIfNotLoggedIn() {
        listings.logout();
        List <Eating> eatings = listings.getDated("01-01-2100");
        assertEquals(0, eatings.size());
    }
    
    @Test
    public void listContainsRightEatingsAtFirst() {
        List <Eating> eatings = listings.getDated("01-01-2100");
        Eating eating = eatings.get(0);
        assertEquals("01-01-2100", eating.getDate());
        assertEquals("apple", eating.getFood());
        assertEquals("firstTest", eating.getUser().getUsername());
    }
    
    @Test
    public void datedGetsRightEatings() {
        listings.createEating("02-01-2100", "banana");
        listings.createEating("01-01-2100", "pineapple");
        List <Eating> eatings = listings.getDated("01-01-2100");
        assertEquals(2, eatings.size());
        Eating eating = eatings.get(1);
        assertEquals("01-01-2100", eating.getDate());
        assertEquals("pineapple", eating.getFood());
        assertEquals("firstTest", eating.getUser().getUsername());
    }
        
//    @Test
//    public void datedDoesNotGetWrongEatigs() {
//        Eating eating1 = new Eating("02-01-2100", "banana", listings.getLoggedUser());
//        Eating eating2 = new Eating("01-01-2100", "pineapple", listings.getLoggedUser());
//        Eating eating0 = new Eating("01-01-2100", "apple", listings.getLoggedUser());
//        listings.createEating(eating1.getDate(), eating1.getFood());
//        listings.createEating("01-01-2100", "pineapple");
//        List <Eating> eatings = new ArrayList<>();
//        eatings.add(eating0);
//        eatings.add(eating2);
////        assertEquals(2, eatings.size());
////        Eating eating0 = eatings.get(0);
//        assertEquals(eatings, listings.getDated("01-01-2100"));
////        assertEquals("pineapple", eating.getFood());
////        assertEquals("firstTest", eating.getUser().getUsername());
//    }
    
    @Test
    public void loggedUserListDoesNotHaveOtherEatings() {
        addEating("02-02-2100", "cake");
        listings.logout();
        listings.login("secondTest");
        List<Eating> eatings = listings.getDated("02-02-2100");
        assertEquals(0, eatings.size());
    }
    
    private void addEating(String date, String food) {
        listings.createEating(date, food);
    } 
}
