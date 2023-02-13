package kg.mega.college.controller;

import kg.mega.college.model.dto.StudentDto;
import kg.mega.college.model.dto.StudentDtoUpdate;
import kg.mega.college.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public String save(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @GetMapping("/get/{studentId}")
    public String get(@PathVariable Long studentId) {
        return studentService.get(studentId);
    }

    @PutMapping("/update")
    public String update(@RequestBody StudentDtoUpdate studentDto) {
        return studentService.update(studentDto);
    }
}