package controller;

import config.ServiceConnection;
import services.CompanyService;
import utils.CheckCompanies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/createCompanyForm")
public class CreateCompanyFormController extends HttpServlet {

    CompanyService companyService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        companyService = new CompanyService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/companies/createCompanyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckCompanies checkCompanies = new CheckCompanies();

        try {
            Integer companyId = Integer.parseInt(req.getParameter("companyId"));
            String name = req.getParameter("companyName");
            String country = req.getParameter("country");
            if (checkCompanies.IsCompanyIdExists(companyId)) {
                req.getRequestDispatcher("/WEB-INF/view/companies/companyIdAlreadyExists.jsp").forward(req, resp);
            } else {
                companyService.createCompany(companyId, name, country);
                req.getRequestDispatcher("/WEB-INF/view/companies/companyCreated.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/companies/invalidCompanyIdFormat.jsp").forward(req, resp);
        }
    }
}
