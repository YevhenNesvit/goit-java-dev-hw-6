package config;

import java.util.Properties;

public class ServiceConnection {

    public DatabaseManagerConnector connect() {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbUsername");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");

        return new DatabaseManagerConnector(properties, dbUsername, dbPassword);
    }
}
