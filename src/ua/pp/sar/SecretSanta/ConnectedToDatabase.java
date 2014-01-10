package ua.pp.sar.SecretSanta;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by WildGorn on 05.01.14.
 */
public class ConnectedToDatabase {
    private static Connection connection;

    public ConnectedToDatabase() {
    }

    public static Connection getConnection(String login, String password) throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/secret_santa" +
                    "?user=" + login +
                    "&password=" + password);
        }
        return connection;
    }
}
