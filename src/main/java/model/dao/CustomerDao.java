package model.dao;

public class CustomerDao {
    private Integer customerId;
    private String name;
    private String country;

    public CustomerDao(Integer customerId, String name, String country) {
        this.customerId = customerId;
        this.name = name;
        this.country = country;
    }

    public CustomerDao() {

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
}
