package helpotus.ui;

import java.util.*;
import helpotus.domain.Eating;
import helpotus.domain.FoodListings;
import helpotus.domain.User;
import helpotus.domain.DateChecking;

public class TextUI {

    private Scanner userScanner;
    private FoodListings foodListing;
    private DateChecking dates;

    public TextUI(Scanner scanner, FoodListings foodListing) {
        this.userScanner = scanner;
        this.foodListing = foodListing;
        this.dates = new DateChecking();
    }

    public String askDate() {
        String year;
        String month;
        String day;
        while (true) {
            System.out.println("Anna ensin vuosi");
            System.out.print(">> ");
            year = this.userScanner.nextLine();
            String answer =this.dates.yearRight(year);
            if (answer.equals(year)) {
                break;
            } else {
                System.out.println("answer");
            }
//            boolean rightYear = false;
//            if (year.length() == 4) {
//                if ((year.charAt(0) == '1' && year.charAt(1) == '9')
//                        || (year.charAt(0) == '2' && year.charAt(1) == '0')) { // jos alkaa muulla kuin 19--
//                    if (year.charAt(2) == '0' || year.charAt(2) == '1' || year.charAt(2) == '2'
//                            || year.charAt(2) == '3' || year.charAt(2) == '4' || year.charAt(2) == '5'
//                            || year.charAt(2) == '6' || year.charAt(2) == '7'
//                            || year.charAt(2) == '8' || year.charAt(2) == '9') {
//                        if (year.charAt(3) == '0' || year.charAt(3) == '1' || year.charAt(3) == '2'
//                                || year.charAt(3) == '3' || year.charAt(3) == '4' || year.charAt(3) == '5'
//                                || year.charAt(3) == '6' || year.charAt(3) == '7'
//                                || year.charAt(3) == '8' || year.charAt(3) == '9') {
//                            rightYear = true;
//                        }
//                    }
//
//                } else if (year.charAt(0) == '2' && year.charAt(1) == '1' //..2100 korkein
//                        && year.charAt(2) == '0' && year.charAt(3) == '0') {
//                    rightYear = true;
//                }
//            }
//            if (year.length() == 4 && rightYear) {
//                break;
//            }
//            System.out.println("Virheellinen vuosiluku, anna vuosiluku muodossa yyyy!");
        }
        while (true) {
            System.out.println("Anna seuraavaksi kuukausi");
            System.out.print(">> ");
            month = this.userScanner.nextLine();
            String answer = this.dates.monthRight(month);            
            if (answer.equals(month) || answer.equals("0"+month)) {
                month = answer;
                break;
            } else {
                System.out.println(answer);
            }
//            if (month.length() == 2) {
//                if (month.charAt(0) == '1') {
//                    if (month.charAt(1) == '0' || month.charAt(1) == '1' || month.charAt(1) == '2') {
//                        break;
//                    }
//                }
//                if (month.charAt(0) == '0') {
//                    if (month.charAt(1) == '1' || month.charAt(1) == '2' || month.charAt(1) == '3'
//                            || month.charAt(1) == '4' || month.charAt(1) == '5' || month.charAt(1) == '6'
//                            || month.charAt(1) == '7' || month.charAt(1) == '8' || month.charAt(1) == '9') {
//                        break;
//                    }
//                }
//            }
//            if (month.length() == 1) {
//                if (month.charAt(0) == '1' || month.charAt(0) == '2' || month.charAt(0) == '3'
//                        || month.charAt(0) == '4' || month.charAt(0) == '5' || month.charAt(0) == '6'
//                        || month.charAt(0) == '7' || month.charAt(0) == '8' || month.charAt(0) == '9') {
//                    break;
//                }
//            }
//            System.out.println("Virheellinen kuukausi!");
//        }
//        if (month.length() == 1) {
//            month = "0" + month;
        }
        int yearDigit = Integer.parseInt(year);
        int monthDigit = Integer.parseInt(month);
        while (true) {
            System.out.println("Anna vielä päivämäärä");
            System.out.print(">> ");
            day = this.userScanner.nextLine();
            String answer = this.dates.dayRight(day, yearDigit, monthDigit);
            if (answer.equals(day) || answer.equals("0"+day)) {
                day = answer;
                break;
            } else {
                System.out.println(answer);
            }
            
//            // karkausvuosi?
//            if (day.length() == 2) {
//                if (day.charAt(0) == '3') {
//                    if (day.charAt(1) == '0' || day.charAt(1) == '1') {
//                        break;
//                    }
//                }
//                if (day.charAt(0) == '1' || day.charAt(0) == '2') {
//                    if (day.charAt(1) == '1' || day.charAt(1) == '2' || day.charAt(1) == '3'
//                            || day.charAt(1) == '4' || day.charAt(1) == '5' || day.charAt(1) == '6'
//                            || day.charAt(1) == '7' || day.charAt(1) == '8'
//                            || day.charAt(1) == '9' || day.charAt(1) == '0') {
//                        break;
//                    }
//                }
//                if (day.charAt(0) == '0') {
//                    if (day.charAt(1) == '1' || day.charAt(1) == '2' || day.charAt(1) == '3'
//                            || day.charAt(1) == '4' || day.charAt(1) == '5' || day.charAt(1) == '6'
//                            || day.charAt(1) == '7' || day.charAt(1) == '8' || day.charAt(1) == '9') {
//                        break;
//                    }
//                }
//            }
//            if (day.length() == 1) {
//                if (day.charAt(0) == '1' || day.charAt(0) == '2' || day.charAt(0) == '3'
//                        || day.charAt(0) == '4' || day.charAt(0) == '5' || day.charAt(0) == '6'
//                        || day.charAt(0) == '7' || day.charAt(0) == '8' || day.charAt(0) == '9') {
//                    break;
//                }
//            }
//            System.out.println("virheellinen päiväys!");
//        }
//        if (day.length() == 1) {
//            day = "0" + day;
        }
        System.out.println("Annoit päivämäärän " + day + "-" + month + "-" + year);
        String date = day + "-" + month + "-" + year;
        return date;
    }

