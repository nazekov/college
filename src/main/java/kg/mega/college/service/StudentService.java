package kg.mega.college.service;

import kg.mega.college.model.Student;
import kg.mega.college.model.dto.StudentDto;
import kg.mega.college.model.dto.StudentDtoUpdate;

import java.util.Optional;

public interface StudentService {

    String save(StudentDto studentDto);

    String get(Long studentId);

    String update(StudentDtoUpdate studentDto);

    Optional<Student> findById(Long id);

}
