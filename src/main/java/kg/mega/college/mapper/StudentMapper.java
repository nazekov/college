package kg.mega.college.mapper;

import kg.mega.college.model.Student;
import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.StudentDto;
import kg.mega.college.model.dto.StudentDtoUpdate;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student convertStudentDtoStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPatronymic(studentDto.getPatronymic());
        student.setAddress(studentDto.getAddress());
        student.setActive(studentDto.isActive());
        return student;
    }

    public Student convertStudentDtoStudent(Student student,
                                            StudentDtoUpdate studentDto,
                                            Subject subject) {
        student.setActive(studentDto.isActive());
        student.setAddress(studentDto.getAddress());
        student.setSubject(subject);
        return student;
    }
}
