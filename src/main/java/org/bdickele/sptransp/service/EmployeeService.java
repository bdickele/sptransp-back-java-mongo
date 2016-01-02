package org.bdickele.sptransp.service;

import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.domain.UserProfile;
import org.bdickele.sptransp.dto.DepartmentDTO;
import org.bdickele.sptransp.dto.EmployeeDTO;
import org.bdickele.sptransp.repository.DepartmentRepository;
import org.bdickele.sptransp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Bertrand DICKELE
 */
@Service
public class EmployeeService extends UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public EmployeeDTO create(String fullName, String profileCode, String departmentCode,
                              Seniority seniority, String creationUser) {
        String uid = generateUid(fullName);
        DepartmentDTO department = departmentRepository.findByCode(departmentCode);

        EmployeeDTO employee = EmployeeDTO.build(getNextId(), uid, fullName, UserProfile.getByCode(profileCode),
                department, seniority, creationUser, passwordEncoder);

        getCollection().insert(employee);

        return employee;
    }

    public EmployeeDTO update(String uid, String fullName, String profileCode, String departmentCode,
                              Seniority seniority, String updateUser) {
        // UID cannot be updated : we use it to retrieve current employee
        EmployeeDTO employee = employeeRepository.findByUid(uid);
        DepartmentDTO department = departmentRepository.findByCode(departmentCode);

        employee.update(fullName, UserProfile.getByCode(profileCode), department, seniority, updateUser);

        getCollection().update("{id: #}", employee.getId()).with(employee);

        return employee;
    }
}
