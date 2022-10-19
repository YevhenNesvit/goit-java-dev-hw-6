package controller;

import config.ServiceConnection;
import services.DeveloperService;
import utils.CheckDevelopers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateDeveloperForm")
public class UpdateDeveloperFormController extends HttpServlet {
    DeveloperService developerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        developerService = new DeveloperService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/developers/updateDeveloperForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckDevelopers checkDevelopers = new CheckDevelopers();

        try {
            Integer developerId = Integer.parseInt(req.getParameter("developerId"));
            String first_name = req.getParameter("firstName");
            String last_name = req.getParameter("lastName");
            String gender = req.getParameter("gender");
            Integer age = Integer.parseInt(req.getParameter("age"));
            Integer companyId = Integer.parseInt(req.getParameter("companyId"));
            Integer salary = Integer.parseInt(req.getParameter("salary"));
            if (checkDevelopers.IsDeveloperIdExists(developerId)) {
                developerService.updateDeveloper(first_name, last_name, gender, age, companyId, salary, developerId);
                req.getRequestDispatcher("/WEB-INF/view/developers/developerUpdated.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/developers/developerIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/developers/invalidInputsFormat.jsp").forward(req, resp);
        }
    }
}
