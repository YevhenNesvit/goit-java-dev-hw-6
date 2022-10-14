package model.dto;

import java.util.Objects;

public class CompanyDto {
    Integer companyId;
    String name;
    String country;

    public CompanyDto(Integer companyId, String name, String country) {
        this.companyId = companyId;
        this.name = name;
        this.country = country;
    }

    public CompanyDto() {
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

    @Override
    public String toString() {
        return "CompanyDto {" +
                "companyId = " + companyId +
                ", name = '" + name + '\'' +
                ", country = '" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyDto)) return false;
        CompanyDto that = (CompanyDto) o;
        return Objects.equals(getCompanyId(), that.getCompanyId()) && Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyId(), getName(), getCountry());
    }
}
