package org.bdickele.sptransp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bdickele.sptransp.domain.UserProfile;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bertrand DICKELE
 */
@JsonPropertyOrder({"code", "name"})
@EqualsAndHashCode(of = "code", doNotUseGetters = true)
@ToString(of = {"code", "name"}, doNotUseGetters = true)
@Getter
public class UserProfileDTO implements Serializable {

    private static final long serialVersionUID = 463285960555927346L;

    @MongoObjectId
    private String _id;

    private String code;

    private String name;

    public static UserProfileDTO build(UserProfile profile) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.code = profile.getCode();
        dto.name = profile.getLabel();
        return dto;
    }

    public static List<UserProfileDTO> build(List<UserProfile> profiles) {
        return profiles.stream()
                .map(UserProfileDTO::build)
                .collect(Collectors.toList());
    }
}
