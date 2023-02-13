package kg.mega.college.mapper;

import kg.mega.college.model.Grant;
import kg.mega.college.model.Student;
import kg.mega.college.model.dto.GrantDto;
import kg.mega.college.utils.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class GrantMapper {

    public Grant convertGrantDtoToGrant(GrantDto grantDto, Student student) {
        Grant grant = new Grant();
        grant.setAmount(grantDto.getAmount());
        grant.setStartDate(grantDto.getStartDate());
        grant.setEndDate(DateUtil.getInstance().getEndDate());
        grant.setStudent(student);
        return grant;
    }
}