    public void foodSurvey(User user) throws Exception {
        while (true) {
            System.out.println("");
            System.out.println("---");
            System.out.println("Syötä käsky");
            System.out.println("(1) Lisää ruokia");
            System.out.println("(2) Tarkasta syömisiä");
            System.out.println("(x) Poistu");
            System.out.print(">> ");

            String command = this.userScanner.nextLine();
            if (command.equals("x") || command.equals("X")) {
                this.foodListing.logout();
                user = null;
                break;
            }
            if (command.equals("1")) {
                System.out.println("Anna lisättävän ruokailun päivämäärä");
                String date = askDate();
                System.out.println("Anna lisättävä ruoka");
                System.out.print(">> ");
                String food = userScanner.nextLine();
                this.foodListing.createEating(date, food);

            }
            if (command.equals("2")) {

                System.out.println("Anna haettavan ruokailun päivämäärä");
                String date = askDate();
                System.out.println("");
                System.out.println("Päivän ruokailut:");
                List<Eating> eatings = this.foodListing.getDated(date);
                System.out.println(eatings);

            }
        }
    }

    public void start() throws Exception {
        System.out.println("Tervetuloa Helpotukseen");
        while (true) {
            System.out.println("");
            System.out.println("---");
            System.out.println("Syötä käsky");
            System.out.println("(1) Kirjaudu");
            System.out.println("(2) Luo uusi käyttäjä");
            System.out.println("(x) Poistu");
            System.out.print(">> ");

            String command = this.userScanner.nextLine();
            if (command.equals("x") || command.equals("X")) {
                break;
            }
            if (command.equals("1")) {
                System.out.println("Anna nimimerkkisi");
                System.out.print(">> ");
                String name = userScanner.nextLine();
                // kirjautuminen
                if (this.foodListing.login(name)) {
                    foodSurvey(this.foodListing.getLoggedUser());
                } else {
                    System.out.println("Virheellinen nimimerkki");
                }
            }
            if (command.equals("2")) {

                System.out.println("Anna haluamasi nimimerkki");
                System.out.print(">> ");
                String name = userScanner.nextLine();
                if (this.foodListing.createUser(name)) {
                    System.out.println("Uusi käyttäjä " + name + " on nyt luotu");
                    continue;
                } else {
                    System.out.println("Nimimerkki on jo käytössä, valitse toinen");
                }
            }
            if (command.equals("42")) {
                System.out.println("Löysit elämän tarkoituksen!");
            }
        }
    }

}
