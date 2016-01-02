package org.bdickele.sptransp.service;

import org.bdickele.sptransp.dto.CustomerDTO;
import org.bdickele.sptransp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Bertrand DICKELE
 */
@Service
public class CustomerService extends UserService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public CustomerDTO create(String fullName, String creationUser) {
        String uid = generateUid(fullName);
        CustomerDTO customer = CustomerDTO.build(getNextId(), uid, fullName, creationUser, passwordEncoder);
        getCollection().insert(customer);
        return customer;
    }

    public CustomerDTO update(String uid, String fullName, String updateUser) {
        // UID cannot be updated : we use it to retrieve current customer
        CustomerDTO customer = repository.findByUid(uid);
        customer.update(fullName, updateUser);

        getCollection().update("{id: #}", customer.getId()).with(customer);

        return customer;
    }
}
