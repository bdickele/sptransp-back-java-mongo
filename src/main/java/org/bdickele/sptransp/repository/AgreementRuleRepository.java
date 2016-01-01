package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.AgreementRuleDTO;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
public interface AgreementRuleRepository {

    //@Query("select r from AgreementRule r where r.destination.code = :destinationCode and r.goods.code = :goodsCode")
    AgreementRuleDTO findByDestinationCodeAndGoodsCode(String destinationCode,
                                                       String goodsCode);

    List<AgreementRuleDTO> findByDestinationCode(String destinationCode);

    List<AgreementRuleDTO> findByGoodsCode(String goodsCode);
}
