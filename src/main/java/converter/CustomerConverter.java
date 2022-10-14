package converter;

import model.dao.CustomerDao;
import model.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerConverter implements Converter<CustomerDto, CustomerDao>{
    @Override
    public CustomerDto from(CustomerDao entity) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId(entity.getCustomerId());
        customerDto.setName(entity.getName());
        customerDto.setCountry(entity.getCountry());

        return customerDto;
    }

    @Override
    public CustomerDao to(CustomerDto entity) {
        return null;
    }

    @Override
    public List<CustomerDto> fromList(List<CustomerDao> list) {
        List<CustomerDto> dtoList = new ArrayList<>();

        for (CustomerDao dao : list) {
            dtoList.add(from(dao));
        }

        return dtoList;
    }
}
