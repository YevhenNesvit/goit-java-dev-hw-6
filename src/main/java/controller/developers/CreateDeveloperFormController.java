package controller.developers;

import config.ServiceConnection;
import services.DeveloperService;
import utils.CheckCompanies;
import utils.CheckDevelopers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/createDeveloperForm")
public class CreateDeveloperFormController extends HttpServlet {
    DeveloperService developerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        developerService = new DeveloperService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/developers/createDeveloperForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckDevelopers checkDevelopers = new CheckDevelopers();
        CheckCompanies checkCompanies = new CheckCompanies();

        try {
            Integer developerId = Integer.parseInt(req.getParameter("developerId"));
            String first_name = req.getParameter("firstName");
            String last_name = req.getParameter("lastName");
            String gender = req.getParameter("gender");
            Integer age = Integer.parseInt(req.getParameter("age"));
            Integer companyId = Integer.parseInt(req.getParameter("companyId"));
            Integer salary = Integer.parseInt(req.getParameter("salary"));
            if (checkDevelopers.IsDeveloperIdExists(developerId)) {
                req.getRequestDispatcher("/WEB-INF/view/developers/developerIdAlreadyExists.jsp").forward(req, resp);
            } else if (checkCompanies.IsCompanyIdExists(companyId)) {
                developerService.createDeveloper(developerId, first_name, last_name, gender, age, companyId, salary);
                req.getRequestDispatcher("/WEB-INF/view/developers/developerCreated.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/companies/companyIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/developers/invalidInputsFormat.jsp").forward(req, resp);
        }
    }
}
