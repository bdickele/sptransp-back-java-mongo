package org.bdickele.sptransp.repository;

import org.assertj.core.api.StrictAssertions;
import org.bdickele.sptransp.dto.RequestDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bertrand DICKELE
 */
public class RequestRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private RequestRepository repository;


    @Test
    public void find_by_reference_should_work() {
        String reference = repository.findAll().iterator().next().getReference();
        RequestDTO request  = repository.findByReference(reference);
        StrictAssertions.assertThat(request).isNotNull();
    }
}
