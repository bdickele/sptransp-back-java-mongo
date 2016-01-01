package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.EmployeeDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by Bertrand DICKELE
 */
public class EmployeeRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private EmployeeRepository repository;


    @Test
    public void findAll_should_work() {
        List<EmployeeDTO> employees = repository.findAll();
        assertThat(employees.size()).isGreaterThanOrEqualTo(5);
        assertThat(employees)
                .extracting("uid", "fullName", "departmentCode", "seniority").contains(
                tuple("kvcquz31", "Kathleen Carpenter", "LAW_COMPLIANCE", 20),
                tuple("rajoqm34", "Jack Henry", "GOODS_INSPECTION", 60));
    }

    @Test
    public void employee_by_uid_should_work() {
        EmployeeDTO moon = repository.findByUid("kvcquz31");
        assertThat(moon).isNotNull();
        assertThat(moon.getFullName()).isEqualTo("Kathleen Carpenter");
        assertThat(moon.getProfileCode()).isEqualTo("AGR_VISA_APPLIER");
        assertThat(moon.getDepartmentCode()).isEqualTo("LAW_COMPLIANCE");
        assertThat(moon.getUserType()).isEqualTo("E");
    }
}
