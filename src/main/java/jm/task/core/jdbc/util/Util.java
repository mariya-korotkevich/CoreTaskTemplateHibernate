package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.Metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Util {

    private static final String userName = "root";
    private static final String password = "1234";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/myBase?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionURL, userName, password);
    }

    public static SessionFactory getSessionFactory() {
        Map<String, String> settings = new HashMap<>();
        settings.put("hibernate.connection.url", connectionURL);
        settings.put("hibernate.connection.username", userName);
        settings.put("hibernate.connection.password", password);
        settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.current_session_context_class", "thread");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).buildMetadata();

        return metadata.buildSessionFactory();
    }
}
