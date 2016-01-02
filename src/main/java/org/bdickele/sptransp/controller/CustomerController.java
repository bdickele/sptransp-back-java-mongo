package org.bdickele.sptransp.controller;

import org.bdickele.sptransp.dto.CustomerDTO;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.bdickele.sptransp.repository.CustomerRepository;
import org.bdickele.sptransp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerService service;


    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public List<CustomerDTO> customers() {
        return repository.findAll();
    }

    @RequestMapping(value="/{uid}", method= RequestMethod.GET,
            produces="application/json")
    public CustomerDTO customer(@PathVariable String uid) {
        CustomerDTO customer = repository.findByUid(uid);
        if (customer==null) {
            throw SpTranspBizError.CUSTOMER_NOT_FOUND.exception(uid);
        }
        return customer;
    }

    @RequestMapping(
            method= RequestMethod.POST,
            consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO create(@RequestBody CustomerDTO dto) {
        return service.create(dto.getFullName(), TEMP_USER_UID);
    }

    @RequestMapping(
            value="/{uid}",
            method= RequestMethod.PUT,
            consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO update(@PathVariable String uid, @RequestBody CustomerDTO dto) {
        return service.update(uid, dto.getFullName(), TEMP_USER_UID);
    }
}
