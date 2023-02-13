package kg.mega.college.mapper;

import kg.mega.college.model.Exam;
import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.ExamDto;
import kg.mega.college.model.dto.ExamDtoUpdate;
import org.springframework.stereotype.Service;

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
}
