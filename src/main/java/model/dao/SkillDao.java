package model.dao;

public class SkillDao {
    Integer skillId;
    String name;
    String skillLevel;

    public SkillDao(Integer skillId, String name, String skillLevel) {
        this.skillId = skillId;
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public SkillDao() {

    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
}
