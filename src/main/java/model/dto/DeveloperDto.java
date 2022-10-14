package model.dto;

import java.util.Objects;

public class DeveloperDto {
    private Integer developerId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Integer companyId;
    private Integer salary;

    public DeveloperDto(Integer developerId, String firstName, String lastName, String gender, Integer age,
                        Integer companyId, Integer salary) {
        this.developerId = developerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.companyId = companyId;
        this.salary = salary;
    }

    public DeveloperDto() {
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "DeveloperDto {" +
                "developerId = " + developerId +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", gender = '" + gender + '\'' +
                ", age = " + age +
                ", companyId = " + companyId +
                ", salary = " + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeveloperDto)) return false;
        DeveloperDto that = (DeveloperDto) o;
        return Objects.equals(getDeveloperId(), that.getDeveloperId()) && Objects.equals(getFirstName(),
                that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getGender(),
                that.getGender()) && Objects.equals(getAge(), that.getAge()) && Objects.equals(getCompanyId(),
                that.getCompanyId()) && Objects.equals(getSalary(), that.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeveloperId(), getFirstName(), getLastName(), getGender(), getAge(), getCompanyId(), getSalary());
    }
}
