package services;

import config.ServiceConnection;
import converter.SkillConverter;
import model.dao.SkillDao;
import model.dto.SkillDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillService {
    ServiceConnection serviceConnection = new ServiceConnection();
    private static final String DELETE_SKILL = "DELETE FROM skills where skill_id = ?";
    private static final String SELECT = "SELECT skill_id, name, skill_level FROM skills";
    private static final String SELECT_BY_ID = "SELECT skill_id, name, skill_level FROM skills WHERE skill_id = ?";
    private static final String INSERT = "INSERT INTO skills (skill_id, name, skill_level) VALUES (?, ?, ?)";
    private static final String UPDATE_SKILL = "UPDATE skills SET name = ?, skill_level = ? WHERE skill_id = ?";
    SkillConverter skillConverter = new SkillConverter();

    public List<SkillDto> skillsList() throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<SkillDao> list = new ArrayList<>();
        while (resultSet.next()) {
            SkillDao skill = new SkillDao(resultSet.getInt("skill_id"),
                    resultSet.getString("name"), resultSet.getString("skill_level"));

            list.add(skill);
        }

        return skillConverter.fromList(list);
    }

    public SkillDto skillById(Integer id) throws SQLException {
        ResultSet resultSet = null;
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SkillDao skill = new SkillDao();
        while (resultSet.next()) {
            skill = new SkillDao(resultSet.getInt("skill_id"),
                    resultSet.getString("name"), resultSet.getString("skill_level"));
        }

        return skillConverter.from(skill);
    }

    public void updateDeveloper(String name, String skillLevel, Integer id) throws SQLException {
        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SKILL);
            statement.setString(1, name);
            statement.setString(2, skillLevel);
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSkill(Integer id) throws SQLException {

        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_SKILL);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSkill(Integer skillId, String name, String skillLevel) throws SQLException {

        try (Connection connection = serviceConnection.connect().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1, skillId);
            statement.setString(2, name);
            statement.setString(3, skillLevel);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
