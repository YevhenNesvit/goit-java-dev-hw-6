package controller;

import config.ServiceConnection;
import services.SkillService;
import utils.CheckSkills;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateSkillForm")
public class UpdateSkillFormController extends HttpServlet {
    SkillService skillService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        skillService = new SkillService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/skills/updateSkillForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckSkills checkSkills = new CheckSkills();

        try {
            Integer skillId = Integer.parseInt(req.getParameter("skillId"));
            String name = req.getParameter("skillName");
            String skillLevel = req.getParameter("skillLevel");
            if (checkSkills.IsSkillIdExists(skillId)) {
                skillService.updateSkill(name, skillLevel, skillId);
                req.getRequestDispatcher("/WEB-INF/view/skills/skillUpdated.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/skills/skillIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/skills/invalidSkillIdFormat.jsp").forward(req, resp);
        }
    }
}
