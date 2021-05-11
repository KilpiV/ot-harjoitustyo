package helpotus.domain;

/**
 * Luokka joka huolehtii päivämäärien oikeellisuuden tarkistuksesta.
 */
public class DateChecking {

    /**
     * Metodi tarkistaa onko kaikki siinä olevat merkit numeroita.
     *
     * @param str annettu merkkijono (vuosi, kuukausi tai päivämäärä)
     * @param n merkkijonon pituus
     * @return true jos kaikki numeroita muuten false
     */
    public boolean onlyDigits(String str, int n) {
        boolean allDigits = true;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                allDigits = false;
            }
        }
        return allDigits;
    }

    /**
     * Metodi joka tarkistaa onko päivämäärä oikea kuukauteen nähden. dayRight
     * käyttää tätä metodia tarkistamaan karkauspäivän ja muuten kuukausien
     * viimeiset päivät
     *
     * @param day päivämäärä
     * @param month kuukausi
     * @param year vuosi
     * @return päivämäärän jos se on kelvollinen muuten virheviestin
     */
    public String dayByMonthRight(int day, int month, int year) {
        if (month == 2) {
            if (day == 29) {
                if (year == 2000 || year % 4 != 0) {
                    return "Ei karkausvuosi";
                }
                return String.valueOf(day);
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day == 29 || day == 30) {
                return String.valueOf(day);
            }
        } else {
            if (day >= 29 && day <= 31) {
                return String.valueOf(day);
            }
        }
        return "Päivämäärä ei ole kelvollinen";
    }

    /**
     * Metodi, joka tarkistaa onko päivämäärä oikeanlainen. Onko se välillä 1-31
     * ja onko se kuukauteen nähden oikean suuruinen, karkauspäivä
     *
     * @param string päivämäärä
     * @param year vuosiluku
     * @param month kuukausi
     * @return päivämäärä dd-muodossa jos annettu päivämäärä on sallittu, muuten
     * virheviestin
     */
    public String dayRight(String string, int year, int month) {
        int day;
        if (onlyDigits(string, string.length())) {
            day = Integer.parseInt(string);
        } else {
            return "Kaikki merkit eivät olleet numeroita";
        }
        if (day >= 1 && day <= 28) {
            if (string.length() == 1) {
                return "0" + string;
            }
            return string;
        }
        return dayByMonthRight(day, month, year);
    }

    /**
     * Metodi, joka tarkistaa onko annettu kuukausi kelvollinen. tarkistaa onko
     * luku ja onko välillä 1-12
     *
     * @param string kuukausi
     * @return kuukauden jos se on kelvollinen, muuten virheviestin
     */
    public String monthRight(String string) {
        int month;
        if (onlyDigits(string, string.length())) {
            month = Integer.parseInt(string);
        } else {
            return "Kaikki merkit eivät olleet numeroita";
        }
        if (month >= 1 && month <= 12) {
            if (string.length() == 1) {
                return "0" + string;
            }
            return string;
        } else {
            return "Kuukausi ei ole kelvollinen";
        }
    }

    /**
     * Metodi, joka tarkistaa onko annettu vuosi oikeanlainen. vuoden tulee olla
     * välillä 1900-2100 esitettynä yyyy-muodossa
     *
     * @param string vuosiluku
     * @return vuosiluvun jos se on kelvollinen muuten virheviestin
     */
    public String yearRight(String string) {
        int year;
        if (onlyDigits(string, string.length())) {
            year = Integer.parseInt(string);
        } else {
            return "Kaikki merkit eivät olleet numeroita";
        }
        if (year >= 1990 && year <= 2100) {
            return string;
        } else {
            return "Vuosiluku ei ole kelvollinen, valitse vuosi väliltä 1990-2100";
        }
    }
}
