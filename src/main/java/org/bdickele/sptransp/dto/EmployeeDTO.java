package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Employee object returned by web services
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"uid", "fullName", "profileCode", "departmentCode", "departmentLabel",
        "seniority", "creationDate", "creationUser", "updateDate", "updateUser"})
@EqualsAndHashCode(callSuper = true, of = {}, doNotUseGetters = true)
@Getter
public class EmployeeDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = -603242397122687641L;

    private String fullName;

    private String departmentCode;

    private String departmentLabel;

    private Integer seniority;

    private List<EmployeeHistoryDTO> history;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uid", uid)
                .append("fullName", fullName)
                .toString();
    }
 }
