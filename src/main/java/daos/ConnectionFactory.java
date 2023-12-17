package daos;
import com.mysql.jdbc.Driver;
import models.WordInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connect to Database
 * @author hany.said
 */
public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/dictionary";
    public static final String USER = "louie";
    public static final String PASS = "louie92";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        WordInfoDAO wid = new WordInfoDAO();
        System.out.println(wid.findAll());
        WordInfo dog = new WordInfo(6, 1, "Dog", "Man's best friend", "I got dat dog in me.", "dawg", "Da dawg house");
        wid.create(dog);
        System.out.println(wid.findById(6));
        WordInfo doggy = new WordInfo(6, 1, "Doggy", "Man's best friend", "I got dat dog in me.", "dawg", "Da dawg house");
        wid.update(doggy);
        System.out.println(wid.findById(6));
        wid.delete(6);
        System.out.println(wid.findAll());
    }

}