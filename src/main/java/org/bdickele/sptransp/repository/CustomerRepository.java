package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.CustomerDTO;

import java.util.List;

/**
 * Created by bdickele
 */
public interface CustomerRepository {

    List<CustomerDTO> findAllByOrderByFullNameAsc();

    CustomerDTO findByUid(String uid);
}
