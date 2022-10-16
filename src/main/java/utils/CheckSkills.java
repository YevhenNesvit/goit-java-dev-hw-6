package utils;

import config.ServiceConnection;
import services.SkillService;

import java.sql.SQLException;

public class CheckSkills {
    ServiceConnection connection = new ServiceConnection();
    SkillService skillService = new SkillService(connection.connect());

    public boolean IsSkillIdExists(Integer id) throws SQLException {
        for (int i = 0; i < skillService.skillsList().size(); i++) {
            if(skillService.skillsList().get(i).getSkillId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
