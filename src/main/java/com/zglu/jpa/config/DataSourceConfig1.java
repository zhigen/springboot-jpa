package com.zglu.jpa.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = {"com.zglu.jpa.db1"},
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean1",
        transactionManagerRef = "platformTransactionManager1")
@EnableTransactionManagement
public class DataSourceConfig1 {

    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties dataSourceProperties1() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource1() {
        return dataSourceProperties1().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource1.jpa")
    public Properties jpaProperties1() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        return jpaProperties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean1() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource1());
        factoryBean.setJpaProperties(jpaProperties1());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com.zglu.jpa.db1");
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager1() {
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean1().getObject()));
    }

}
