package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"departmentCode", "departmentName", "seniority"})
@EqualsAndHashCode(of = {"departmentCode", "seniority"}, doNotUseGetters = true)
@ToString(of = {"departmentCode", "seniority"})
@Getter
public class AgreementRuleVisaDTO implements Serializable {

    private static final long serialVersionUID = 7918477704866738045L;

    @JsonProperty(value = "departmentCode")
    private String departmentCode;

    @JsonProperty(value = "departmentName")
    private String departmentName;

    @JsonProperty(value = "seniority")
    private Integer seniority;

}
