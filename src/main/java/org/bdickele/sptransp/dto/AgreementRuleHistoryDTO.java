package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"version", "versionDate", "versionUser", "allowed", "visas"})
@EqualsAndHashCode(of = {"version"}, doNotUseGetters = true)
@ToString(of = {"version", "allowed", "visas"})
@Getter
public class AgreementRuleHistoryDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -4265473341596792743L;

    private Integer version;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime versionDate;

    private String versionUser;

    private boolean allowed;

    private List<AgreementRuleVisaDTO> visas;


    public static AgreementRuleHistoryDTO build(AgreementRuleDTO ruleDTO) {
        AgreementRuleHistoryDTO r = new AgreementRuleHistoryDTO();
        r.version = ruleDTO.getVersion();
        r.allowed = ruleDTO.isAllowed();
        r.visas = ruleDTO.getVisas();
        r.versionDate = ruleDTO.getUpdateDate();
        r.versionUser = ruleDTO.getUpdateUser();
        return r;
    }

}
