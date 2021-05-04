package helpotus.domain;

public class DateChecking {

    public boolean onlyDigits(String str, int n) {
        boolean allDigits = true;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= '0'
                    && str.charAt(i) <= '9') {
            } else {
                allDigits = false;
            }
        }
        return allDigits;
    }

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
        if (month == 2) {
            if (day == 29) {
                if (year == 2000 || year % 4 != 0) {
                    return "Ei karkausvuosi";
                }
                if (string.length() == 1) {
                    return "0" + string;
                }
                return string;
            }
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day >= 29 && day <= 31) {
                return string;
            }
        } else {
            if (day == 29 || day == 30) {
                return string;
            }
        }
        return "Päivämäärä ei ole kelvollinen";
    }

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
