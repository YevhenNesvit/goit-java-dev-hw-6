package services;

import config.ServiceConnection;
import converter.CustomerConverter;
import model.dao.CustomerDao;
import model.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    ServiceConnection serviceConnection = new ServiceConnection();
    private static final String DELETE_CUSTOMER = "DELETE FROM customers where customer_id = ?";
    private static final String SELECT = "SELECT customer_id, name, country FROM customers";
    private static final String SELECT_BY_ID = "SELECT customer_id, name, country FROM customers WHERE customer_id = ?";
    private static final String INSERT = "INSERT INTO customers (customer_id, name, country) VALUES (?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "UPDATE customers SET name = ?, country = ? WHERE customer_id = ?";
    CustomerConverter customerConverter = new CustomerConverter();

    public List<CustomerDto> customerList() throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<CustomerDao> list = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDao customer = new CustomerDao(resultSet.getInt("customer_id"),
                    resultSet.getString("name"), resultSet.getString("country"));

            list.add(customer);
        }

        return customerConverter.fromList(list);
    }

    public CustomerDto customerById(Integer id) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CustomerDao customer = new CustomerDao();
        while (resultSet.next()) {
            customer = new CustomerDao(resultSet.getInt("customer_id"),
                    resultSet.getString("name"), resultSet.getString("country"));
        }

        return customerConverter.from(customer);
    }

    public void updateCustomer(String name, String country, Integer id) throws SQLException {
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER);
            statement.setString(1, name);
            statement.setString(2, country);
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Integer id) throws SQLException {

        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(Integer customerId, String name, String country) throws SQLException {

        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, customerId);
            statement.setString(2, name);
            statement.setString(3, country);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
