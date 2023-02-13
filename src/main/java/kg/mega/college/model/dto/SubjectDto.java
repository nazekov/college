package kg.mega.college.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectDto {

    @JsonProperty("name")
    String name;

    @JsonProperty("is_active")
    boolean isActive;

    @JsonProperty("teacher_id")
    Long teacherId;
}
