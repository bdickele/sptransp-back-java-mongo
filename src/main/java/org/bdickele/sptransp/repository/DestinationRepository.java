package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.configuration.DomainCacheConfig;
import org.bdickele.sptransp.dto.DestinationDTO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by bdickele
 */
public interface DestinationRepository {

    List<DestinationDTO> findAllByOrderByNameAsc();

    /**
     * @param code Destination's code
     * @return Corresponding Destination
     */
    @Cacheable(value= DomainCacheConfig.DESTINATION)
    DestinationDTO findByCode(String code);
}
