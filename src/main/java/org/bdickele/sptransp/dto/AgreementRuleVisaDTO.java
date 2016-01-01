package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bdickele.sptransp.domain.Seniority;

import java.io.Serializable;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"rank", "departmentCode", "seniority"})
@EqualsAndHashCode(of = {"departmentCode", "seniority"}, doNotUseGetters = true)
@ToString(of = {"departmentCode", "seniority"})
@Getter
public class AgreementRuleVisaDTO implements Serializable {

    private static final long serialVersionUID = 7918477704866738045L;

    private Integer rank;

    private String departmentCode;

    private Integer seniority;

    /**
     * Build method for an agreement visa
     * @param rank
     * @param department
     * @param seniority
     * @return
     */
    public static AgreementRuleVisaDTO build(Integer rank, DepartmentDTO department, Seniority seniority) {
        AgreementRuleVisaDTO v = new AgreementRuleVisaDTO();
        v.rank = rank;
        v.departmentCode = department.getCode();
        v.seniority = seniority.getValue();
        return v;
    }
}
