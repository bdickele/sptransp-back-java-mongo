package org.bdickele.sptransp.controller;

import org.bdickele.sptransp.dto.EmployeeDTO;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.bdickele.sptransp.repository.EmployeeRepository;
import org.bdickele.sptransp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController extends AbstractController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;


    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<EmployeeDTO> employees() {
        return repository.findAll();
    }

    @RequestMapping(value="/{uid}", method= RequestMethod.GET,
            produces="application/json")
    public EmployeeDTO employee(@PathVariable String uid) {
        EmployeeDTO employee = repository.findByUid(uid);
        if (employee==null) {
            throw SpTranspBizError.EMPLOYEE_NOT_FOUND.exception(uid);
        }
        return employee;
    }

    @RequestMapping(
            method= RequestMethod.POST,
            consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        return service.create(dto.getFullName(), dto.getProfileCode(),
                dto.getDepartmentCode(), dto.getSeniority(), TEMP_USER_UID);
    }

    @RequestMapping(
            value="/{uid}",
            method= RequestMethod.PUT,
            consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO update(@PathVariable String uid, @RequestBody EmployeeDTO dto) {
        return service.update(uid, dto.getFullName(), dto.getProfileCode(),
                dto.getDepartmentCode(), dto.getSeniority(), TEMP_USER_UID);
    }
}
