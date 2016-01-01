package org.bdickele.sptransp.testdata;

import org.apache.commons.lang3.tuple.Pair;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.DepartmentDTO;
import org.bdickele.sptransp.dto.DestinationDTO;
import org.bdickele.sptransp.dto.GoodsDTO;
import org.bdickele.sptransp.repository.DestinationRepository;
import org.bdickele.sptransp.repository.GoodsRepository;
import org.bdickele.sptransp.service.AgreementRuleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Bertrand DICKELE
 */
public class CreateTestDataAgreementRules extends AbstractCreateTestData {

    private static final DepartmentDTO DEPARTMENT_LAW_COMPLIANCE = DepartmentDTO.buidl( "LAW_COMPLIANCE", "Law compliance");
    private static final DepartmentDTO DEPARTMENT_SHUTTLE_COMPLIANCE = DepartmentDTO.buidl("SHUTTLE_COMPLIANCE", "Shuttle compliance");
    private static final DepartmentDTO DEPARTMENT_GOODS_INSPECTION = DepartmentDTO.buidl("GOODS_INSPECTION", "Goods inspection");
    private static final DepartmentDTO DEPARTMENT_JOURNEY_SUPERVISION = DepartmentDTO.buidl("JOURNEY_SUPERVISION", "Journey supervision");


    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private AgreementRuleService ruleService;

    private Random random = new Random();


    @Test
    public void createTestData() {
        deleteAllAgreementRules();
        createAgreementRules();
    }

    private void deleteAllAgreementRules() {
        getCollection("agreementRules").remove();
    }

    private void createAgreementRules() {
        List<DestinationDTO> destinations = destinationRepository.findAll();
        List<GoodsDTO> goods = goodsRepository.findAll();

        destinations.forEach(destination -> {
            goods.forEach(good -> createAgreementRule(good, destination));
        });
    }

    private void createAgreementRule(GoodsDTO goods, DestinationDTO destination) {
        String goodsCode = goods.getCode();
        String destinationCode = destination.getCode();

        List<Pair<DepartmentDTO, Seniority>> visas = new ArrayList<>();
        visas.add(Pair.of(DEPARTMENT_LAW_COMPLIANCE, createGoodsSeniority(goodsCode)));
        visas.add(Pair.of(DEPARTMENT_SHUTTLE_COMPLIANCE, createDistanceSeniority(destinationCode)));
        visas.add(Pair.of(DEPARTMENT_GOODS_INSPECTION, createGoodsSeniority(goodsCode)));
        visas.add(Pair.of(DEPARTMENT_JOURNEY_SUPERVISION, createDistanceSeniority(destinationCode)));

        //print(">> " + goodsCode + " - " + destinationCode);
        //visas.forEach(v -> print(v.getLeft().getCode() + " " + v.getRight().getValue()));

        ruleService.create(destination, goods, true, visas, "batch");
    }

    /**
     * On va creer des seniorites plus elevees pour les destinations lointaines
     * @param destinationCode
     * @return
     */
    private Seniority createDistanceSeniority(String destinationCode) {
        if (destinationCode.startsWith("JUPITER") || destinationCode.startsWith("SATURN")) {
            return seniority(6, 10);
        } else if (destinationCode.startsWith("MARS")) {
            return seniority(3, 7);
        } else {
            return seniority(1, 4);
        }
    }

    private Seniority createGoodsSeniority(String goodsCode) {
        switch (goodsCode) {
            case "OIL" : return seniority(4, 8);
            case "FOOD" : return seniority(1, 4);
            case "MACHINE_TOOL" : return seniority(3, 7);
            case "MEDICINE" : return seniority(4, 9);
            case "WEAPON" : return seniority(8, 10);
            default: return seniority(1, 10);
        }
    }

    private Seniority seniority(int lowerBound, int upperBound) {
        int value = random.ints(lowerBound, upperBound).findFirst().getAsInt();
        return Seniority.of(value * 10);
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
