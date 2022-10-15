package controller.customers;

import config.ServiceConnection;
import services.CustomerService;
import utils.CheckCustomers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateCustomerForm")
public class UpdateCustomerFormController extends HttpServlet {
    CustomerService customerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        customerService = new CustomerService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/customers/updateCustomerForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckCustomers checkCustomers = new CheckCustomers();

        try {
            Integer customerId = Integer.parseInt(req.getParameter("customerId"));
            String name = req.getParameter("customerName");
            String country = req.getParameter("country");
            if (checkCustomers.IsCustomerIdExists(customerId)) {
                customerService.updateCustomer(name, country, customerId);
                req.getRequestDispatcher("/WEB-INF/view/customers/customerUpdated.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/customers/customerIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/customers/invalidCustomerIdFormat.jsp").forward(req, resp);
        }
    }
}
