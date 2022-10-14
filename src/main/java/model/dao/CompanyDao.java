package model.dao;

public class CompanyDao {
    Integer companyId;
    String name;
    String country;

    public CompanyDao(Integer companyId, String name, String country) {
        this.companyId = companyId;
        this.name = name;
        this.country = country;
    }

    public CompanyDao() {

    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
