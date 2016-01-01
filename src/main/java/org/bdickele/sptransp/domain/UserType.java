package org.bdickele.sptransp.domain;

/**
 * Created by bdickele
 */
public enum UserType {

    EMPLOYEE("E"),

    CUSTOMER("C");

    private String code;

    private UserType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
