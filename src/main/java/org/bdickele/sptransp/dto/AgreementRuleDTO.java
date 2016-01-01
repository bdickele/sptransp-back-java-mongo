package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"destinationCode", "destinationName", "goodsCode", "goodsName", "reqAllowed",
    "creationDate", "creationUser", "updateDate", "updateUser", "agreementVisas"})
@EqualsAndHashCode(of = {"destinationCode", "goodsCode"}, doNotUseGetters = true)
@ToString(of = {"destinationCode", "goodsCode", "reqAllowed", "agreementVisas"})
@Getter
public class AgreementRuleDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -4265473341596792743L;

    @JsonProperty(value = "destinationCode")
    private String destinationCode;

    @JsonProperty(value = "destinationName")
    private String destinationName;

    @JsonProperty(value = "goodsCode", access = JsonProperty.Access.READ_ONLY)
    private String goodsCode;

    @JsonProperty(value = "goodsName")
    private String goodsName;

    @JsonProperty(value = "reqAllowed")
    private boolean reqAllowed;

    @JsonProperty(value = "agreementVisas")
    private List<AgreementRuleVisaDTO> agreementVisas;

    @JsonProperty(value = "creationDate")
    protected String creationDate;

    @JsonProperty(value = "creationUser")
    protected String creationUser;

    @JsonProperty(value = "updateDate")
    protected String updateDate;

    @JsonProperty(value = "updateUser")
    protected String updateUser;

}
