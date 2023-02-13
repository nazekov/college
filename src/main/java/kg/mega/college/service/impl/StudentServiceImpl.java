package kg.mega.college.service.impl;

import kg.mega.college.mapper.StudentMapper;
import kg.mega.college.model.Student;
import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.StudentDto;
import kg.mega.college.model.dto.StudentDtoUpdate;
import kg.mega.college.repository.StudentRepository;
import kg.mega.college.service.StudentService;
import kg.mega.college.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final SubjectService subjectService;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper,
                              SubjectService subjectService) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.subjectService = subjectService;
    }

    @Override
    public String save(StudentDto studentDto) {
        Optional<Subject> optionalSubject
                = subjectService.findById(studentDto.getSubjectId());
        if (optionalSubject.isEmpty()) {
            return "Subject not found";
        }

        Student student = studentMapper.convertStudentDtoStudent(studentDto);
        student.setSubject(optionalSubject.get());

        if (isExist(student)) {
            return "This student already exists in Database";
        }

        student = studentRepository.save(student);
        return "Student saved successfully\n" + student;
    }

    @Override
    public String get(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) {
            return "Student not found";
        }
        return optionalStudent.get().toString();
    }

    @Override
    public String update(StudentDtoUpdate studentDto) {
        Optional<Student> optionalStudent
                = studentRepository.findById(studentDto.getStudentId());
        if (optionalStudent.isEmpty()) {
            return "Student not found";
        }

        Optional<Subject> optionalSubject
                = subjectService.findById(studentDto.getSubjectId());

        if (optionalSubject.isEmpty()) {
            return "Subject not found";
        }

        Student student = optionalStudent.get();
        student = studentMapper.convertStudentDtoStudent(student,
                                                        studentDto,
                                                        optionalSubject.get());
        student = studentRepository.save(student);
        return "Student updated successfully\n" + student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    private boolean isExist(Student student) {
        return studentRepository
                .findAll()
                .stream()
                .anyMatch(studentItem -> studentItem.equals(student));
    }
}
