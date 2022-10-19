package controller;

import config.ServiceConnection;
import model.dto.DeveloperDto;
import services.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getDevelopersByProjectForm")
public class GetDevelopersByProjectFormController extends HttpServlet {
    DeveloperService developerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        developerService = new DeveloperService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/developers/getDevelopersByProjectForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Integer projectId = Integer.parseInt(req.getParameter("projectId"));
            List<DeveloperDto> developers = developerService.developersByProjectId(projectId);
                req.setAttribute("developers", developers);
                req.getRequestDispatcher("/WEB-INF/view/developers/developersByProject.jsp").forward(req, resp);
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/developers/invalidInputsFormat.jsp").forward(req, resp);
        }
    }
}
