package converter;
import model.dao.ProjectDao;
import model.dto.ProjectDto;

import java.util.ArrayList;
import java.util.List;

public class ProjectConverter implements Converter<ProjectDto, ProjectDao> {
    @Override
    public ProjectDto from(ProjectDao entity) {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setCreationDate(entity.getCreationDate());
        projectDto.setName(entity.getName());

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
