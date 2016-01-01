package org.bdickele.sptransp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@EqualsAndHashCode(of = "reference", doNotUseGetters = true)
@ToString(of = {"reference", "customerUid", "departureCode", "arrivalCode", "goodsCode", "creationDate"}, doNotUseGetters = true)
@Getter
public class RequestDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -3314219597285942969L;

    private String reference;

    private String creationDate;

    private Long creationDateForComparison;

    private String updateDate;

    private Long updateDateForComparison;

    private String customerUid;

    private String customerName;

    private String goodsCode;

    private String goodsName;

    private String departureCode;

    private String departureName;

    private String arrivalCode;

    private String arrivalName;

    private String overallStatusCode;

    private String overallStatusLabel;

    private String agreementStatusCode;

    private String agreementStatusLabel;

    private AgreementRuleVisaDTO nextExpectedAgreementVisa;

    // Detailed informations

    private Integer nextAgreementVisaRank;

    private List<RequestAgreementVisaDTO> appliedAgreementVisas;

    private List<AgreementRuleVisaDTO> requiredAgreementVisas;


}
