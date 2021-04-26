package helpotus.dao;

import java.sql.*;
import java.util.*;
import helpotus.domain.Ruokalistaus;
import helpotus.ui.Helpotus;
import helpotus.ui.TextUI;


public class RuokalistausDao {

    private String databasePath;

    public RuokalistausDao(String databasePath) {
        this.databasePath = databasePath;
    }

//    private Connection createConnectionAndEnsureDatabase() throws SQLException {
//        Connection connection = DriverManager.getConnection(this.databasePath); // selvitä
//        try {
//            connection.prepareStatement("CREATE TABLE Ruoka (id int auto_increment primary key, paivays, ruoka varchar(100), int maara)").execute();
//        } catch (SQLException t) {
//
//        }
//        return connection;
//    }

//    public List<Ruokalistaus> list(String paivays) throws SQLException {
//        List<Ruokalistaus> ruuat = new ArrayList<>();
//        try (Connection connection = createConnectionAndEnsureDatabase();
//                ResultSet results = connection.prepareStatement("SELECT * FROM Ruoka WHERE paivays= ?").executeQuery()) { // WHERE paivays = ?
////                results.getString(1, paivays);
//            while (results.next()) {
//                ruuat.add(new Ruokalistaus(results.getString("paivays"), results.getString("ruoka"), results.getInt("maara")));
//            }
//        }
//        return ruuat;
//    }

//    public void add(Ruokalistaus ruoka) throws SQLException {
//        try (Connection connection = createConnectionAndEnsureDatabase()) {
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO Ruoka (paivays, ruoka, maara) VALUES (?, ?, ?)");
//            statement.setString(1, ruoka.getDate());
//            statement.setString(2, ruoka.getFood());
//            statement.setInt(3, ruoka.getQuantity());
//            statement.executeUpdate();
//
//        }
//    }

}
