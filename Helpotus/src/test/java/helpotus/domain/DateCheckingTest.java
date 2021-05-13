package helpotus.domain;

import org.junit.Before;
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
        String digit = "0123456789";
        String notDigit = "1e34";
        String noDigits = "=:? +";
        assertTrue(dates.onlyDigits(digit, digit.length()));
        assertFalse(dates.onlyDigits(notDigit, notDigit.length()));
        assertFalse(dates.onlyDigits(noDigits, noDigits.length()));
    }

    @Test
    public void checkYearCorrect() {
        String year = "2000";
        String notYear = "20";
        String tooFuture = "2101";
        String notNumber = "year";
        assertEquals("2000", dates.yearRight(year));
        assertEquals("Kaikki merkit eivät olleet numeroita", dates.yearRight(notNumber));
        assertEquals("Vuosiluku ei ole kelvollinen, valitse vuosi väliltä 1990-2100", dates.yearRight(notYear));
        assertEquals("Vuosiluku ei ole kelvollinen, valitse vuosi väliltä 1990-2100", dates.yearRight(tooFuture));
    }

    @Test
    public void checkMonthCorrect() {
        String month = "02";
        String monthTwo = "2";
        String notMonth = "13";
        String notMonthTwo = "0";
        String notNumber = "March";
        assertEquals("02", dates.monthRight(month));
        assertEquals("02", dates.monthRight(monthTwo));
        assertEquals("Kuukausi ei ole kelvollinen", dates.monthRight(notMonth));
        assertEquals("Kuukausi ei ole kelvollinen", dates.monthRight(notMonthTwo));
        assertEquals("Kaikki merkit eivät olleet numeroita", dates.monthRight(notNumber));

    }

    @Test
    public void checkDayCorrect() {
        String day = "02";
        String dayTwo = "2";
        String notDay = "32";
        String notNumber = "date";
        assertEquals("02", dates.dayRight(day, 2000, 12));
        assertEquals("02", dates.dayRight(dayTwo, 2000, 12));
        assertEquals("Päivämäärä ei ole kelvollinen", dates.dayRight(notDay, 2000, 12));
        assertEquals("Kaikki merkit eivät olleet numeroita", dates.dayRight(notNumber, 2000, 12));

    }

    @Test
    public void checkLeapDayCorrect() {
        int leapYear = 2020;
        int notLYear = 2000;
        int notLeapYear = 2001;
        int month = 02;
        String day = "29";
        assertEquals("29", dates.dayRight(day, leapYear, month));
        assertEquals("Ei karkausvuosi", dates.dayRight(day, notLYear, month));
        assertEquals("Ei karkausvuosi", dates.dayRight(day, notLeapYear, month));

    }

    @Test
    public void checkDayByMonthsCorrect() {
        int year = 2000;
        int dec = 12;
        int nov = 11;
        int feb = 02;
        String day = "31";
        String secondDay = "30";
        assertEquals("31", dates.dayRight(day, year, dec));
        assertEquals("30", dates.dayRight(secondDay, year, nov));
        assertEquals("Päivämäärä ei ole kelvollinen", dates.dayRight(day, year, nov));
        assertEquals("Päivämäärä ei ole kelvollinen", dates.dayRight(day, year, feb));

    }
}
