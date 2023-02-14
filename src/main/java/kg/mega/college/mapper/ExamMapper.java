package kg.mega.college.mapper;

import kg.mega.college.model.Exam;
import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.ExamDto;
import kg.mega.college.model.dto.ExamDtoUpdate;
import kg.mega.college.model.dto.studentdto.ExamDtoMainInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamMapper {

    public Exam convertExamDtoToExam(ExamDto examDto, Subject subject) {
        Exam exam = new Exam();
        exam.setSubject(subject);
        exam.setDate(examDto.getDate());
        exam.setDuration(examDto.getDuration());
        return exam;
    }

    public Exam convertExamDtoUpdateToExam(ExamDtoUpdate examDto, Subject subject) {
        Exam exam = new Exam();
        exam.setSubject(subject);
        exam.setDate(examDto.getDate());
        exam.setDuration(examDto.getDuration());
        return exam;
    }

    private ExamDtoMainInfo convertToExamDtoMainInfo(Exam exam) {
        ExamDtoMainInfo examDto = new ExamDtoMainInfo();
        examDto.setDate(exam.getDate());
        examDto.setDuration(exam.getDuration());
        return examDto;
    }

    public List<ExamDtoMainInfo> convertExamListToExamDtoMainInfoList(List<Exam> examList) {
        return examList.stream()
                .map(exam -> convertToExamDtoMainInfo(exam))
                .collect(Collectors.toList());
    }
}
