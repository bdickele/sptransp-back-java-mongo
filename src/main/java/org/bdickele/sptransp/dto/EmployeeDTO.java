package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.domain.UserProfile;
import org.bdickele.sptransp.domain.UserType;
import org.bdickele.sptransp.dto.converter.SeniorityConverter;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public static final Seniority SENIORITY_MIN = Seniority.of(0);

    public static final Seniority SENIORITY_MAX = Seniority.of(100);

    private String fullName;

    private String departmentCode;

    private String departmentLabel;

    @JsonSerialize(using = SeniorityConverter.SenioritySerializer.class)
    @JsonDeserialize(using = SeniorityConverter.SeniorityDeserializer.class)
    private Seniority seniority;

    private List<EmployeeHistoryDTO> history = new ArrayList<>();


    public static EmployeeDTO build(Long id, String uid, String fullName, UserProfile profile,
                                 DepartmentDTO department, Seniority seniority, String creationUser,
                                 PasswordEncoder passwordEncoder) {
        EmployeeDTO e = new EmployeeDTO();
        e.id = id;
        e.version = 1;
        e.password = passwordEncoder.encode("changeme");
        e.uid = uid;
        e.userType = UserType.EMPLOYEE.getCode();
        e.profileCode = profile.getCode();
        e.fullName = fullName;
        e.departmentCode = department.getCode();
        e.departmentLabel = department.getName();
        e.seniority = seniority;

        LocalDateTime date = LocalDateTime.now();
        e.creationDate = date;
        e.updateDate = date;

        e.creationUser = creationUser;
        e.updateUser = creationUser;

        e.checkValues();

        e.history.add(EmployeeHistoryDTO.build(e));

        return e;
    }

    public void update(String fullName, UserProfile profile, DepartmentDTO department,
                       Seniority seniority, String updateUser) {
        this.version = this.version + 1;
        this.fullName = fullName;
        this.profileCode = profile.getCode();
        this.departmentCode = department.getCode();
        this.departmentLabel = department.getName();
        this.seniority = seniority;
        this.updateUser = updateUser;
        this.updateDate = LocalDateTime.now();

        this.history.add(EmployeeHistoryDTO.build(this));

        checkValues();
    }

    public void checkValues() {
        checkUid();
        checkFullName();
        checkProfile();
        checkDepartment();
        checkSeniority();
        checkCreationInfo();
        checkUpdateInfo();
    }

    public void checkUid() {
        if (StringUtils.isEmpty(uid)) throw SpTranspBizError.EMPLOYEE_MISSING_VALUE.exception("uid");
    }

    public void checkFullName() {
        if (StringUtils.isEmpty(fullName)) throw SpTranspBizError.EMPLOYEE_MISSING_VALUE.exception("name");
    }

    public void checkProfile() {
        if (profileCode==null) throw SpTranspBizError.EMPLOYEE_MISSING_VALUE.exception("profile");
    }

    public void checkDepartment() {
        if (departmentCode==null) throw SpTranspBizError.EMPLOYEE_MISSING_VALUE.exception("department");
    }

    public void checkSeniority() {
        if (seniority==null) throw SpTranspBizError.EMPLOYEE_MISSING_VALUE.exception("seniority");

        if (seniority.lt(SENIORITY_MIN) || seniority.gt(SENIORITY_MAX))
            throw SpTranspBizError.EMPLOYEE_INCORRECT_SENIORITY.exception(
                    SENIORITY_MIN.getValue(), SENIORITY_MAX.getValue());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uid", uid)
                .append("fullName", fullName)
                .toString();
    }
 }
