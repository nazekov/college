package kg.mega.college.controller;

import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.TeacherDto;
import kg.mega.college.model.dto.TeacherDtoUpdate;
import kg.mega.college.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/save")
    public String save(@RequestBody TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

    @PostMapping("/save-list")
    public List<Teacher> save(@RequestBody List<TeacherDto> teacherDtoList) {
        return teacherService.saveAll(teacherDtoList);
    }

    @GetMapping("/get/{teacher_id}")
    public String getTeacher(@PathVariable Long teacher_id) {
        return teacherService.get(teacher_id);
    }

    @GetMapping("/get-all")
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    @PutMapping("/update")
    public String updateTeacher(@RequestBody TeacherDtoUpdate teacherDto) {
        return teacherService.update(teacherDto);
    }
}
