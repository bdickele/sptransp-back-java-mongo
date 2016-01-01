package org.bdickele.sptransp.configuration;

import org.bdickele.sptransp.repository.*;
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
    public DestinationRepository destinationRepository() {
        return new DestinationRepository();
    }

    @Bean
    public DepartmentRepository departmentRepository() {
        return new DepartmentRepository();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepository();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepository();
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
