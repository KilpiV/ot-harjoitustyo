package helpotus.ui;

import java.sql.SQLException;
import java.util.*;
import helpotus.domain.Ruokalistaus;
import helpotus.dao.RuokalistausDao;

//lisää käyttäjä... ja ruokalistauksiin myös ja niiden hakuihin...
public class TextUI {

    private ArrayList<Ruokalistaus> foods;

    private Scanner scanner;
    private RuokalistausDao database;

    public TextUI(Scanner scanner, RuokalistausDao database) {
        this.scanner = scanner;
        this.database = database;
        this.foods = new ArrayList<>();
    }

    public String askDate() {
        String year;
        String month;
        String day;
        while (true) {

            System.out.println("Anna ensin vuosi");
            System.out.print(">> ");
            year = this.scanner.nextLine();
//                    while (year.length() != 4) {
//                        System.out.println("virheellinen vuosiluku, anna vuosiluku muodossa yyyy!");
//                        System.out.println("Anna vuosi");
//                        System.out.print(">> ");
//                        year = this.scanner.nextLine();
//                    }
            boolean rightYear = false;
            if (year.length() == 4) {
                if ((year.charAt(0) == '1' && year.charAt(1) == '9')
                        || (year.charAt(0) == '2' && year.charAt(1) == '0')) { // jos alkaa muulla kuin 19--
                    if (year.charAt(2) == '0' || year.charAt(2) == '1' || year.charAt(2) == '2'
                            || year.charAt(2) == '3' || year.charAt(2) == '4' || year.charAt(2) == '5'
                            || year.charAt(2) == '6' || year.charAt(2) == '7'
                            || year.charAt(2) == '8' || year.charAt(2) == '9') {
                        if (year.charAt(3) == '0' || year.charAt(3) == '1' || year.charAt(3) == '2'
                                || year.charAt(3) == '3' || year.charAt(3) == '4' || year.charAt(3) == '5'
                                || year.charAt(3) == '6' || year.charAt(3) == '7'
                                || year.charAt(3) == '8' || year.charAt(3) == '9') {
                            rightYear = true;
                        }
                    }

                } else if (year.charAt(0) == '2' && year.charAt(1) == '1'
                        && year.charAt(2) == '0' && year.charAt(3) == '0') {
//                    System.out.println("oikein...2100 korkein");
                    rightYear = true;
                }
            }
            if (year.length() == 4 && rightYear) {
                break;
            }
            System.out.println("virheellinen vuosiluku, anna vuosiluku muodossa yyyy!");
        }
        while (true) {
            System.out.println("Anna seuraavaksi kuukausi");
            System.out.print(">> ");
            month = this.scanner.nextLine();
//                    if(month.equals("x")) {               //  paluu vaihtoehto???
            if (month.length() == 2) {
                if (month.charAt(0) == '1') {
                    if (month.charAt(1) == '0' || month.charAt(1) == '1' || month.charAt(1) == '2') {
                        break;
                    }
                }
                if (month.charAt(0) == '0') {
                    if (month.charAt(1) == '1' || month.charAt(1) == '2' || month.charAt(1) == '3'
                            || month.charAt(1) == '4' || month.charAt(1) == '5' || month.charAt(1) == '6'
                            || month.charAt(1) == '7' || month.charAt(1) == '8' || month.charAt(1) == '9') {
                        break;
                    }
                }
            }
            if (month.length() == 1) {
                if (month.charAt(0) == '1' || month.charAt(0) == '2' || month.charAt(0) == '3'
                        || month.charAt(0) == '4' || month.charAt(0) == '5' || month.charAt(0) == '6'
                        || month.charAt(0) == '7' || month.charAt(0) == '8' || month.charAt(0) == '9') {
                    break;
                }

            }

            System.out.println("virheellinen kuukausi!");
        }
        if (month.length() == 1) {
            month = "0" + month;
        }
        while (true) {
            System.out.println("Anna vielä päivämäärä");
            System.out.print(">> ");
            day = this.scanner.nextLine();
//                    if(month.equals("x")) {               //  paluu vaihtoehto???
//                    boolean rightMonth = false;
//                                      jos karkausvuosi... jos kuukausi == 2...????
            if (day.length() == 2) {
                if (day.charAt(0) == '3') {
                    if (day.charAt(1) == '0' || day.charAt(1) == '1') {
                        break;
                    }
                }
                if (day.charAt(0) == '1' || day.charAt(0) == '2') {
                    if (day.charAt(1) == '1' || day.charAt(1) == '2' || day.charAt(1) == '3'
                            || day.charAt(1) == '4' || day.charAt(1) == '5' || day.charAt(1) == '6'
                            || day.charAt(1) == '7' || day.charAt(1) == '8'
                            || day.charAt(1) == '9' || day.charAt(1) == '0') {
                        break;
                    }
                }
                if (day.charAt(0) == '0') {
                    if (day.charAt(1) == '1' || day.charAt(1) == '2' || day.charAt(1) == '3'
                            || day.charAt(1) == '4' || day.charAt(1) == '5' || day.charAt(1) == '6'
                            || day.charAt(1) == '7' || day.charAt(1) == '8' || day.charAt(1) == '9') {
                        break;
                    }
                }
            }
            if (day.length() == 1) {
                if (day.charAt(0) == '1' || day.charAt(0) == '2' || day.charAt(0) == '3'
                        || day.charAt(0) == '4' || day.charAt(0) == '5' || day.charAt(0) == '6'
                        || day.charAt(0) == '7' || day.charAt(0) == '8' || day.charAt(0) == '9') {
                    break;
                }

            }

            System.out.println("virheellinen päiväys!");
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        System.out.println("Annoit päivämäärän " + day + "-" + month + "-" + year);
        String date = day + "-" + month + "-" + year;
        return date;
    }

    public void start() throws SQLException {
//        System.out.println("Testi....");
        while (true) {
            System.out.println("");
            System.out.println("---");
            System.out.println("Syötä käsky");
            System.out.println("(1) lisää ruokia");
            System.out.println("(2) tarkasta syömisiä");
            System.out.println("(x) poistu");
            System.out.print(">> ");

            String command = this.scanner.nextLine();
            if (command.equals("x") || command.equals("X")) {
                break;
            }
            if (command.equals("1")) {
                System.out.println("Anna lisättävän ruokailun päivämäärä");
                String date = askDate();
                System.out.println("Anna lisättävä ruoka");
                System.out.print(">> ");
                String food = scanner.nextLine();
                System.out.println("Anna määrä");
                int quantity = Integer.valueOf(scanner.nextLine());
                this.foods.add(new Ruokalistaus(date, food, quantity));
//                this.database.add(new Ruokalistaus(date, food, quantity));

            }
            if (command.equals("2")) {

                System.out.println("Anna ruokailun päivämäärä");
                String date = askDate();
                System.out.println("Päivän ruokailut:");
                System.out.println(this.foods);
//                System.out.println(this.database.List(date));
                // hae kyseisen päivän ruokailut listaus

            }
            if (command.equals("42")) {
                System.out.println("Löysit elämän tarkoituksen!");
            }
        }
    }

}
