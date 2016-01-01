package org.bdickele.sptransp.service;

import org.apache.commons.lang3.tuple.Pair;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.*;
import org.bdickele.sptransp.repository.AgreementRuleRepository;
import org.bdickele.sptransp.repository.DestinationRepository;
import org.bdickele.sptransp.repository.GoodsRepository;
import org.bdickele.sptransp.repository.SequenceRepository;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@Service
public class AgreementRuleService extends AbstractService {

    private static final String COLLECTION = "agreementRules";

    @Autowired
    private AgreementRuleRepository repository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private SequenceRepository sequenceRepository;


    private MongoCollection getCollection() {
        return getCollection(COLLECTION);
    }

    public AgreementRuleDTO create(String destinationCode, String goodsCode, boolean allowed,
                                   List<Pair<DepartmentDTO, Seniority>> departmentAndSeniorities, String creationUser) {
        DestinationDTO destination = destinationRepository.findByCode(destinationCode);
        GoodsDTO goods = goodsRepository.findByCode(goodsCode);
        return create(destination, goods, allowed, departmentAndSeniorities, creationUser);
    }

    public AgreementRuleDTO create(DestinationDTO destination, GoodsDTO goods, boolean allowed,
                                   List<Pair<DepartmentDTO, Seniority>> departmentAndSeniorities, String creationUser) {
        Long id = sequenceRepository.getNextSequenceValueForAgreementRule();
        AgreementRuleDTO rule = AgreementRuleDTO.build(id, destination, goods, allowed, creationUser);
        departmentAndSeniorities.forEach(pair -> rule.addVisa(pair.getLeft(), pair.getRight()));

        rule.getHistory().add(AgreementRuleHistoryDTO.build(rule));

        getCollection().insert(rule);

        return rule;
    }

    public AgreementRuleDTO update(String destinationCode, String goodsCode, boolean allowed,
                                List<Pair<DepartmentDTO, Seniority>> departmentAndSeniorities, String updateUser) {
        // We assume destination and goods can't change, what means we can retrieve current rule based on these values
        AgreementRuleDTO rule = repository.findByDestinationCodeAndGoodsCode(destinationCode, goodsCode);
        rule.update(allowed, departmentAndSeniorities, updateUser);

        getCollection().update("{id: #}", rule.getId()).with(rule);

        return rule;
    }
}
