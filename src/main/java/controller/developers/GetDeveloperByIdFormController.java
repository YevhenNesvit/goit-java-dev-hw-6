package controller.developers;

import config.ServiceConnection;
import model.dto.DeveloperDto;
import services.DeveloperService;
import utils.CheckDevelopers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/getDeveloperByIdForm")
public class GetDeveloperByIdFormController extends HttpServlet {
    DeveloperService developerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        developerService = new DeveloperService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/developers/getDeveloperByIdForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckDevelopers checkDevelopers = new CheckDevelopers();

        try {
            List<DeveloperDto> developers = new ArrayList<>();
            Integer developerId = Integer.parseInt(req.getParameter("developerId"));
            if (checkDevelopers.IsDeveloperIdExists(developerId)) {
                developers.add(developerService.developerById(developerId));
                req.setAttribute("developers", developers);
                req.getRequestDispatcher("/WEB-INF/view/developers/developerById.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/developers/developerIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/developers/invalidInputsFormat.jsp").forward(req, resp);
        }
    }
}
