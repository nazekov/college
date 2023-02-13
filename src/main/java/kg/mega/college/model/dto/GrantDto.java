package kg.mega.college.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GrantDto {

    @JsonProperty("amount")
    Double amount;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Bishkek")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    Date startDate;

    @JsonProperty("student_id")
    Long studentId;
}
