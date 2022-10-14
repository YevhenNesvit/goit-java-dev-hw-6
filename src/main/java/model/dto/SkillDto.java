package model.dto;

import java.util.Objects;

public class SkillDto {
    Integer skillId;
    String name;
    String skillLevel;

    public SkillDto(Integer skillId, String name, String skillLevel) {
        this.skillId = skillId;
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public SkillDto() {

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

    @Override
    public String toString() {
        return "SkillDto {" +
                "skillId = " + skillId +
                ", name = '" + name + '\'' +
                ", skillLevel = '" + skillLevel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillDto)) return false;
        SkillDto skillDto = (SkillDto) o;
        return Objects.equals(getSkillId(), skillDto.getSkillId()) && Objects.equals(getName(), skillDto.getName()) &&
                Objects.equals(getSkillLevel(), skillDto.getSkillLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(), getName(), getSkillLevel());
    }
}
