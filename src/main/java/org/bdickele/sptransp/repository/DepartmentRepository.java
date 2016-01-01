package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.DepartmentDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;

/**
 * Created by bdickele
 */
public class DepartmentRepository extends SpTranspRepository {

    private static final String COLLECTION = "departments";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public List<DepartmentDTO> findAll() {
        MongoCursor<DepartmentDTO> cursor = getCollection().find()
                .sort("{name: 1}")
                .as(DepartmentDTO.class);
        return getList(cursor);
    }

    public DepartmentDTO findByCode(String code) {
        return getCollection().findOne("{code: #}", code).as(DepartmentDTO.class);
    }
}
