package kg.mega.college.repository;

import kg.mega.college.model.Grant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface GrantRepository extends JpaRepository<Grant, Long> {

    Optional<Grant> findByEndDateAndStudentId(Date date, Long id);
}
