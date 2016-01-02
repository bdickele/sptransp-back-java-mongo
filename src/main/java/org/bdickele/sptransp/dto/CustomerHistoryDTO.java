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
@JsonPropertyOrder({"version", "versionDate", "versionUser", "fullName", "profileCode"})
@EqualsAndHashCode(of = "version", doNotUseGetters = true)
@Getter
public class CustomerHistoryDTO {

    private Integer version;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime versionDate;

    private String versionUser;

    private String fullName;

    private String profileCode;


    public static CustomerHistoryDTO build(CustomerDTO customer) {
        CustomerHistoryDTO c = new CustomerHistoryDTO();
        c.version = customer.getVersion();
        c.fullName  = customer.getFullName();
        c.profileCode = customer.getProfileCode();
        c.versionDate = customer.getUpdateDate();
        c.versionUser = customer.getUpdateUser();
        return c;
    }
}
