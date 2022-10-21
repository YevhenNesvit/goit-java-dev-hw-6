package controller.projects;

import config.ServiceConnection;
import services.ProjectService;
import utils.CheckCompanies;
import utils.CheckCustomers;
import utils.CheckProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/createProjectForm")
public class CreateProjectFormController extends HttpServlet {
    ProjectService projectService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        projectService = new ProjectService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/projects/createProjectForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckProjects checkProjects = new CheckProjects();
        CheckCustomers checkCustomers = new CheckCustomers();
        CheckCompanies checkCompanies = new CheckCompanies();

        try {
            Integer projectId = Integer.parseInt(req.getParameter("projectId"));
            String name = req.getParameter("projectName");
            Integer customerId = Integer.parseInt(req.getParameter("customerId"));
            Integer companyId = Integer.parseInt(req.getParameter("companyId"));
            Integer cost = Integer.parseInt(req.getParameter("cost"));
            Date creationDate = java.sql.Date.valueOf(req.getParameter("creationDate"));
            if (checkProjects.IsProjectIdExists(projectId)) {
                req.getRequestDispatcher("/WEB-INF/view/projects/projectIdAlreadyExists.jsp").forward(req, resp);
            } else if (checkCustomers.IsCustomerIdExists(customerId)) {
                if (checkCompanies.IsCompanyIdExists(companyId)) {
                    projectService.createProject(projectId, name, customerId, companyId, cost, creationDate);
                    req.getRequestDispatcher("/WEB-INF/view/projects/projectCreated.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/WEB-INF/view/companies/companyIdNotExists.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("/WEB-INF/view/customers/customerIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/projects/invalidInputsFormat.jsp").forward(req, resp);
        }
    }
}
