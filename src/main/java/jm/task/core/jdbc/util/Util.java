package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection getConnection() throws SQLException {
        String userName = "root";
        String password = "1234";
        String connectionURL = "jdbc:mysql://localhost:3306/myBase?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
