package org.bdickele.sptransp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bertrand DICKELE
 */
@Configuration
public class PersistenceConfig {

    //TODO Piocher dans les properties ou dans les variables d'environnement

    @Bean
    public DatabaseInfo databaseInfo() {
        return new DatabaseInfo("sptransp", "127.0.0.1");
    }

    /*
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"org.bdickele.sptransp.domain"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(getHibernateProperties());

        return em;
    }

    // By adding that method, we add an adviser to any @Repository annotated bean
    // so that any platform-specific exception is transformed in a Spring unchecked exception
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "false");
        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return prop;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/sptransp_dev");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("sptranspdev");
        dataSource.setPassword("sptransp");
        return dataSource;
    }
    */
}
