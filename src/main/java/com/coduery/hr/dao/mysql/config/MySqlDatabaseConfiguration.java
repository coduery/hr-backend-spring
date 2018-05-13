package com.coduery.hr.dao.mysql.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "entityManagerFactory",
        basePackages = { "com.coduery.hr.dao.mysql.repo" }
)
// public class MySqlDatabaseConfiguration { // Setup for Spring Boot 1.5.10
public class MySqlDatabaseConfiguration extends HikariConfig { // Setup for Spring Boot 2.0.1

    @Primary
    @Bean(name = "dataSource")
    // @ConfigurationProperties(prefix = "spring.datasource")  // Setup for Spring Boot 1.5.10
    @ConfigurationProperties(prefix = "spring.datasource.hikari")  // Setup for Spring Boot 2.0.1
    public DataSource dataSource() {
        // return DataSourceBuilder.create().build();  // Setup for Spring Boot 1.5.10
        return new HikariDataSource();  // Setup for Spring Boot 2.0.1
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier ("dataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.coduery.hr.dao.mysql.model").persistenceUnit("mysql").build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier ("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
