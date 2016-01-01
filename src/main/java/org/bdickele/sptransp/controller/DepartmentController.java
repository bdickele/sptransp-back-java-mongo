package org.bdickele.sptransp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController extends AbstractController {

    /*
    @Autowired
    private DepartmentRepository repository;

    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<DepartmentDTO> departments() {
        return DepartmentDTO.build(repository.findAllByOrderByNameAsc());
    }
    */
}
