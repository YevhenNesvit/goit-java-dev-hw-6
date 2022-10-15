package controller.customers;

import config.ServiceConnection;
import model.dto.CustomerDto;
import services.CustomerService;
import utils.CheckCustomers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/getCustomerByIdForm")
public class GetCustomerByIdFormController extends HttpServlet {
    CustomerService customerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        customerService = new CustomerService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/customers/getCustomerByIdForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CheckCustomers checkCustomers = new CheckCustomers();

        try {
            List<CustomerDto> customers = new ArrayList<>();
            Integer customerId = Integer.parseInt(req.getParameter("customerId"));
            if (checkCustomers.IsCustomerIdExists(customerId)) {
                customers.add(customerService.customerById(customerId));
                req.setAttribute("customers", customers);
                req.getRequestDispatcher("/WEB-INF/view/customers/customerById.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/view/customers/customerIdNotExists.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            req.getRequestDispatcher("/WEB-INF/view/customers/invalidCustomerIdFormat.jsp").forward(req, resp);
        }
    }
}
