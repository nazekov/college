package kg.mega.college.service;

import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.TeacherDto;
import kg.mega.college.model.dto.TeacherDtoUpdate;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    String save(TeacherDto teacherDto);

    Optional<Teacher> findTeacherById(Long id);

    String get(Long teacher_id);

    List<Teacher> findAll();

    List<Teacher> saveAll(List<TeacherDto> teacherDtoList);

    String update(TeacherDtoUpdate teacherDto);
}
