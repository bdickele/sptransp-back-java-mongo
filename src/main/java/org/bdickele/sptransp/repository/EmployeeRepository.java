package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.domain.UserType;
import org.bdickele.sptransp.dto.EmployeeDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@Repository
public class EmployeeRepository extends AbstractRepository {

    private static final String COLLECTION = "users";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public List<EmployeeDTO> findAll() {
        MongoCursor<EmployeeDTO> cursor = getCollection().find("{userType: #}", UserType.EMPLOYEE.getCode())
                .sort("{fullName: 1}")
                .as(EmployeeDTO.class);
        return getList(cursor);
    }

    public EmployeeDTO findByUid(String uid) {
        return getCollection().findOne("{userType: #, uid: #}", UserType.EMPLOYEE.getCode(), uid).as(EmployeeDTO.class);
    }
}
