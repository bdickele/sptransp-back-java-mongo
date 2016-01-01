package org.bdickele.sptransp.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Bertrand DICKELE
 */
public class SequenceRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private SequenceRepository repository;

    @Test
    public void sequence_for_request_should_work() {
        Long currentId = repository.getCurrentValue(SequenceRepository.SEQUENCE_REQUEST);
        System.out.println("Current ID = " + currentId);

        Long newId = repository.getNextSequenceValueForRequest();
        System.out.println("New ID = " + newId);
        assertThat(newId).isNotNull();
        assertThat(newId).isEqualTo(currentId + 1);
    }
}
