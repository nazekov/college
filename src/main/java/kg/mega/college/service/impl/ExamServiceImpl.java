package kg.mega.college.service.impl;

import kg.mega.college.mapper.ExamMapper;
import kg.mega.college.model.Exam;
import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.ExamDto;
import kg.mega.college.model.dto.ExamDtoUpdate;
import kg.mega.college.model.dto.studentdto.ExamDtoMainInfo;
import kg.mega.college.repository.ExamRepository;
import kg.mega.college.service.ExamService;
import kg.mega.college.service.SubjectService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;
    private final SubjectService subjectService;

    public ExamServiceImpl(ExamRepository examRepository,
                           ExamMapper examMapper,
                           @Lazy SubjectService subjectService) {
        this.examRepository = examRepository;
        this.examMapper = examMapper;
        this.subjectService = subjectService;
    }

    @Override
    public String save(ExamDto examDto) {
        Optional<Subject> optionalSubject
                = subjectService.findById(examDto.getSubjectId());
        if (optionalSubject.isEmpty()) {
            return "Subject not found. You need to create subject before.";
        }

        Exam exam = examMapper.convertExamDtoToExam(examDto, optionalSubject.get());

        if (!exam.isValidDateTime()) {
            return "Exam Date or duration not valid. " +
                    "Please enter correct date and duration for exam";
        }

        exam = examRepository.save(exam);
        return "Exam saved successfully\n" + exam;
    }

    @Override
    public String get(Long examId) {
        Optional<Exam> optionalExam = examRepository.findById(examId);
        if (optionalExam.isEmpty()) {
            return "Exam not found";
        }
        return optionalExam.get().toString();
    }

    @Override
    public String update(ExamDtoUpdate examDto) {
        Optional<Exam> optionalExam
                = examRepository.findById(examDto.getExamId());
        if (optionalExam.isEmpty()) {
            return "Exam not found";
        }

        Optional<Subject> optionalSubject
                = subjectService.findById(examDto.getSubjectId());
        if (optionalSubject.isEmpty()) {
            return "Subject not found. You need to create subject before.";
        }

        Exam exam = examMapper.convertExamDtoUpdateToExam(examDto, optionalSubject.get());

        if (!exam.isValidDateTime()) {
            return "Exam Date or duration not valid. " +
                    "Please enter correct date and duration for exam";
        }

        exam = examRepository.save(exam);
        return "Exam updated successfully\n" + exam;
    }

    @Override
    public List<ExamDtoMainInfo> getExamsDtoMainInfoBySubjectIdList(Long subjectId) {
        List<Exam> examList = examRepository.findAllBySubjectId(subjectId);

        List<ExamDtoMainInfo> examDtoMainInfoList =
                examMapper.convertExamListToExamDtoMainInfoList(examList);
        return examDtoMainInfoList;
    }
}