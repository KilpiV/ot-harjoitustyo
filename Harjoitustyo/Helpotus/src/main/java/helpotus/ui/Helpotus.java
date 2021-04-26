package helpotus.ui;

import java.util.*;
//import java.sql.*;
//import java.util.Properties;
import java.io.FileInputStream;
import helpotus.domain.Ruokailu;
import helpotus.domain.Ruokalistaus;
import helpotus.domain.User;
import helpotus.dao.RuokalistausDao;
import helpotus.dao.UserDao;
import helpotus.dao.FileRuokailuDao;
import helpotus.dao.FileUserDao;
import helpotus.dao.RuokailuDao;
import helpotus.ui.Helpotus;

public class Helpotus {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello user!!!");
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        
        String userFile = properties.getProperty("userFile");
        String ruokailuFile = properties.getProperty("ruokailuFile");
        
        FileUserDao userDao = new FileUserDao(userFile);
        FileRuokailuDao ruokailuDao = new FileRuokailuDao(ruokailuFile, userDao);
        Scanner scanner = new Scanner(System.in);
        Ruokalistaus ruokalistaus = new Ruokalistaus(ruokailuDao, userDao);

        
        TextUI kayttis = new TextUI(scanner, ruokalistaus);
        kayttis.start();
        System.out.println("Kiitos ja tervetuloa uudelleen");
        
//        String databasePath = "jdbc:sqlite:ruokalista.db";
//        Connection db = DriverManager.getConnection(databasePath);
//        if (args.length > 0) {
//            databasePath = args[0];
//        }
        
//        RuokalistausDao ruoka = new RuokalistausDao(databasePath);
    }
}
