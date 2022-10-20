package model.dto;

import java.sql.Date;
import java.util.Objects;

public class ProjectDto {
    private Integer projectId;
    private String name;
    private Integer customerId;
    private Integer companyId;
    private Integer cost;
    private Date creationDate;

    public ProjectDto() {

    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDto)) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(getProjectId(), that.getProjectId()) && Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getCompanyId(), that.getCompanyId())
                && Objects.equals(getCost(), that.getCost()) && Objects.equals(getCreationDate(), that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getName(), getCustomerId(), getCompanyId(), getCost(), getCreationDate());
    }
}
