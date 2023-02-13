package kg.mega.college.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDtoUpdate {

    @JsonProperty("student_id")
    Long studentId;

    @JsonProperty("address")
    String address;

    @JsonProperty("subject_id")
    Long subjectId;

    @JsonProperty("is_active")
    boolean isActive;
}
