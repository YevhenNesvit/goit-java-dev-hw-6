package converter;
import model.dao.ProjectDao;
import model.dto.ProjectDto;

import java.util.ArrayList;
import java.util.List;

public class ProjectConverter implements Converter<ProjectDto, ProjectDao> {
    @Override
    public ProjectDto from(ProjectDao entity) {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setProjectId(entity.getProjectId());
        projectDto.setName(entity.getName());
        projectDto.setCustomerId(entity.getCustomerId());
        projectDto.setCompanyId(entity.getCompanyId());
        projectDto.setCost(entity.getCost());
        projectDto.setCreationDate(entity.getCreationDate());

        return projectDto;
    }

    @Override
    public ProjectDao to(ProjectDto entity) {
        return null;
    }

    @Override
    public List<ProjectDto> fromList(List<ProjectDao> list) {
        List<ProjectDto> dtoList = new ArrayList<>();

        for (ProjectDao dao : list) {
            dtoList.add(from(dao));
        }

        return dtoList;
    }
}
