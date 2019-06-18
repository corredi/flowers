package com.accenture.flowershop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
/*@ComponentScan({"com.accenture.flowershop.be.access",
        "com.accenture.flowershop.be.business",
        "com.accenture.flowershop.fe.REST",
        "com.accenture.flowershop.fe.SOAP",})*/
@EnableTransactionManagement
@EnableJpaRepositories("com.accenture.flowershop.be.access.repositories")
@ImportResource("src/main/webapp/WEB-INF/application-context.xml")
public class DBConfig {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "org.h2.Driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:h2:~/flowers";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "test";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "test";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.accenture.flowershop.be.entity";


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
        dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
        dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        //entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        //entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);

        return jpaVendorAdapter;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
