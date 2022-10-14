package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManagerConnector {
    private String url;
    private Properties properties;

    public DatabaseManagerConnector(Properties properties, String username, String password) {
        init(properties, username, password);
    }

    private void init(Properties properties, String username, String password) {
        url = String.format("jdbc:postgresql://%s:%s/%s", properties.get("host"), properties.get("port"),
                properties.get("databaseName"));
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url, properties);
    }
}
