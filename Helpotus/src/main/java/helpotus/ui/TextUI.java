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
            String answer = this.dates.yearRight(year);
            if (answer.equals(year)) {
                break;
            } else {
                System.out.println(answer);
            }
        }
        while (true) {
            System.out.println("Anna seuraavaksi kuukausi");
            System.out.print(">> ");
            month = this.userScanner.nextLine();
            String answer = this.dates.monthRight(month);
            if (answer.equals(month) || answer.equals("0" + month)) {
                month = answer;
                break;
            } else {
                System.out.println(answer);
            }
        }
        int yearDigit = Integer.parseInt(year);
        int monthDigit = Integer.parseInt(month);
        while (true) {
            System.out.println("Anna vielä päivämäärä");
            System.out.print(">> ");
            day = this.userScanner.nextLine();
            String answer = this.dates.dayRight(day, yearDigit, monthDigit);
            if (answer.equals(day) || answer.equals("0" + day)) {
                day = answer;
                break;
            } else {
                System.out.println(answer);
            }
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
