package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.DepartmentDTO;

import java.util.List;

/**
 * Created by bdickele
 */
public interface DepartmentRepository {

    List<DepartmentDTO> findAllByOrderByNameAsc();

    DepartmentDTO findByCode(String code);
}
