package org.bdickele.sptransp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/destinations")
public class DestinationController extends AbstractController {

    /*
    @Autowired
    private DestinationRepository repository;


    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<DestinationDTO> destinations() {
        return DestinationDTO.build(repository.findAllByOrderByNameAsc());
    }

    @RequestMapping(value="/{code}", method= RequestMethod.GET,
            produces="application/json")
    public DestinationDTO goods(@PathVariable String code) {
        Destination destination = repository.findByCode(code);

        if (destination==null) {
            throw SpTranspBizError.DESTINATION_NOT_FOUND.exception(code);
        }

        return DestinationDTO.build(destination);
    }
    */
}