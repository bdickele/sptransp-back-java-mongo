package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Goods object returned by web services
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"code", "name"})
@EqualsAndHashCode(of = "code", doNotUseGetters = true)
@ToString(of = {"code", "name"}, doNotUseGetters = true)
@Getter
public class GoodsDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -7786611351850896451L;

    private String code;

    private String name;


}
