package org.bdickele.sptransp.configuration;

import org.bdickele.sptransp.repository.GoodsRepository;
import org.bdickele.sptransp.repository.UserRepository;
import org.bdickele.sptransp.security.SpTranspUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Bertrand DICKELE
 */
@Configuration
@PropertySource("classpath:/application_it.properties")
public class IntegrationTestConfig {

    @Autowired
    Environment env;

    @Bean
    public GoodsRepository goodsRepository() {
        return new GoodsRepository();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository() {
        };
    }

    @Bean
    public SpTranspUserDetailsService userDetailsService() {
        return new SpTranspUserDetailsService();
    }

    @Bean
    public DatabaseInfo databaseInfo() {
        return new DatabaseInfo(env.getProperty("mongo.host"), env.getProperty("mongo.db.name"));
    }

    @Bean
    public PasswordEncoder devPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
