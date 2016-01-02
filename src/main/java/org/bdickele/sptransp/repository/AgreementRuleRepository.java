package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.AgreementRuleDTO;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
public class AgreementRuleRepository extends AbstractRepository {

    private static final String COLLECTION = "agreementRules";

    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public AgreementRuleDTO findByDestinationCodeAndGoodsCode(String destinationCode, String goodsCode) {
        return getCollection().findOne("{destinationCode: {$eq: #}, goodsCode: {$eq: #}}", destinationCode, goodsCode).as(AgreementRuleDTO.class);
    }

    public List<AgreementRuleDTO> findAll() {
        MongoCursor<AgreementRuleDTO> cursor = getCollection().find().as(AgreementRuleDTO.class);
        return getList(cursor);
    }

    public List<AgreementRuleDTO> findByDestinationCode(String destinationCode) {
        MongoCursor<AgreementRuleDTO> cursor = getCollection().find("{destinationCode: #}", destinationCode)
                .as(AgreementRuleDTO.class);
        return getList(cursor);
    }

    public List<AgreementRuleDTO> findByGoodsCode(String goodsCode) {
        MongoCursor<AgreementRuleDTO> cursor = getCollection().find("{goodsCode: #}", goodsCode)
                .as(AgreementRuleDTO.class);
        return getList(cursor);
    }
}
