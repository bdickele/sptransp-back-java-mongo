package org.bdickele.sptransp.repository;

import org.assertj.core.api.StrictAssertions;
import org.bdickele.sptransp.dto.CustomerDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by Bertrand DICKELE
 */
public class CustomerRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private CustomerRepository repository;


    @Test
    public void findAll_should_work() {
        List<CustomerDTO> customers = repository.findAll();
        assertThat(customers).extracting("uid", "fullName").contains(
                tuple("timulf70", "Jabberstorm"),
                tuple("bxcegf67", "Quamba"));
    }

    @Test
    public void find_by_uid_should_work() {
        CustomerDTO customer = repository.findByUid("foobar");
        StrictAssertions.assertThat(customer).isNull();

        customer = repository.findByUid("timulf70");
        assertThat(customer).isNotNull();
        assertThat(customer.getUid()).isEqualTo("timulf70");
        assertThat(customer.getFullName()).isEqualTo("Jabberstorm");
        assertThat(customer.getProfileCode()).isEqualTo("CUSTOMER");
        assertThat(customer.getUserType()).isEqualTo("C");
    }
}
