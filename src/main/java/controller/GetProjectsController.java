package controller;

import config.ServiceConnection;
import model.dto.ProjectDto;
import services.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/getProjects")
public class GetProjectsController extends HttpServlet {
    ProjectService projectService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        projectService = new ProjectService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<ProjectDto> projects = projectService.projectsList();
            req.setAttribute("projects", projects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/view/projects/getProjects.jsp").forward(req, resp);
    }
}
