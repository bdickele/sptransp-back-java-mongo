package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"code", "name"})
@EqualsAndHashCode(of = "code", doNotUseGetters = true)
@ToString(of = {"code", "name"}, doNotUseGetters = true)
@Getter
public class DepartmentDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = 6129408205740913875L;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "name")
    private String name;


    public static DepartmentDTO buidl(String code, String name) {
        DepartmentDTO d = new DepartmentDTO();
        d.name = name;
        d.code = code;
        return d;
    }
}
