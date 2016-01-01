package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.bdickele.sptransp.domain.Seniority;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;
import org.bdickele.sptransp.exception.SpTranspBizError;
import org.bdickele.sptransp.exception.SpTranspTechError;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"destinationCode", "goodsCode", "allowed",
    "creationDate", "creationUser", "updateDate", "updateUser", "agreementVisas"})
@EqualsAndHashCode(of = {"destinationCode", "goodsCode"}, doNotUseGetters = true)
@ToString(of = {"destinationCode", "goodsCode", "allowed", "agreementVisas"})
@Getter
public class AgreementRuleDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -4265473341596792743L;

    @MongoObjectId
    private String _id;

    private Long id;

    private Integer version;

    private String destinationCode;

    private String goodsCode;

    private boolean allowed;

    private List<AgreementRuleVisaDTO> agreementVisas;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    private String creationUser;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime updateDate;

    private String updateUser;

    private List<AgreementRuleHistoryDTO> history = new ArrayList<>();

    /**
     * Build method for a new AgreementRule
     * @param id
     * @param destination
     * @param goods
     * @param allowed
     * @param creationUserUid
     * @return
     */
    public static AgreementRuleDTO build(Long id, DestinationDTO destination, GoodsDTO goods,
                                      boolean allowed, String creationUserUid) {
        AgreementRuleDTO r = new AgreementRuleDTO();
        r.id = id;
        r.version = 1;
        r.destinationCode = destination.getCode();
        r.goodsCode = goods.getCode();
        r.allowed = allowed;

        r.agreementVisas = new ArrayList<>();

        LocalDateTime date = LocalDateTime.now();
        r.creationDate = date;
        r.updateDate = date;

        r.creationUser = creationUserUid;
        r.updateUser = creationUserUid;

        r.checkValues();

        return r;
    }

    /**
     *
     * @param allowed
     * @param newVisas New list of visas (will replace the current list of visas) in the right order. Their rank
     *              will be recomputed
     * @param updateUser
     */
    public void update(boolean allowed, List<Pair<DepartmentDTO, Seniority>> newVisas, String updateUser) {
        this.allowed = allowed;
        this.updateUser = updateUser;
        this.updateDate = LocalDateTime.now();
        version = version + 1;

        this.agreementVisas.clear();
        newVisas.forEach(p -> addVisa(p.getLeft(), p.getRight()));

        checkValues();
        // This rule is not checked in "build" method
        checkAtLeastOneVisa();

        getHistory().add(AgreementRuleHistoryDTO.build(this));
    }

    /**
     * Convenient method to add a visa (at the end of the current list of visas)
     * @param department
     * @param seniority
     * @return
     */
    public AgreementRuleDTO addVisa(DepartmentDTO department, Seniority seniority) {
        agreementVisas.add(AgreementRuleVisaDTO.build(agreementVisas.size(), department, seniority));
        return this;
    }

    public void checkValues() {
        checkDestination();
        checkGoods();
        checkCreationInfo();
        checkUpdateInfo();
    }

    public void checkDestination() {
        if (destinationCode==null) throw SpTranspBizError.AGR_RULE_MISSING_VALUE.exception("destination");
    }

    public void checkGoods() {
        if (goodsCode==null) throw SpTranspBizError.AGR_RULE_MISSING_VALUE.exception("goods");
    }

    public void checkCreationInfo() {
        if (StringUtils.isEmpty(creationUser)) throw SpTranspTechError.MISSING_INFORMATION.exception("creation user");
        if (creationDate==null) throw SpTranspTechError.MISSING_INFORMATION.exception("creation date");
    }

    public void checkUpdateInfo() {
        if (StringUtils.isEmpty(updateUser)) throw SpTranspTechError.MISSING_INFORMATION.exception("update user");
        if (updateDate==null) throw SpTranspTechError.MISSING_INFORMATION.exception("update date");
    }

    public void checkAtLeastOneVisa() {
        if (allowed && (agreementVisas==null || agreementVisas.isEmpty())) {
            throw SpTranspTechError.MISSING_INFORMATION.exception("required visas");
        }
    }
}
