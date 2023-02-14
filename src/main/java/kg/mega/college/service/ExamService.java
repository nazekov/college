package kg.mega.college.service;

import kg.mega.college.model.dto.ExamDto;
import kg.mega.college.model.dto.ExamDtoUpdate;
import kg.mega.college.model.dto.studentdto.ExamDtoMainInfo;

import java.util.List;

public interface ExamService {

    String save(ExamDto examDto);

    String get(Long examId);

    String update(ExamDtoUpdate examDto);

    List<ExamDtoMainInfo> getExamsDtoMainInfoBySubjectIdList(Long subjectId);

}
