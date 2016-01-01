package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.GoodsDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by Bertrand DICKELE
 */
public class GoodsRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private GoodsRepository repository;

    @Test
    public void should_find_all_goods() {
        List<GoodsDTO> goods = repository.findAll();
        assertThat(goods).hasSize(5);

        assertThat(goods).extracting("name", "code").containsExactly(
                tuple("Food", "FOOD"),
                tuple("Machine tool", "MACHINE_TOOL"),
                tuple("Medicine", "MEDICINE"),
                tuple("Oil", "OIL"),
                tuple("Weapon", "WEAPON"));
    }

    @Test
    public void find_by_code_should_work() {
        GoodsDTO goods = repository.findByCode("FOOD");
        assertThat(goods.getName()).isEqualTo("Food");

        goods = repository.findByCode("FOO");
        assertThat(goods).isNull();
    }
}
