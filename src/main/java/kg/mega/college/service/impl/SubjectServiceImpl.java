package kg.mega.college.service.impl;

import kg.mega.college.mapper.SubjectMapper;
import kg.mega.college.model.Subject;
import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.SubjectDto;
import kg.mega.college.model.dto.studentdto.SubjectDtoFull;
import kg.mega.college.repository.SubjectRepository;
import kg.mega.college.service.ExamService;
import kg.mega.college.service.SubjectService;
import kg.mega.college.service.TeacherService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
    private final TeacherService teacherService;
    private final ExamService examService;

    public SubjectServiceImpl(SubjectRepository subjectRepository,
                              SubjectMapper subjectMapper,
                              TeacherService teacherService,
                              @Lazy ExamService examService) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
        this.teacherService = teacherService;
        this.examService = examService;
    }

    @Override
    public String save(SubjectDto subjectDto) {
        Optional<Teacher> optionalTeacher
                = teacherService.findTeacherById(subjectDto.getTeacherId());
        if (optionalTeacher.isEmpty()) {
            return "Teacher not found. You need to create teacher before";
        }
        Optional<Subject> byNameAndTeacherId
                = subjectRepository.findByNameAndTeacherId(subjectDto.getName(),
                                                    subjectDto.getTeacherId());
        if (byNameAndTeacherId.isPresent()) {

//
            return "This line is exist";
        }
        Subject subject
                = subjectMapper.convertSubjectDtoToSubject(subjectDto, optionalTeacher.get());

        subject = subjectRepository.save(subject);
        return "Subject saved successfully\n" + subject;

    }

//    @Override
//    public List<Subject> saveAll(List<SubjectDto> subjectDtoList) {
//        List<Subject> allSubjectsFromDB = subjectRepository.findAll();
//        List<Subject> subjects
//                = subjectMapper.convertListSubjectDtoToListSubject(subjectDtoList);
//        subjects.removeAll(allSubjectsFromDB);
//        return subjectRepository.saveAll(subjects);
//    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public String findByName(String subjectName) {
        Optional<Subject> optionalSubject
                = subjectRepository.findByNameIgnoreCase(subjectName);
        String result = "Subject not found";
        if (optionalSubject.isPresent()) {
            result = optionalSubject.get().toString();
        }
        return result;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public String update(SubjectDto subjectDto) {
        Optional<Subject> optionalSubject
                = subjectRepository.findByNameIgnoreCase(subjectDto.getName());
        Optional<Teacher> optionalTeacher
                = teacherService.findTeacherById(subjectDto.getTeacherId());
        if (optionalSubject.isEmpty()) {
            return "Subject not found";
        }
        if (optionalTeacher.isEmpty()) {
            return "Teacher not found. You need to create teacher before";
        }

        Subject subject = optionalSubject.get();
        subject.setActive(subjectDto.isActive());
        subject.setTeacher(optionalTeacher.get());
        subject = subjectRepository.save(subject);
        return "Subject updated successfully\n" + subject;
    }

    @Override
    public SubjectDtoFull getSubjectDtoFullBySubjectId(Long subjectId) {
        Optional<Subject> optionalSubject = findById(subjectId);
        if (optionalSubject.isEmpty()) {
            return null;
        }
        Subject subject = optionalSubject.get();
        Long teacherId = subject.getTeacher().getId();

        SubjectDtoFull subjectDto =
                subjectMapper.convertDifferentDtosToSubjectDtoFull(
                        subject.getName(),
                        teacherService.teacherName(teacherId),
                        examService.getExamsDtoMainInfoBySubjectIdList(subject.getId())
                );
        return subjectDto;
    }


    //    @Override
//    public String removeByName(String subjectName) {
//        String rsl = "Subject not found";
//        Optional<Subject> subjectFinded = subjectRepository.findByNameIgnoreCase(subjectName);
//        if (subjectFinded.isPresent()) {
//            subjectRepository.delete(subjectFinded.get());
//            rsl = "Subject deleted successfully";
//        }
//        return rsl;
//    }
}
