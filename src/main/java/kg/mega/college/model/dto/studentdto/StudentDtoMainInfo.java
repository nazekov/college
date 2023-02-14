package kg.mega.college.model.dto.studentdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDtoMainInfo {

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("patronymic")
    String patronymic;

    @JsonProperty("grant")
    Double grantAmount;

    SubjectDtoFull subjectDtoFull;
}
