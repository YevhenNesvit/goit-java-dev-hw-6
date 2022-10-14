package utils;

import services.DeveloperService;

import java.sql.SQLException;

public class CheckDevelopers {

    DeveloperService developerService = new DeveloperService();

    public boolean IsDeveloperIdExists(Integer id) throws SQLException {
        for (int i = 0; i < developerService.developersList().size(); i++) {
            if(developerService.developersList().get(i).getDeveloperId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
