package kg.mega.college.service.impl;

import kg.mega.college.mapper.TeacherMapper;
import kg.mega.college.model.Teacher;
import kg.mega.college.model.dto.TeacherDto;
import kg.mega.college.model.dto.TeacherDtoUpdate;
import kg.mega.college.repository.TeacherRepository;
import kg.mega.college.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final String[] answer;

    public TeacherServiceImpl(TeacherRepository teacherRepository,
                              TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        answer = new String[] {"Teacher already exist in Database",
                                "Teacher Saved Successfully\n",
                                "Teacher not found",
                                "Teacher updated successfully\n"};
    }

    @Override
    public ResponseEntity<?> save(TeacherDto teacherDto) {
//        String result = answer[0];
        Teacher teacher = teacherMapper.convertTeacherDtoToTeacher(teacherDto);
        Optional<Teacher> optionalTeacher = findTeacher(teacher);
        if (optionalTeacher.isPresent()) {
            return ResponseEntity.status(404).body("Teacher already exist in Database");
        }
        teacher = teacherRepository.save(teacher);
//        result = answer[1] + teacher;
        return ResponseEntity.status(200).body(teacher);
    }

    @Override
    public String get(Long teacher_id) {
        Optional<Teacher> optionalTeacher = findTeacherById(teacher_id);
        String result = answer[2];
        if (optionalTeacher.isPresent()) {
            result = optionalTeacher.get().toString();
        }
        return result;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> saveAll(List<TeacherDto> teacherDtoList) {
        List<Teacher> allTeachersFromDb = teacherRepository.findAll();
        List<Teacher> teachers
                = teacherMapper.convertListTeacherDtoToTeacherList(teacherDtoList);
        teachers.removeAll(allTeachersFromDb);
        return teacherRepository.saveAll(teachers);
    }

    @Override
    public String update(TeacherDtoUpdate teacherDto) {
        Optional<Teacher> optionalTeacher
                = findTeacherById(teacherDto.getTeacherId());
        String result = answer[2];
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setFirstName(teacherDto.getFirstName());
            teacher.setLastName(teacherDto.getLastName());
            teacher.setPatronymic(teacherDto.getPatronymic());
            teacher.setActive(teacherDto.isActive());
            teacher = teacherRepository.save(teacher);
            result = answer[3] + teacher;
        }
        return result;
    }

    public Optional<Teacher> findTeacher(Teacher teacher) {
        return teacherRepository.findAll()
                        .stream()
                        .filter(teacherItem -> teacherItem.equals(teacher))
                        .findFirst();
    }

    public Optional<Teacher> findTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public String teacherName(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .map(teacher -> teacher.getFirstName() + " "
                               + teacher.getFirstName() + " "
                               + teacher.getLastName()
                )
                .orElse(null);

//        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
//        if (optionalTeacher.isEmpty()) {
//            return null;
//        }
//        Teacher teacher = optionalTeacher.get();
//        return teacher.getFirstName() + " "
//                + teacher.getLastName() + " "
//                + teacher.getPatronymic();
    }
}