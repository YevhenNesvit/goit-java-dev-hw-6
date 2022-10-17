package controller.skills;

import config.ServiceConnection;
import model.dto.SkillDto;
import services.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/getSkills")
public class GetSkillsController extends HttpServlet {
    SkillService skillService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        skillService = new SkillService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<SkillDto> skills = skillService.skillsList();
            req.setAttribute("skills", skills);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/view/skills/getSkills.jsp").forward(req, resp);
    }
}
