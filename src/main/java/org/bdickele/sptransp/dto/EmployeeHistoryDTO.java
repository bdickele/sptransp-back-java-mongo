package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;
import org.bdickele.sptransp.dto.converter.SeniorityConverter;

import java.time.LocalDateTime;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"version", "versionDate", "versionUser", "fullName", "profileCode", "departmentCode", "seniority"})
@EqualsAndHashCode(of = "version", doNotUseGetters = true)
@Getter
public class EmployeeHistoryDTO {

    private Integer version;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime versionDate;

    private String versionUser;

    private String fullName;

    private String profileCode;

    private String departmentCode;

    @JsonSerialize(using = SeniorityConverter.SenioritySerializer.class)
    @JsonDeserialize(using = SeniorityConverter.SeniorityDeserializer.class)
    private Seniority seniority;


    public static EmployeeHistoryDTO build(EmployeeDTO employee) {
        EmployeeHistoryDTO r = new EmployeeHistoryDTO();
        r.version = employee.getVersion();
        r.fullName  = employee.getFullName();
        r.profileCode = employee.getProfileCode();
        r.departmentCode = employee.getDepartmentCode();
        r.seniority = employee.getSeniority();
        r.versionDate = employee.getUpdateDate();
        r.versionUser = employee.getUpdateUser();
        return r;
    }
}
