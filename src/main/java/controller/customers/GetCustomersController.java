package controller.customers;

import config.ServiceConnection;
import model.dto.CustomerDto;
import services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/getCustomers")
public class GetCustomersController extends HttpServlet {
    CustomerService customerService;

    @Override
    public void init() {
        ServiceConnection connection = new ServiceConnection();
        customerService = new CustomerService(connection.connect());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<CustomerDto> customers = customerService.customerList();
            req.setAttribute("customers", customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/view/customers/getCustomers.jsp").forward(req, resp);
    }
}
