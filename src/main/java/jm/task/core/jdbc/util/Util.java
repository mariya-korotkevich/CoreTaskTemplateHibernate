package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String userName = "root";
    private static final String password = "1234";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/myBase?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
