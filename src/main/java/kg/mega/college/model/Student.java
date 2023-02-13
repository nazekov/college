package kg.mega.college.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "first_name", length = 30)
    String firstName;

    @Column(name = "last_name", length = 30)
    String lastName;

    @Column(name = "patronymic", length = 30)
    String patronymic;

    @Column(name = "is_active")
    boolean isActive;

    @Column(name = "address", length = 50)
    String address;

    @ManyToOne          //@OneToOne?
    Subject subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(patronymic, student.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic);
    }
}
