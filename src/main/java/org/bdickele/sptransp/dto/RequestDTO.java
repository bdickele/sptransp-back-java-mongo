package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Bertrand DICKELE
 */
@EqualsAndHashCode(of = "reference", doNotUseGetters = true)
@ToString(of = {"reference", "customerUid", "departureCode", "arrivalCode", "goodsCode", "creationDate"}, doNotUseGetters = true)
@Getter
public class RequestDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -3314219597285942969L;

    @MongoObjectId
    private String _id;

    private Long id;

    private Integer version;

    private String reference;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    //private Long creationDateForComparison;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    private LocalDateTime updateDate;

    //private Long updateDateForComparison;

    private String customerUid;

    private String customerName;

    private String goodsCode;

    private String goodsName;

    private String departureCode;

    private String departureName;

    private String arrivalCode;

    private String arrivalName;

    private String overallStatusCode;

    private String overallStatusLabel;

    private String agreementStatusCode;

    private String agreementStatusLabel;

    private Long ruleId;

    private Integer ruleVersion;

    private String cancellationComment;

    private Integer nextAgreementVisaRank;

    private List<RequestAgreementVisaDTO> appliedAgreementVisas;

    private List<AgreementRuleVisaDTO> requiredAgreementVisas;

}
