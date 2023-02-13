package kg.mega.college.mapper;

import kg.mega.college.model.Subject;
import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.SubjectDto;
import org.springframework.stereotype.Service;

@Service
public class SubjectMapper {

//    private static SubjectMapper INSTANCE = null;
//
//    public static SubjectMapper getInstance() {
//        return INSTANCE == null ? new SubjectMapper() : INSTANCE;
//    }

    public Subject convertSubjectDtoToSubject(SubjectDto subjectDto, Teacher teacher) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subject.setActive(subjectDto.isActive());
        subject.setTeacher(teacher);
        return subject;
    }

//    public List<Subject> convertListSubjectDtoToListSubject(List<SubjectDto> subjectDtoList) {
//        return subjectDtoList.stream()
//                .map(this::convertSubjectDtoToSubject)
//                .collect(Collectors.toList());
//    }
}