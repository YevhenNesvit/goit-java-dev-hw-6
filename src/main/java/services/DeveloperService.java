package services;

import config.ServiceConnection;
import converter.DeveloperConverter;
import model.dao.DeveloperDao;
import model.dto.DeveloperDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DeveloperService {
    ServiceConnection serviceConnection = new ServiceConnection();
    private static final String SALARY_BY_PROJECT_ID = "SELECT SUM(d.salary) as salary " +
            "FROM developers d JOIN developers_per_projects dpp ON dpp.developer_id = d.developer_id " +
            "JOIN projects p ON p.project_id = dpp.project_id WHERE p.project_id = ?";
    private static final String DEVELOPERS_BY_PROJECT_ID = "SELECT d.developer_id, d.first_name, d.last_name, d.gender, " +
            "d.age, d.company_id, d.salary " +
            "FROM developers d " +
            "JOIN developers_per_projects dpp ON dpp.developer_id = d.developer_id " +
            "JOIN projects p ON p.project_id = dpp.project_id " +
            "WHERE p.project_id = ?";
    private static final String DEVELOPERS_BY_SKILL_NAME = "SELECT d.developer_id, d.first_name, d.last_name, d.gender, " +
            "d.age, d.company_id, d.salary " +
            "FROM developers d " +
            "JOIN developers_skills ds ON ds.developer_id = d.developer_id " +
            "JOIN skills s ON s.skill_id = ds.skill_id " +
            "WHERE s.name = ?";
    private static final String DEVELOPERS_BY_SKILL_LEVEL = "SELECT d.developer_id, d.first_name, d.last_name, d.gender," +
            "d.age, d.company_id, d.salary " +
            "FROM developers d " +
            "JOIN developers_skills ds ON ds.developer_id = d.developer_id " +
            "JOIN skills s ON s.skill_id = ds.skill_id " +
            "WHERE s.skill_level = ?";
    private static final String DELETE_DEVELOPER = "DELETE FROM developers where developer_id = ?";
    private static final String INSERT = "INSERT INTO developers (developer_id, first_name, last_name, gender, " +
            "age, company_id, salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT developer_id, first_name, last_name, gender, age, company_id, salary " +
            "FROM developers";
    private static final String SELECT_BY_ID = "SELECT developer_id, first_name, last_name, gender, age, company_id, salary " +
            "FROM developers " +
            "WHERE developer_id = ?";
    private static final String UPDATE_DEVELOPER = "UPDATE developers SET first_name = ?, last_name = ?, gender = ?, age = ?, " +
            "company_id = ?, salary = ? " +
            "WHERE developer_id = ?";
    DeveloperConverter developerConverter = new DeveloperConverter();

    public Integer salaryByProjectId(Integer id) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SALARY_BY_PROJECT_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DeveloperDao developer = new DeveloperDao();
        while (resultSet.next()) {
            developer.setSalary(resultSet.getInt("salary"));
        }
        return developerConverter.from(developer).getSalary();
    }

    public List<DeveloperDto> developersByProjectId(Integer id) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DEVELOPERS_BY_PROJECT_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<DeveloperDao> list = new ArrayList<>();
        while (resultSet.next()) {
            DeveloperDao developer = new DeveloperDao(resultSet.getInt("developer_id"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("gender"), resultSet.getInt("age"),
                    resultSet.getInt("company_id"), resultSet.getInt("salary"));

            list.add(developer);
        }

        return developerConverter.fromList(list);
    }

    public List<DeveloperDto> developersBySkillName(String name) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DEVELOPERS_BY_SKILL_NAME);
            statement.setString(1, name);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<DeveloperDao> list = new ArrayList<>();
        while (resultSet.next()) {
            DeveloperDao developer = new DeveloperDao(resultSet.getInt("developer_id"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("gender"), resultSet.getInt("age"),
                    resultSet.getInt("company_id"), resultSet.getInt("salary"));

            list.add(developer);
        }

        return developerConverter.fromList(list);
    }

    public List<DeveloperDto> developersBySkillLevel(String level) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DEVELOPERS_BY_SKILL_LEVEL);
            statement.setString(1, level);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<DeveloperDao> list = new ArrayList<>();
        while (resultSet.next()) {
            DeveloperDao developer = new DeveloperDao(resultSet.getInt("developer_id"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("gender"), resultSet.getInt("age"),
                    resultSet.getInt("company_id"), resultSet.getInt("salary"));

            list.add(developer);
        }

        return developerConverter.fromList(list);
    }

    public List<DeveloperDto> developersList() throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<DeveloperDao> list = new ArrayList<>();
        while (resultSet.next()) {
            DeveloperDao developer = new DeveloperDao(resultSet.getInt("developer_id"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("gender"), resultSet.getInt("age"),
                    resultSet.getInt("company_id"), resultSet.getInt("salary"));

            list.add(developer);
        }

        return developerConverter.fromList(list);
    }

    public DeveloperDto developerById(Integer id) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DeveloperDao developer = new DeveloperDao();
        while (resultSet.next()) {
            developer = new DeveloperDao(resultSet.getInt("developer_id"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("gender"), resultSet.getInt("age"),
                    resultSet.getInt("company_id"), resultSet.getInt("salary"));
        }

        return developerConverter.from(developer);
    }

    public void updateDeveloper(String firstName, String lastName, String gender, Integer age, Integer companyId,
                                Integer salary, Integer id) throws SQLException {
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_DEVELOPER);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, companyId);
            statement.setInt(6, salary);
            statement.setInt(7, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeveloper(Integer id) throws SQLException {

        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_DEVELOPER);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDeveloper(Integer developerId, String firstName, String lastName, String gender, Integer age,
                                Integer companyId, Integer salary) throws SQLException {

        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, developerId);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, gender);
            statement.setInt(5, age);
            statement.setInt(6, companyId);
            statement.setInt(7, salary);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
