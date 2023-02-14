package kg.mega.college.mapper;

import kg.mega.college.model.Subject;
import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.SubjectDto;
import kg.mega.college.model.dto.studentdto.ExamDtoMainInfo;
import kg.mega.college.model.dto.studentdto.SubjectDtoFull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public SubjectDtoFull convertDifferentDtosToSubjectDtoFull(
                                            String subjectName,
                                            String teacherName,
                                           List<ExamDtoMainInfo> examsDtoList) {
        SubjectDtoFull subjectDtoFull = new SubjectDtoFull();
        subjectDtoFull.setName(subjectName);
        subjectDtoFull.setTeacherName(teacherName);
        subjectDtoFull.setExamDtoMainInfoList(examsDtoList);
        return subjectDtoFull;
    }


//    public List<Subject> convertListSubjectDtoToListSubject(List<SubjectDto> subjectDtoList) {
//        return subjectDtoList.stream()
//                .map(this::convertSubjectDtoToSubject)
//                .collect(Collectors.toList());
//    }
}