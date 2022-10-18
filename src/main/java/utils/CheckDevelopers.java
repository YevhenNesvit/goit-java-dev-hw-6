package utils;

import config.ServiceConnection;
import services.DeveloperService;

import java.sql.SQLException;

public class CheckDevelopers {
    ServiceConnection connection = new ServiceConnection();
    DeveloperService developerService = new DeveloperService(connection.connect());

    public boolean IsDeveloperIdExists(Integer id) throws SQLException {
        for (int i = 0; i < developerService.developersList().size(); i++) {
            if(developerService.developersList().get(i).getDeveloperId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
