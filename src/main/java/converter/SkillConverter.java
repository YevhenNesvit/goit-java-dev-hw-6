package converter;

import model.dao.SkillDao;
import model.dto.SkillDto;

import java.util.ArrayList;
import java.util.List;

public class SkillConverter implements Converter<SkillDto, SkillDao> {

    @Override
    public SkillDto from(SkillDao entity) {
        SkillDto skillDto = new SkillDto();

        skillDto.setSkillId(entity.getSkillId());
        skillDto.setName(entity.getName());
        skillDto.setSkillLevel(entity.getSkillLevel());

        return skillDto;
    }

    @Override
    public SkillDao to(SkillDto entity) {
        return null;
    }

    @Override
    public List<SkillDto> fromList(List<SkillDao> list) {
        List<SkillDto> dtoList = new ArrayList<>();

        for (SkillDao dao : list) {
            dtoList.add(from(dao));
        }

        return dtoList;
    }
}
