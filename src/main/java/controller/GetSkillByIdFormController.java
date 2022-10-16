package controller;

import config.ServiceConnection;
import model.dto.SkillDto;
import services.SkillService;
import utils.CheckSkills;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/getSkillByIdForm")
public class GetSkillByIdFormController extends HttpServlet {
    SkillService skillService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        skillService = new SkillService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/skills/getSkillByIdForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckSkills checkSkills = new CheckSkills();

        try {
            List<SkillDto> skills = new ArrayList<>();
            Integer skillId = Integer.parseInt(req.getParameter("skillId"));
            if (checkSkills.IsSkillIdExists(skillId)) {
                skills.add(skillService.skillById(skillId));
                req.setAttribute("skills", skills);
                req.getRequestDispatcher("/WEB-INF/view/skills/skillById.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/skills/skillIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/skills/invalidSkillIdFormat.jsp").forward(req, resp);
        }
    }
}
