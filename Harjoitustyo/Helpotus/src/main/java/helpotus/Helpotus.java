package helpotus;

import java.util.*;
import java.sql.*;
//import helpotus.TextUI;

public class Helpotus {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello user!!!");
        String databasePath = "jdbc:sqlite:ruokalista.db";
//        Connection db = DriverManager.getConnection(databasePath);
        Scanner scanner = new Scanner(System.in);
        if (args.length > 0) {
            databasePath = args[0];
        }
        
        RuokalistausDao ruoka = new RuokalistausDao(databasePath);
        
        TextUI kayttis = new TextUI(scanner, ruoka);
        kayttis.start();
        System.out.println("Kiitos ja tervetuloa uudelleen");
    }
}
