package kg.mega.college.service;

import kg.mega.college.model.Subject;
import kg.mega.college.model.dto.SubjectDto;
import kg.mega.college.model.dto.studentdto.SubjectDtoFull;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    String save(SubjectDto subjectDto);

//    List<Subject> saveAll(List<SubjectDto> subjectDtoList);

    List<Subject> findAll();

    String findByName(String subjectName);

//    String removeByName(String subjectName);
    Optional<Subject> findById(Long id);

    String update(SubjectDto subjectDto);

    SubjectDtoFull getSubjectDtoFullBySubjectId(Long subjectId);
}
