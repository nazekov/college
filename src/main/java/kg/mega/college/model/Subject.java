package kg.mega.college.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subjects")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("subject_Id")
    Long id;

    @Column(name = "name", length = 30)
    @JsonProperty("subject_name")
    String name;

    @Column(name = "is_active")
    @JsonProperty("is_active")
    boolean isActive;

    @ManyToOne
    Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name)
                && Objects.equals(teacher, subject.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher);
    }
}
