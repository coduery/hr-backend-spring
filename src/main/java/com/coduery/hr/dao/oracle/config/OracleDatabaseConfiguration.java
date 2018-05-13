package com.coduery.hr.dao.oracle.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableEncryptableProperties
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "oracleEntityManagerFactory",
        transactionManagerRef = "oracleTransactionManager",
        basePackages = { "com.coduery.hr.dao.oracle.repo" }
)
// public class OracleDatabaseConfiguration {  // Setup for Spring Boot 1.5.10
public class OracleDatabaseConfiguration extends HikariConfig {  // Setup for Spring Boot 2.0.1

    @Bean(name = "oracleDataSource")
    // @ConfigurationProperties(prefix = "oracle.datasource")  // Setup for Spring Boot 1.5.10
    @ConfigurationProperties(prefix = "oracle.datasource.hikari")  // Setup for Spring Boot 2.0.1
    public DataSource dataSource() {
        //  return DataSourceBuilder.create().build();  // Setup for Spring Boot 1.5.10
        return new HikariDataSource();  // Setup for Spring Boot 2.0.1
    }

    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier ("oracleDataSource") DataSource oracleDataSource) {
        return builder.dataSource(oracleDataSource).packages("com.coduery.hr.dao.oracle.model").persistenceUnit("oracle").build();
    }

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier ("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
