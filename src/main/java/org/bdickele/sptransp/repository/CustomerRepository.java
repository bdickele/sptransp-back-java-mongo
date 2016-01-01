package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.domain.UserType;
import org.bdickele.sptransp.dto.CustomerDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;

/**
 * Created by bdickele
 */
public class CustomerRepository extends AbstractRepository {

    private static final String COLLECTION = "users";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public List<CustomerDTO> findAll() {
        MongoCursor<CustomerDTO> cursor = getCollection().find("{userType: #}", UserType.CUSTOMER.getCode())
                .sort("{fullName: 1}")
                .as(CustomerDTO.class);
        return getList(cursor);
    }

    public CustomerDTO findByUid(String uid) {
        return getCollection().findOne("{userType: #, uid: #}", UserType.CUSTOMER.getCode(), uid).as(CustomerDTO.class);
    }
}
