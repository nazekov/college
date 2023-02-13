package kg.mega.college.service;

import kg.mega.college.model.dto.ExamDto;
import kg.mega.college.model.dto.ExamDtoUpdate;

public interface ExamService {

    String save(ExamDto examDto);

    String get(Long examId);

    String update(ExamDtoUpdate examDto);

}
