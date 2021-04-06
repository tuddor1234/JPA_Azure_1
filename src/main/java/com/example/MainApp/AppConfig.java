//package com.example.MainApp;
//
//
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableJpaRepositories
//@PropertySource("application.properties")
//@EnableTransactionManagement
//public class AppConfig {
//
//    @Autowired
//    private Environment environment;
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        var props = environment.getProperties();
//        dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(props.getProperty("jdbc.url"));
////        dataSource.setUsername(props.getProperty("jdbc.user"));
//        dataSource.setPassword(props.getProperty("jdbc.pass"));
//
//        return dataSource;
//    }
//}
