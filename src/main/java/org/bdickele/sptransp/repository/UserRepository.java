package org.bdickele.sptransp.repository;

import org.bdickele.sptransp.dto.UserDTO;

/**
 * Created by bdickele
 */
public class UserRepository {

    public UserDTO findByUid(String uid) {
        return null;
    }

    //@Query("select u.uid from User u where uid like :uidPrefix%")
    //List<String> findUidsStartingWith(@Param("uidPrefix") String uidPrefix);
    //List<String> findUidsStartingWith(String uidPrefix);
}