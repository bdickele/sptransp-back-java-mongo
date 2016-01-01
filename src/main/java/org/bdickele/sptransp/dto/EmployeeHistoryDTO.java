package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;

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

    private Integer seniority;
}
