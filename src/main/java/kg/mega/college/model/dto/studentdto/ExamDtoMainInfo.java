package kg.mega.college.model.dto.studentdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamDtoMainInfo {

    @JsonProperty("date")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Bishkek")
    Date date;

    @JsonProperty("duration")
    Long duration;
}
