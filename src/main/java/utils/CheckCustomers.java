package utils;

import services.CustomerService;

import java.sql.SQLException;

public class CheckCustomers {
    CustomerService customerService = new CustomerService();

    public boolean IsCustomerIdExists(Integer id) throws SQLException {
        for (int i = 0; i < customerService.customerList().size(); i++) {
            if(customerService.customerList().get(i).getCustomerId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
