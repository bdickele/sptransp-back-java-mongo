package org.bdickele.sptransp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController extends AbstractController {

    /*
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;


    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<EmployeeDTO> employees() {
        return EmployeeDTO.build(repository.findAllByOrderByFullNameAsc());
    }

    @RequestMapping(value="/{uid}", method= RequestMethod.GET,
            produces="application/json")
    public EmployeeDTO employee(@PathVariable String uid) {
        Employee employee = repository.findByUid(uid);
        if (employee==null) {
            throw SpTranspBizError.EMPLOYEE_NOT_FOUND.exception(uid);
        }
        return EmployeeDTO.build(employee);
    }

    @RequestMapping(
            method= RequestMethod.POST,
            consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        Employee employee = service.create(dto.getFullName(), dto.getProfileCode(),
                dto.getDepartmentCode(), dto.getSeniority(), TEMP_USER_UID);
        return EmployeeDTO.build(employee);
    }

    @RequestMapping(
            value="/{uid}",
            method= RequestMethod.PUT,
            consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO update(@PathVariable String uid, @RequestBody EmployeeDTO dto) {
        Employee employee = service.update(uid, dto.getFullName(), dto.getProfileCode(),
                dto.getDepartmentCode(), dto.getSeniority(), TEMP_USER_UID);
        return EmployeeDTO.build(employee);
    }
    */
}
