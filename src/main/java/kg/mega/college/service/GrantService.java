package kg.mega.college.service;

import kg.mega.college.model.dto.GrantDto;

public interface GrantService {

    String save(GrantDto grantDto);

    String get(Long grantsId);

    String update(GrantDto grantDto);

    Double getGrantAmountByStudentId(Long studentId);
}
