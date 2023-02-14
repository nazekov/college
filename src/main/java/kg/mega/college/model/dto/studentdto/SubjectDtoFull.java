package kg.mega.college.model.dto.studentdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectDtoFull {

    @JsonProperty("name")
    String name;

    @JsonProperty("teacher_name")
    String teacherName;

    @JsonProperty("exams")
    List<ExamDtoMainInfo> examDtoMainInfoList;
}
