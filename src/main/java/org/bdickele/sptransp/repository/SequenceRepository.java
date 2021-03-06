package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.SequenceDTO;
import org.jongo.MongoCollection;
import org.springframework.stereotype.Repository;

/**
 * Created by Bertrand DICKELE
 */
@Repository
public class SequenceRepository extends AbstractRepository {

    public static final String SEQUENCE_REQUEST = "requestId";

    public static final String SEQUENCE_AGRREMENT_RULE = "agreementRuleId";

    public static final String SEQUENCE_USER = "userId";

    private static final String COLLECTION = "counters";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public Long getCurrentValue(String sequenceName) {
        return getCollection().findOne("{_id: {$eq: #}}", sequenceName).as(SequenceDTO.class).getSeq();
    }

    public Long getNextSequenceValueForRequest() {
        return getNextSequenceValue(SEQUENCE_REQUEST);
    }

    public Long getNextSequenceValueForAgreementRule() {
        return getNextSequenceValue(SEQUENCE_AGRREMENT_RULE);
    }

    public Long getNextSequenceValueForUser() {
        return getNextSequenceValue(SEQUENCE_USER);
    }

    private Long getNextSequenceValue(String sequenceName) {
        return getCollection().findAndModify("{ _id: #}", sequenceName).with("{$inc: {seq: 1}}").returnNew().as(SequenceDTO.class).getSeq();
    }
}
