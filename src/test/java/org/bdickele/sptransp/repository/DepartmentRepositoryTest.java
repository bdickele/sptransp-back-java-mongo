package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.DepartmentDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by Bertrand DICKELE
 */
public class DepartmentRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private DepartmentRepository repository;


    @Test
    public void should_find_all_departments() {
        List<DepartmentDTO> departments = repository.findAll();
        assertThat(departments).hasSize(5);

        assertThat(departments).extracting("code", "name").containsExactly(
                tuple("GOODS_INSPECTION", "Goods inspection"),
                tuple("HR", "Human resources"),
                tuple("JOURNEY_SUPERVISION", "Journey supervision"),
                tuple("LAW_COMPLIANCE", "Law compliance"),
                tuple("SHUTTLE_COMPLIANCE", "Shuttle compliance"));
    }

    @Test
    public void department_by_code_should_work() {
        DepartmentDTO moon = repository.findByCode("LAW_COMPLIANCE");
        assertThat(moon).isNotNull();
        assertThat(moon.getCode()).isEqualTo("LAW_COMPLIANCE");
        assertThat(moon.getName()).isEqualTo("Law compliance");
    }
}
