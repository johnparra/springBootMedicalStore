package com.pruebajp.johnparra.configuration;

import com.pruebajp.johnparra.bean.MyBeanWitProperties;
import com.pruebajp.johnparra.bean.MyBeanWithPropertiesImplemented;
import com.pruebajp.johnparra.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWitProperties function(){
        return new MyBeanWithPropertiesImplemented(name, lastName);
    }

    /**
     * #spring.datasource.url=jdbc:h2:mem:medicalStore
     * #spring.datasource.driverClassName=org.h2.Driver
     * #spring.datasource.username=sa
     * #spring.datasource.password=
     * #spring.jpa.database-platform=org.hibernate.dialect.h2Dialect
     */
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:medicalStore");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
