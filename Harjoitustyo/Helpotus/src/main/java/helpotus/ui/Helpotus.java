package helpotus.ui;

import java.util.*;
//import java.sql.*;
//import java.util.Properties;
import java.io.FileInputStream;
//import helpotus.domain.Eating;
import helpotus.domain.FoodListings;
//import helpotus.domain.User;
//import helpotus.dao.UserDao;
import helpotus.dao.FileEatingDao;
import helpotus.dao.FileUserDao;
//import helpotus.ui.Helpotus;
//import helpotus.dao.EatingDao;

public class Helpotus {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello user!!!");

        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        String userFile = properties.getProperty("userFile");
        String eatingFile = properties.getProperty("eatingsFile");

        FileUserDao userDao = new FileUserDao(userFile);
        FileEatingDao eatingDao = new FileEatingDao(eatingFile, userDao);
        FoodListings foodListing = new FoodListings(eatingDao, userDao);
        Scanner scanner = new Scanner(System.in);

        TextUI textUi = new TextUI(scanner, foodListing);
        textUi.start();

        System.out.println("Kiitos ja tervetuloa uudelleen");
    }
}
