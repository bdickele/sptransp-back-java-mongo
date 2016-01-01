package org.bdickele.sptransp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Bertrand DICKELE
 */
@ToString(of = {"departmentCode", "seniority", "employeeUid"})
@EqualsAndHashCode(of = {"employeeUid", "statusCode", "departmentCode", "seniority"}, doNotUseGetters = true)
@Getter
public class RequestAgreementVisaDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = 5984205835227083895L;

    private String employeeUid;

    private String employeeName;

    private String statusCode;

    private String departmentCode;

    private String departmentName;

    private Integer seniority;

    private String comment;

    private String date;

}
