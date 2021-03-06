package org.bdickele.sptransp.controller;

import org.bdickele.sptransp.domain.UserProfile;
import org.bdickele.sptransp.dto.UserProfileDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/employeeProfiles")
public class EmployeeProfileController extends AbstractController {

    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<UserProfileDTO> employeeProfiles() {
        return UserProfileDTO.build(UserProfile.getEmployeeProfiles());
    }
}
