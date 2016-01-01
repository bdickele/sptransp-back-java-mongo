package org.bdickele.sptransp.configuration;

import lombok.Getter;

/**
 * Created by Bertrand DICKELE
 */
@Getter
public class DatabaseInfo {

    private final String dbName;

    private final String host;


    public DatabaseInfo(String host, String dbName) {
        this.host = host;
        this.dbName = dbName;
    }
}
