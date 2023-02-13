package kg.mega.college.mapper;

import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherMapper {

    private final SubjectMapper subjectMapper;

    public TeacherMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    public List<Teacher> convertListTeacherDtoToTeacherList(List<TeacherDto> teacherDtoList) {
        return teacherDtoList.stream()
                .map(this::convertTeacherDtoToTeacher)
                .collect(Collectors.toList());
    }

    public Teacher convertTeacherDtoToTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPatronymic(teacherDto.getPatronymic());
        teacher.setActive(teacherDto.isActive());
        return teacher;
    }
}
