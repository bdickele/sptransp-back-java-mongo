package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.bdickele.sptransp.dto.converter.LocalDateTimeConverter;
import org.bdickele.sptransp.exception.SpTranspTechError;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.time.LocalDateTime;

/**
 * Created by Bertrand DICKELE
 */
@EqualsAndHashCode(of = "uid", doNotUseGetters = true)
@Getter
public abstract class UserDTO implements SpaceTranspDTO {

    @MongoObjectId
    protected String _id;

    protected Long id;

    protected Integer version;

    protected String uid;

    protected String password;

    protected String userType;

    protected String profileCode;

    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    protected LocalDateTime creationDate;

    protected String creationUser;
    @JsonSerialize(using = LocalDateTimeConverter.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeConverter.LocalDateTimeDeserializer.class)
    protected LocalDateTime updateDate;

    protected String updateUser;

    public void checkCreationInfo() {
        if (StringUtils.isEmpty(creationUser)) throw SpTranspTechError.MISSING_INFORMATION.exception("creation user");
        if (creationDate==null) throw SpTranspTechError.MISSING_INFORMATION.exception("creation date");
    }

    public void checkUpdateInfo() {
        if (StringUtils.isEmpty(updateUser)) throw SpTranspTechError.MISSING_INFORMATION.exception("update user");
        if (updateDate==null) throw SpTranspTechError.MISSING_INFORMATION.exception("update date");
    }
}
