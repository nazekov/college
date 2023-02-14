package kg.mega.college.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "grants")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Grant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "amount")
    Double amount;

    @Column(name = "start_date")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Bishkek")
//    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    Date startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Bishkek")
//    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    Date endDate;

    @ManyToOne
    Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grant grant = (Grant) o;
        return Objects.equals(amount, grant.amount)
                && Objects.equals(student, grant.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, student);
    }
}
