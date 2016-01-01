package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"uid", "fullName", "profileCode", "creationDate", "creationUser", "updateDate", "updateUser"})
@EqualsAndHashCode(callSuper = true, of = {}, doNotUseGetters = true)
@Getter
public class CustomerDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = -8182869212493007142L;

    private String fullName;

    private List<CustomerHistoryDTO> history;


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uid", uid)
                .append("fullName", fullName)
                .toString();
    }
}
