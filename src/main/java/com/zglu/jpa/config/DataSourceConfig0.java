package com.zglu.jpa.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

/**
 * @author zglu
 */
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.zglu.jpa.db0"},
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean0",
        transactionManagerRef = "platformTransactionManager0")
@EnableTransactionManagement
public class DataSourceConfig0 {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource0")
    public DataSourceProperties dataSourceProperties0() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource0() {
        return dataSourceProperties0().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource0.jpa")
    public Properties jpaProperties0() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        return jpaProperties;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean0() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource0());
        factoryBean.setJpaProperties(jpaProperties0());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com.zglu.jpa.db0");
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager0() {
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean0().getObject()));
    }

}
