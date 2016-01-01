package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.EmployeeDTO;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
public interface EmployeeRepository {

    List<EmployeeDTO> findAllByOrderByFullNameAsc();

    EmployeeDTO findByUid(String uid);
}
