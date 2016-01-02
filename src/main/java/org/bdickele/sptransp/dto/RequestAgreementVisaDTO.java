package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bdickele.sptransp.domain.RequestAgreementVisaStatus;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;
import org.bdickele.sptransp.dto.converter.SeniorityConverter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Bertrand DICKELE
 */
@ToString(of = {"departmentCode", "seniority", "employeeUid"})
@EqualsAndHashCode(of = {"employeeUid", "statusCode", "departmentCode", "seniority"}, doNotUseGetters = true)
@Getter
public class RequestAgreementVisaDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = 5984205835227083895L;

    private Integer rank;

    private Long employeeId;

    private String employeeUid;

    private String employeeName;

    private String statusCode;

    private String departmentCode;

    private String departmentName;

    @JsonSerialize(using = SeniorityConverter.SenioritySerializer.class)
    @JsonDeserialize(using = SeniorityConverter.SeniorityDeserializer.class)
    private Seniority seniority;

    private String comment;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime date;


    public static RequestAgreementVisaDTO build(EmployeeDTO employee, RequestAgreementVisaStatus status,
                                             Integer rank, String comment, String departmentCode, String departmentName,
                                             Seniority seniority, LocalDateTime creationDate) {
        RequestAgreementVisaDTO v = new RequestAgreementVisaDTO();
        v.employeeId = employee.getId();
        v.employeeUid = employee.getUid();
        v.employeeName = employee.getFullName();
        v.statusCode = status.getCode();
        v.rank = rank;
        v.comment = comment;
        v.departmentCode = departmentCode;
        v.departmentName = departmentName;
        v.seniority = seniority;
        v.date = creationDate;
        return v;
    }
}
