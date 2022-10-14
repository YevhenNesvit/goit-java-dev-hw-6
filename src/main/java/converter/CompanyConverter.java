package converter;

import model.dao.CompanyDao;
import model.dto.CompanyDto;

import java.util.ArrayList;
import java.util.List;

public class CompanyConverter implements Converter<CompanyDto, CompanyDao> {
    @Override
    public CompanyDto from(CompanyDao entity) {
        CompanyDto companyDto = new CompanyDto();

        companyDto.setCompanyId(entity.getCompanyId());
        companyDto.setName(entity.getName());
        companyDto.setCountry(entity.getCountry());

        return companyDto;
    }

    @Override
    public CompanyDao to(CompanyDto entity) {
        return null;
    }

    @Override
    public List<CompanyDto> fromList(List<CompanyDao> list) {
        List<CompanyDto> dtoList = new ArrayList<>();

        for (CompanyDao dao : list) {
            dtoList.add(from(dao));
        }

        return dtoList;
    }
}
