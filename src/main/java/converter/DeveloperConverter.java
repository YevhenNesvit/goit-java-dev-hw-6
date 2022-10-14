package converter;

import model.dao.DeveloperDao;
import model.dto.DeveloperDto;

import java.util.ArrayList;
import java.util.List;

public class DeveloperConverter implements Converter<DeveloperDto, DeveloperDao> {

    @Override
    public DeveloperDto from(DeveloperDao entity) {
        DeveloperDto developerDto = new DeveloperDto();

        developerDto.setDeveloperId(entity.getDeveloperId());
        developerDto.setFirstName(entity.getFirstName());
        developerDto.setLastName(entity.getLastName());
        developerDto.setGender(entity.getGender());
        developerDto.setAge(entity.getAge());
        developerDto.setCompanyId(entity.getCompanyId());
        developerDto.setSalary(entity.getSalary());

        return developerDto;
    }

    @Override
    public DeveloperDao to(DeveloperDto entity) {
        return null;
    }

    @Override
    public List<DeveloperDto> fromList(List<DeveloperDao> list) {
        List<DeveloperDto> dtoList = new ArrayList<>();

        for (DeveloperDao dao : list) {
            dtoList.add(from(dao));
        }

        return dtoList;
    }
}
