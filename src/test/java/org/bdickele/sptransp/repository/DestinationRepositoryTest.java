package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.DestinationDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by Bertrand DICKELE
 */
public class DestinationRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private DestinationRepository repository;


    @Test
    public void should_find_all_destinations() {
        List<DestinationDTO> destinations = repository.findAll();
        assertThat(destinations.size()).isGreaterThanOrEqualTo(5);

        assertThat(destinations).extracting("name", "code").contains(
                tuple("Earth", "EARTH"),
                tuple("Mars", "MARS"),
                tuple("Moon", "MOON"),
                tuple("Titan", "SATURN_TITAN"));
    }

    @Test
    public void destination_by_code_should_work() {
        DestinationDTO moon = repository.findByCode("MOON");
        assertThat(moon).isNotNull();
        assertThat(moon.getCode()).isEqualTo("MOON");
        assertThat(moon.getName()).isEqualTo("Moon");
    }
}
