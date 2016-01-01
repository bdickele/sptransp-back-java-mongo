package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.DestinationDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;

/**
 * Created by bdickele
 */
public class DestinationRepository extends SpTranspRepository {

    private static final String COLLECTION = "destinations";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public List<DestinationDTO> findAll() {
        MongoCursor<DestinationDTO> cursor = getCollection().find()
                .sort("{name: 1}")
                .as(DestinationDTO.class);
        return getList(cursor);
    }

    /**
     * @param code Destination's code
     * @return Corresponding destination
     */
    public DestinationDTO findByCode(String code) {
        return getCollection().findOne("{code: #}", code).as(DestinationDTO.class);
    }
}
