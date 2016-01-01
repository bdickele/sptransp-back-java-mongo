package org.bdickele.sptransp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Destination object returned by web services
 * Created by Bertrand DICKELE
 */
@EqualsAndHashCode(of = "code", doNotUseGetters = true)
@ToString(of = {"code", "name"}, doNotUseGetters = true)
@Getter
public class DestinationDTO implements SpaceTranspDTO, Serializable {

    private static final long serialVersionUID = -4111120841917837925L;

    private String code;

    private String name;

    private String comment;


}
