package kg.mega.college.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "grades")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    Integer score;

    @ManyToOne
    Student student;

    @ManyToOne
    Exam exam;
}
