package org.bdickele.sptransp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Bertrand DICKELE
 */
@Configuration
public class PersistenceConfig {

    @Autowired
    Environment env;

    @Bean
    public DatabaseInfo databaseInfo() {
        return new DatabaseInfo(env.getProperty("mongo.host"), env.getProperty("mongo.db.name"));
    }
}
