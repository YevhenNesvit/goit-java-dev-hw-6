package model.dao;

import java.util.Date;

public class ProjectDao {
    private Integer projectId;
    private String name;
    private Integer customerId;
    private Integer companyId;
    private Integer cost;
    private Date creationDate;

    public ProjectDao(Integer projectId, String name, Integer customerId, Integer companyId, Integer cost, Date creationDate) {
        this.projectId = projectId;
        this.name = name;
        this.customerId = customerId;
        this.companyId = companyId;
        this.cost = cost;
        this.creationDate = creationDate;
    }

    public ProjectDao() {
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

    public void setCreationDate(Date creation_date) {
        this.creationDate = creation_date;
    }
}
