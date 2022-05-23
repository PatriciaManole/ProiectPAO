package database.main.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;

    private DbConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String userName = "root";
            String password = "Parola123";

            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }
}