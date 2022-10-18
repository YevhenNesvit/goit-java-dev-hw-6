package controller.projects;

import config.ServiceConnection;
import services.ProjectService;
import utils.CheckProjects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteProjectForm")
public class DeleteProjectFormController extends HttpServlet {
    ProjectService projectService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        projectService = new ProjectService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/projects/deleteProjectForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckProjects checkProjects = new CheckProjects();

        try {
            Integer projectId = Integer.parseInt(req.getParameter("projectId"));
            if (checkProjects.IsProjectIdExists(projectId)) {
                projectService.deleteProject(projectId);
                req.getRequestDispatcher("/WEB-INF/view/projects/projectDeleted.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/projects/projectIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/projects/invalidInputsFormat.jsp").forward(req, resp);
        }
    }
}
