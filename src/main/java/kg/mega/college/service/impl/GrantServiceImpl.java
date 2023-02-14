package kg.mega.college.service.impl;

import kg.mega.college.mapper.GrantMapper;
import kg.mega.college.model.Grant;
import kg.mega.college.model.Student;
import kg.mega.college.model.dto.GrantDto;
import kg.mega.college.repository.GrantRepository;
import kg.mega.college.service.GrantService;
import kg.mega.college.service.StudentService;
import kg.mega.college.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GrantServiceImpl implements GrantService {

    private final GrantRepository grantRepository;
    private final GrantMapper grantMapper;
    private final StudentService studentService;

    public GrantServiceImpl(GrantRepository grantRepository,
                            GrantMapper grantMapper,
                            StudentService studentService) {
        this.grantRepository = grantRepository;
        this.grantMapper = grantMapper;
        this.studentService = studentService;
    }

    @Override
    public String save(GrantDto grantDto) {
        Optional<Student> optionalStudent
                = studentService.findById(grantDto.getStudentId());
        if (optionalStudent.isEmpty()) {
            return "Student not found";
        }
        Grant grant = grantMapper.convertGrantDtoToGrant(grantDto,
                                                        optionalStudent.get());
        if (grantExist(grant)) {
            return "This grant exists in Database";
        }

        grant = grantRepository.save(grant);
        return "grant saved successfully\n" + grant;
    }

    private boolean grantExist(Grant grant) {
        List<Grant> all = grantRepository.findAll();
        return all
                .stream()
                .anyMatch(grantItem -> grantItem.equals(grant));
    }

    @Override
    public String get(Long grantsId) {
        Optional<Grant> optionalGrant = grantRepository.findById(grantsId);
        if (optionalGrant.isEmpty()) {
            return "Grant not found";
        }
        return optionalGrant.get().toString();
    }

    @Override
    public String update(GrantDto grantDto) {
        Optional<Student> optionalStudent
                = studentService.findById(grantDto.getStudentId());
        if (optionalStudent.isEmpty()) {
            return "Student not found";
        }
        Student student = optionalStudent.get();

        Optional<Grant> optionalGrantOld
                = grantRepository.findByEndDateAndStudentId(DateUtil.getInstance().getEndDate(),
                student.getId());
        if (optionalGrantOld.isEmpty()) {
            return "Grant for update not found";
        }

        Grant grantOld = optionalGrantOld.get();
        grantOld.setEndDate(new Date());
        grantRepository.save(grantOld);

        Grant newGrant = grantMapper.convertGrantDtoToGrant(grantDto, student);
        newGrant = grantRepository.save(newGrant);

        return "grant for student_id: "
                + newGrant.getStudent().getId() + " updated\n" +
                newGrant;
    }

    @Override
    public Double getGrantAmountByStudentId(Long studentId) {
        Optional<Grant> optionalGrant =
                grantRepository
                        .findByEndDateAndStudentId(
                                DateUtil.getInstance().getEndDate(),
                                studentId
                        );
        return optionalGrant.map(Grant::getAmount).orElse(null);
    }
}
