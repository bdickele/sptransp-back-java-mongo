package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.GoodsDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
public class GoodsRepository extends AbstractRepository {

    private static final String COLLECTION = "goods";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public List<GoodsDTO> findAll() {
        MongoCursor<GoodsDTO> cursor = getCollection().find()
                .sort("{name: 1}")
                .as(GoodsDTO.class);
        return getList(cursor);
    }

    public GoodsDTO findByCode(String code) {
        return getCollection().findOne("{code: #}", code).as(GoodsDTO.class);
    }
}
