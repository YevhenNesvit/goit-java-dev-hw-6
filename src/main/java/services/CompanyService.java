package services;

import config.DatabaseManagerConnector;
import converter.CompanyConverter;
import model.dao.CompanyDao;
import model.dto.CompanyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private static final String DELETE_COMPANY = "DELETE FROM companies where company_id = ?";
    private static final String SELECT = "SELECT company_id, name, country FROM companies";
    private static final String SELECT_BY_ID = "SELECT company_id, name, country FROM companies " +
            "WHERE company_id = ?";
    private static final String INSERT_COMPANY = "INSERT INTO companies (company_id, name, country) VALUES (?, ?, ?)";
    private static final String UPDATE_COMPANY = "UPDATE companies SET name = ?, country = ? WHERE company_id = ?";
    CompanyConverter companyConverter = new CompanyConverter();
    DatabaseManagerConnector connector;

    public CompanyService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<CompanyDto> companiesList() throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<CompanyDao> list = new ArrayList<>();
        if (resultSet != null) {
            while (resultSet.next()) {
                CompanyDao company = new CompanyDao(resultSet.getInt("company_id"),
                        resultSet.getString("name"), resultSet.getString("country"));

                list.add(company);
            }
        }

        return companyConverter.fromList(list);
    }

    public CompanyDto companyById(Integer id) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CompanyDao company = new CompanyDao();
        while (resultSet.next()) {
            company = new CompanyDao(resultSet.getInt("company_id"),
                    resultSet.getString("name"), resultSet.getString("country"));
        }

        return companyConverter.from(company);
    }

    public void updateCompany(String name, String country, Integer id) throws SQLException {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_COMPANY);
            statement.setString(1, name);
            statement.setString(2, country);
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(Integer id) throws SQLException {

        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCompany(Integer companyId, String name, String country) throws SQLException {

        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_COMPANY);
            statement.setInt(1, companyId);
            statement.setString(2, name);
            statement.setString(3, country);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
