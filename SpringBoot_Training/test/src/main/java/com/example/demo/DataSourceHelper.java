package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
public class DataSourceHelper {
	//@Bean
	public DataSource dataSource() {
		DriverManagerDataSource obj = new DriverManagerDataSource();
		obj.setDriverClassName("com.mysql.cj.jdbc.Driver");
        obj.setUrl("jdbc:mysql://192.168.1.121:3306/test");
        obj.setUsername("root");
        obj.setPassword("root");
		return obj;
		
	}
	

}
