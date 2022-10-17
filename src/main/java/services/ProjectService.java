package services;

import config.DatabaseManagerConnector;
import converter.ProjectConverter;
import model.dao.ProjectDao;
import model.dto.ProjectDto;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ProjectService {
    private static final String PROJECTS_LIST = "SELECT p.creation_date, p.name, count(d.developer_id) as count, p.project_id," +
            "p.company_id, p.customer_id, p.cost " +
            "FROM projects p " +
            "JOIN developers_per_projects dpp ON dpp.project_id = p.project_id " +
            "JOIN developers d ON d.developer_id = dpp.developer_id " +
            "GROUP BY p.project_id, p.creation_date, p.name " +
            "ORDER BY p.project_id";
    private static final String DELETE_PROJECT = "DELETE FROM projects where project_id = ?";
    private static final String INSERT = "INSERT INTO projects (project_id, name, customer_id, company_id, cost, " +
            "creation_date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PROJECT = "UPDATE projects SET name = ?, customer_id = ?, company_id = ?, cost = ?," +
            "creation_date = ? WHERE project_id = ?";
    ProjectConverter projectConverter = new ProjectConverter();
    DatabaseManagerConnector connector;

    public ProjectService(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public List<ProjectDto> projectsList() throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(PROJECTS_LIST);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<ProjectDao> list = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        while (resultSet.next()) {
            ProjectDao project = new ProjectDao(resultSet.getInt("project_id"), resultSet.getString("name"),
                    resultSet.getInt("customer_id"), resultSet.getInt("company_id"),
                    resultSet.getInt("cost"), resultSet.getDate("creation_date"));
            count.add(resultSet.getInt("count"));
            list.add(project);
        }
        List<ProjectDto> projectDto = projectConverter.fromList(list);
        for (int i = 0; i < projectDto.size(); i++) {
            projectDto.get(i).setNumberOfDevelopers(count.get(i));
        }

        return projectDto;
    }

    public void updateProject(Integer id, String name, Integer customerId, Integer companyId, Integer cost, Date creationDate) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECT);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, customerId);
            statement.setInt(4, companyId);
            statement.setInt(5, cost);
            statement.setDate(6, creationDate);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(Integer id) throws SQLException {

        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createProject(Integer projectId, String name, Integer customerId, Integer companyId, Integer cost,
                                Date creationDate) throws SQLException {

        try (Connection connection = connector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, projectId);
            statement.setString(2, name);
            statement.setInt(3, customerId);
            statement.setInt(4, companyId);
            statement.setInt(5, cost);
            statement.setDate(6, creationDate);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
