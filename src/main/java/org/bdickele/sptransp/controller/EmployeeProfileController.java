package org.bdickele.sptransp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/employeeProfiles")
public class EmployeeProfileController extends AbstractController {

    /*
    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<UserProfileDTO> employeeProfiles() {
        return UserProfileDTO.build(UserProfile.getEmployeeProfiles());
    }
    */
}
