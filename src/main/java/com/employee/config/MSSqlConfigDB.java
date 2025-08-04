package com.employee.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.employee.details.repo"},
        entityManagerFactoryRef = "dbEntityManager",
        transactionManagerRef = "dbTransactionManager")
public class MSSqlConfigDB {

    @Primary
    @Bean(name = "mssqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource") // Not .url — this should match your application.properties
    public DataSource mssqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dbEntityManager")
    public LocalContainerEntityManagerFactoryBean dbEntityManager(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mssqlDataSource())
                .packages("com.employee.details.entity")
                .persistenceUnit("Employee")
                .build();
    }

    @Primary
    @Bean(name = "dbTransactionManager")
    public PlatformTransactionManager dbTransactionManager(
            @Qualifier("dbEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
