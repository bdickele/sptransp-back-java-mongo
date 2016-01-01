package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Employee object returned by web services
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"uid", "fullName", "profileCode", "profileLabel", "departmentCode", "departmentLabel",
        "seniority", "creationDate", "creationUser", "updateDate", "updateUser"})
@EqualsAndHashCode(callSuper = true, of = {}, doNotUseGetters = true)
@Getter
public class EmployeeDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = -603242397122687641L;

    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "departmentCode")
    private String departmentCode;

    @JsonProperty(value = "departmentLabel")
    private String departmentLabel;

    @JsonProperty(value = "seniority")
    private Integer seniority;


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uid", uid)
                .append("fullName", fullName)
                .toString();
    }
 }
