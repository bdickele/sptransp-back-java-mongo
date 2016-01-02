package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bdickele.sptransp.domain.UserProfile;
import org.bdickele.sptransp.domain.UserType;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"uid", "fullName", "profileCode", "profileName",
        "creationDate", "creationUser", "updateDate", "updateUser"})
@EqualsAndHashCode(callSuper = true, of = {}, doNotUseGetters = true)
@Getter
public class CustomerDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = -8182869212493007142L;

    private String fullName;

    private List<CustomerHistoryDTO> history;


    public static CustomerDTO build(Long id, String uid, String fullName, String creationUserUid, PasswordEncoder passwordEncoder) {
        CustomerDTO c = new CustomerDTO();
        c.id = id;
        c.version = 1;
        c.password = passwordEncoder.encode("changeme");
        c.uid = uid;
        c.userType = UserType.CUSTOMER.getCode();
        c.profileCode = UserProfile.CUSTOMER.getCode();
        c.profileName = UserProfile.CUSTOMER.getLabel();
        c.fullName = fullName;

        LocalDateTime date = LocalDateTime.now();
        c.creationDate = date;
        c.updateDate = date;

        c.creationUser = creationUserUid;
        c.updateUser = creationUserUid;

        c.checkValues();

        c.history.add(CustomerHistoryDTO.build(c));

        return c;
    }

    public void update(String fullName, String updateUser) {
        this.version = this.version + 1;
        this.fullName = fullName;
        this.updateUser = updateUser;
        this.updateDate = LocalDateTime.now();

        this.history.add(CustomerHistoryDTO.build(this));

        checkValues();
    }

    public void checkValues() {
        checkUid();
        checkFullName();
        checkCreationInfo();
        checkUpdateInfo();
    }

    public void checkUid() {
        if (StringUtils.isEmpty(uid)) throw SpTranspBizError.CUSTOMER_MISSING_VALUE.exception("uid");
    }

    public void checkFullName() {
        if (StringUtils.isEmpty(fullName)) throw SpTranspBizError.CUSTOMER_MISSING_VALUE.exception("name");
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uid", uid)
                .append("fullName", fullName)
                .toString();
    }
}
