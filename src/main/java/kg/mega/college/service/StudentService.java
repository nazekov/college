package kg.mega.college.service;

import kg.mega.college.model.Student;
import kg.mega.college.model.dto.StudentDto;
import kg.mega.college.model.dto.StudentDtoUpdate;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface StudentService {

    ResponseEntity<?> save(StudentDto studentDto);

    ResponseEntity<?> get(Long studentId);

    ResponseEntity<?> update(StudentDtoUpdate studentDto);

    Optional<Student> findById(Long id);

}
