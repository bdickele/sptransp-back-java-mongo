package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.io.Serializable;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"code", "label"})
@EqualsAndHashCode(of = "code", doNotUseGetters = true)
@ToString(of = {"code", "label"}, doNotUseGetters = true)
@Getter
public class UserProfileDTO implements Serializable {

    private static final long serialVersionUID = 463285960555927346L;

    @MongoObjectId
    private String _id;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "label")
    private String label;

}
