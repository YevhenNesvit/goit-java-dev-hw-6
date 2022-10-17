package utils;

import config.ServiceConnection;
import services.ProjectService;

import java.sql.SQLException;

public class CheckProjects {
    ServiceConnection connection = new ServiceConnection();
    ProjectService projectService = new ProjectService(connection.connect());

    public boolean IsProjectIdExists(Integer id) throws SQLException {
        for (int i = 0; i < projectService.projectsList().size(); i++) {
            if(projectService.projectsList().get(i).getProjectId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
