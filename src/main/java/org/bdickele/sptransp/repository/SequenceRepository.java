package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.SequenceDTO;
import org.jongo.MongoCollection;

/**
 * Created by Bertrand DICKELE
 */
public class SequenceRepository extends AbstractRepository {

    public static final String SEQUENCE_REQUEST = "requestId";

    public static final String SEQUENCE_AGRREMENT_RULE = "agreementRuleId";

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

    private Long getNextSequenceValue(String sequenceName) {
        return getCollection().findAndModify("{ _id: #}", sequenceName).with("{$inc: {seq: 1}}").returnNew().as(SequenceDTO.class).getSeq();
    }
}
