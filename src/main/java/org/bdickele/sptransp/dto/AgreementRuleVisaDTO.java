package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.converter.SeniorityConverter;

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

    @JsonSerialize(using = SeniorityConverter.SenioritySerializer.class)
    @JsonDeserialize(using = SeniorityConverter.SeniorityDeserializer.class)
    private Seniority seniority;

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
        v.seniority = seniority;
        return v;
    }

    public boolean canBeAppliedBy(String departmentCode, Seniority seniority) {
        return this.departmentCode.equals(departmentCode) && seniority.ge(this.seniority);
    }
}
