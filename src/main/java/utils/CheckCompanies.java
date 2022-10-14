package utils;

import config.ServiceConnection;
import services.CompanyService;

import java.sql.SQLException;

public class CheckCompanies {
    ServiceConnection connection = new ServiceConnection();
    CompanyService companyService = new CompanyService(connection.connect());

    public boolean IsCompanyIdExists(Integer id) throws SQLException {
        for (int i = 0; i < companyService.companiesList().size(); i++) {
            if(companyService.companiesList().get(i).getCompanyId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
