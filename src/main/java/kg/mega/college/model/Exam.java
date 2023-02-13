package kg.mega.college.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "exams")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "date")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Bishkek")
    Date date;

    @Column(name = "duration")
    Long duration;

    @ManyToOne
//    @JoinColumn(name = "id")
    Subject subject;

    public boolean isValidDateTime() {
        boolean result = false;
        Date currentDate = new Date();
        System.out.println("1.CurrentDate: " + currentDate);
        if (currentDate.before(date)) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            System.out.println("2.Exam date: " + cal.getTime());
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println("3.dayOfWeek " + dayOfWeek);
            if (dayOfWeek != 1 && dayOfWeek != 7) {
                int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
                System.out.println("4.hourOfDay: " + hourOfDay);
                if (hourOfDay >= 9 && hourOfDay < 18) {
                    cal.add(Calendar.MINUTE, Math.toIntExact(duration));
                    hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
                    System.out.println("5.hourOfDay: " + hourOfDay);
                    if (hourOfDay > 9 && hourOfDay <= 18) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
