package helpotus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateCheckingTest {

    DateChecking dates;

    @Before
    public void setUp() {
        this.dates = new DateChecking();
    }

    @Test
    public void noticeNoDigits() {
        String digit = "1234";
        String notDigit = "1e34";
        assertTrue(dates.onlyDigits(digit, digit.length()));
        assertFalse(dates.onlyDigits(notDigit, notDigit.length()));
    }
    
    @Test
    public void checkYearCorrect() {
        String year = "2000";
        String notYear = "20";
        String notNumber = "year";
        assertEquals("2000", dates.yearRight(year));
        assertEquals("Kaikki merkit eivät olleet numeroita", dates.yearRight(notNumber));
        assertEquals("Vuosiluku ei ole kelvollinen, valitse vuosi väliltä 1990-2100", dates.yearRight(notYear));
    }
//    public DateCheckingTest() {
//    }
//    

//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
