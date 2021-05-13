package helpotus.ui;

import java.util.*;
import java.io.FileInputStream;
import java.io.File;
import helpotus.domain.FoodListings;
import helpotus.dao.FileEatingDao;
import helpotus.dao.FileUserDao;

/**
 * Ohjelman käynnistävä luokka.
 */
public class Helpotus {

    /**
     * Main metodi, joka käynnistää koko ohjelman.
     *
     * @param args komentorivin parametrit
     * @throws Exception kun ei pysty lukemisessa on ongelma
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello user!!!");

        Properties properties = new Properties();
        File file = new File("config.properties");
        if (file.exists()) {
            properties.load(new FileInputStream(file));
            String userFile = properties.getProperty("userFile");
            String eatingFile = properties.getProperty("eatingsFile");

            FileUserDao userDao = new FileUserDao(userFile);
            FileEatingDao eatingDao = new FileEatingDao(eatingFile, userDao);
            FoodListings foodListing = new FoodListings(eatingDao, userDao);
            Scanner scanner = new Scanner(System.in);

            TextUI textUi = new TextUI(scanner, foodListing);
            textUi.start();

            System.out.println("Kiitos ja tervetuloa uudelleen");
        } else {
            System.out.println("Puuttuu config.properties");
            System.out.println("Suljetaan ohjelma, luo config.properties ja yritä uudestaan");
        }
    }
}
