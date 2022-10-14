package model.dto;

import java.util.Date;
import java.util.Objects;

public class ProjectDto {
    private Date creationDate;
    private String name;
    private int numberOfDevelopers;

    public ProjectDto() {
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public void setNumberOfDevelopers(int numberOfDevelopers) {
        this.numberOfDevelopers = numberOfDevelopers;
    }

    @Override
    public String toString() {
        return "ProjectDto {" +
                "creation_date = " + creationDate +
                ", name = '" + name + '\'' +
                ", numberOfDevelopers = " + numberOfDevelopers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDto)) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(getCreationDate(), that.getCreationDate()) && Objects.equals(getName(), that.getName())
                && Objects.equals(getNumberOfDevelopers(), that.getNumberOfDevelopers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreationDate(), getName(), getNumberOfDevelopers());
    }
}
