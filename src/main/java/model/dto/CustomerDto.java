package model.dto;

import java.util.Objects;

public class CustomerDto {
    private Integer customerId;
    private String name;
    private String country;

    public CustomerDto(Integer customerId, String name, String country) {
        this.customerId = customerId;
        this.name = name;
        this.country = country;
    }

    public CustomerDto() {

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
        return "CustomerDto {" +
                "customerId = " + customerId +
                ", name = '" + name + '\'' +
                ", country = '" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDto)) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getName(), getCountry());
    }
}
