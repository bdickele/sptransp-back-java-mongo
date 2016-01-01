package org.bdickele.sptransp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractController {

    /*
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerService service;


    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<CustomerDTO> customers() {
        return CustomerDTO.build(repository.findAllByOrderByFullNameAsc());
    }

    @RequestMapping(value="/{uid}", method= RequestMethod.GET,
            produces="application/json")
    public CustomerDTO customer(@PathVariable String uid) {
        Customer customer = repository.findByUid(uid);
        if (customer==null) {
            throw SpTranspBizError.CUSTOMER_NOT_FOUND.exception(uid);
        }
        return CustomerDTO.build(customer);
    }

    @RequestMapping(
            method= RequestMethod.POST,
            consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO create(@RequestBody CustomerDTO dto) {
        Customer customer = service.create(dto.getFullName(), TEMP_USER_UID);
        return CustomerDTO.build(customer);
    }

    @RequestMapping(
            value="/{uid}",
            method= RequestMethod.PUT,
            consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO update(@PathVariable String uid, @RequestBody CustomerDTO dto) {
        Customer customer = service.update(uid, dto.getFullName(), TEMP_USER_UID);
        return CustomerDTO.build(customer);
    }
    */
}
