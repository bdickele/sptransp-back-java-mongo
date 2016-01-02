package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.bdickele.sptransp.domain.RequestAgreementStatus;
import org.bdickele.sptransp.domain.RequestAgreementVisaStatus;
import org.bdickele.sptransp.domain.RequestOverallStatus;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;
import org.bdickele.sptransp.dto.converter.RequestAgreementStatusConverter;
import org.bdickele.sptransp.dto.converter.RequestOverallStatusConverter;
import org.bdickele.sptransp.exception.SpTranspTechError;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.bdickele.sptransp.exception.SpTranspBizError.*;

/**
 * Created by Bertrand DICKELE
 */
@EqualsAndHashCode(of = "reference", doNotUseGetters = true)
@ToString(of = {"reference", "customerUid", "departureCode", "arrivalCode", "goodsCode",
        "overallStatus", "agreementStatus", "creationDate"}, doNotUseGetters = true)
@Getter
public class RequestDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -3314219597285942969L;

    @MongoObjectId
    private String _id;

    private Long id;

    @Setter
    private Integer version;

    private String reference;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    private String creationUser;

    //private Long creationDateForComparison;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime updateDate;

    private String updateUser;

    //private Long updateDateForComparison;

    private String customerUid;

    private String customerName;

    private String goodsCode;

    private String goodsName;

    private String departureCode;

    private String departureName;

    private String arrivalCode;

    private String arrivalName;

    @JsonSerialize(using = RequestOverallStatusConverter.RequestOverallStatusSerializer.class)
    @JsonDeserialize(using = RequestOverallStatusConverter.RequestOverallStatusDeserializer.class)
    private RequestOverallStatus overallStatus;

    @JsonSerialize(using = RequestAgreementStatusConverter.RequestAgreementStatusSerializer.class)
    @JsonDeserialize(using = RequestAgreementStatusConverter.RequestAgreementStatusDeserializer.class)
    private RequestAgreementStatus agreementStatus;

    private String cancellationComment;

    private Integer nextAgreementVisaRank;

    private AgreementRuleHistoryDTO agreementRule;

    private List<RequestAgreementVisaDTO> appliedAgreementVisas;


    /**
     * @return Next expected agreement visa (if any)
     */
    public Optional<AgreementRuleVisaDTO> getNextExpectedAgreementVisa() {
        return agreementRule.getVisas().stream()
                .filter(v -> v.getRank().equals(nextAgreementVisaRank))
                .findFirst();
    }

    public static RequestDTO build(Long id, String reference, CustomerDTO customer, GoodsDTO goods,
                                DestinationDTO departure, DestinationDTO arrival, AgreementRuleHistoryDTO ruleVersion) {
        RequestDTO r = new RequestDTO();
        r.id = id;
        r.version = 1;
        r.reference = reference;
        r.customerUid = customer.getUid();
        r.customerName = customer.getFullName();
        r.goodsCode = goods.getCode();
        r.goodsName = goods.getName();
        r.departureCode = departure.getCode();
        r.departureName = departure.getName();
        r.arrivalCode = arrival.getCode();
        r.arrivalName = arrival.getName();
        r.overallStatus = RequestOverallStatus.WAITING_FOR_VALIDATION;
        r.agreementStatus = RequestAgreementStatus.PENDING;
        r.nextAgreementVisaRank = 0;
        r.agreementRule = ruleVersion;
        r.appliedAgreementVisas = new ArrayList<>();

        LocalDateTime date = LocalDateTime.now();
        r.creationDate = date;
        r.updateDate = date;

        String customerUid = customer.getUid();
        r.creationUser = customerUid;
        r.updateUser = customerUid;

        r.checkValues();

        return r;
    }

    public void checkValues() {
        checkReference();
        checkCustomer();
        checkGoods();
        checkDeparture();
        checkArrival();
        checkDepartureAndArrival();
        checkAgreementRule();
        checkCreationInfo();
        checkUpdateInfo();
    }

    public void checkReference() {
        if (StringUtils.isEmpty(reference)) throw REQUEST_MISSING_VALUE.exception("reference");
    }

    public void checkCustomer() {
        if (customerUid==null) throw REQUEST_MISSING_VALUE.exception("customer");
    }

    public void checkGoods() {
        if (goodsCode==null) throw REQUEST_MISSING_VALUE.exception("goods");
    }

    public void checkDeparture() {
        if (departureCode==null) throw REQUEST_MISSING_VALUE.exception("departure");
    }

    public void checkArrival() {
        if (arrivalCode==null) throw REQUEST_MISSING_VALUE.exception("arrival");
    }

    public void checkDepartureAndArrival() {
        if (departureCode.equals(arrivalCode)) throw DESTINATION_AND_ARRIVAL_ARE_THE_SAME.exception();
    }

    public void checkAgreementRule() {
        if (agreementRule ==null) throw REQUEST_MISSING_VALUE.exception("rule");
        if (!agreementRule.isAllowed()) throw REQUEST_NOT_ALLOWED.exception(goodsName, arrivalName);
    }

    public void checkCreationInfo() {
        if (StringUtils.isEmpty(creationUser)) throw SpTranspTechError.MISSING_INFORMATION.exception("creation user");
        if (creationDate==null) throw SpTranspTechError.MISSING_INFORMATION.exception("creation date");
    }

    public void checkUpdateInfo() {
        if (StringUtils.isEmpty(updateUser)) throw SpTranspTechError.MISSING_INFORMATION.exception("update user");
        if (updateDate==null) throw SpTranspTechError.MISSING_INFORMATION.exception("update date");
    }

    /**
     * Method to call when we want to apply (grant or deny) an agreement visa
     * @param employee
     * @param visaStatus
     * @param comment
     * @return
     */
    public RequestDTO applyAgreementVisa(EmployeeDTO employee, RequestAgreementVisaStatus visaStatus, String comment) {
        if (!waitsForAnAgreementVisa()) {
            throw REQUEST_DOES_NOT_EXPECT_ANY_AGREEMENT_VISA.exception();
        }

        if (userHasAlreadyAppliedAVisa(employee.getId())) {
            throw EMPLOYEE_HAS_ALREADY_APPLIED_A_VISA.exception(employee.getFullName());
        }

        AgreementRuleVisaDTO nextExpectedVisa = getNextExpectedAgreementVisa()
                .orElseThrow(() -> COULD_NOT_FIND_NEXT_EXPECTED_AGREEMENT_VISA.exception());

        String department = employee.getDepartmentCode();
        Seniority seniority = employee.getSeniority();

        if (!nextExpectedVisa.canBeAppliedBy(department, seniority)) {
            throw VISA_TO_APPLY_DOESNT_MATCH_NEXT_EXPECTED_ONE.exception(department, seniority,
                    nextExpectedVisa.getDepartmentCode(), nextExpectedVisa.getSeniority());
        }

        LocalDateTime now = LocalDateTime.now();

        RequestAgreementVisaDTO appliedVisa = RequestAgreementVisaDTO.build(employee, visaStatus,
                nextAgreementVisaRank, comment, department, seniority, now);

        addAgreementVisa(appliedVisa);

        updateUser = employee.getUid();
        updateDate = now;

        return this;
    }

    /**
     * We know what is the next visa to apply. Let's add it to the list of applied visas and check what is the new
     * visaStatus of the request
     * @param appliedVisa Visa to add
     */
    private void addAgreementVisa(RequestAgreementVisaDTO appliedVisa) {
        getAppliedAgreementVisas().add(appliedVisa);

        RequestAgreementVisaStatus lastAppliedVisaStatus = RequestAgreementVisaStatus.getByCode(appliedVisa.getStatusCode());

        // If last visa applied has been denied, no need to carry on: request is refused
        if (lastAppliedVisaStatus == RequestAgreementVisaStatus.DENIED) {
            nextAgreementVisaRank = -1;
            agreementStatus = RequestAgreementStatus.REFUSED;
            overallStatus = RequestOverallStatus.REFUSED;
        } else if (lastAppliedVisaStatus == RequestAgreementVisaStatus.GRANTED) {
            // Let's check if granted visa is the last one
            Integer rankOfLastExpectedVisa = agreementRule.getVisas().stream()
                    .max(Comparator.comparing(AgreementRuleVisaDTO::getRank))
                    .get().getRank();

            if (appliedVisa.getRank().equals(rankOfLastExpectedVisa)) {
                nextAgreementVisaRank = -1;
                agreementStatus = RequestAgreementStatus.GRANTED;
                overallStatus = RequestOverallStatus.VALIDATED;
            } else {
                nextAgreementVisaRank++;
            }
        } else {
            // Not supposed to happen except business rule gets changed
            throw UNEXPECTED_ERROR.exception("Unknown visaStatus of agreement visa: " + lastAppliedVisaStatus);
        }
    }

    /**
     * @return True if that request is still waiting for an agreement visa
     */
    public boolean waitsForAnAgreementVisa() {
        return agreementStatus==RequestAgreementStatus.PENDING;
    }

    /**
     * @param employeeId
     * @return True if passed employee has already applied an agreement visa for that request
     */
    public boolean userHasAlreadyAppliedAVisa(Long employeeId) {
        return appliedAgreementVisas.stream()
                .filter(v -> v.getEmployeeId().equals(employeeId))
                .findFirst()
                .isPresent();
    }
}
