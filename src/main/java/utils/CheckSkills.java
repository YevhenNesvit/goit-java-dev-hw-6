package utils;

import services.SkillService;

import java.sql.SQLException;

public class CheckSkills {
    SkillService skillService = new SkillService();

    public boolean IsSkillIdExists(Integer id) throws SQLException {
        for (int i = 0; i < skillService.skillsList().size(); i++) {
            if(skillService.skillsList().get(i).getSkillId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
