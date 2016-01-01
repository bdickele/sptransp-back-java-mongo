package org.bdickele.sptransp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by Bertrand DICKELE
 */
@EqualsAndHashCode(of = "_id", doNotUseGetters = true)
@Getter
public class SequenceDTO {

    public String _id;

    public Long seq;
}
