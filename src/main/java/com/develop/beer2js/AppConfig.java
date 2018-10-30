package com.develop.beer2js;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Configuration
@ComponentScan("com.develop")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE");
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("uqjusabsufocyc")
                .password("247ac26865169cadccd71d4c122ac0ad0cc9ebfd059b36614f412fcd91d650b1")
                .url("jdbc:postgres://uqjusabsufocyc:247ac26865169cadccd71d4c122ac0ad0cc9ebfd059b36614f412fcd91d650b1@ec2-54-225-241-25.compute-1.amazonaws.com:5432/de8bubeq18429i")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
    /*
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("springuser")
                .password("ThePassword")
                .url("jdbc:postgresql://localhost:5432/db_beer")
                .driverClassName("org.postgresql.Driver")
                .build();
    }*/
}
