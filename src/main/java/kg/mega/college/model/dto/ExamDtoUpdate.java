package kg.mega.college.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamDtoUpdate {

    @JsonProperty("exam_id")
    Long examId;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Bishkek")
    Date date;

    Long duration;

    @JsonProperty("subject_id")
    Long subjectId;
}
