package com.spring.security;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.spring.security")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
	public DataSource SecurityDataSource() {
		ComboPooledDataSource securitydataSource= new ComboPooledDataSource();
		try {
			securitydataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(">>jdbcUrl:"+env.getProperty("jdbc.url"));
		logger.info(">>jdbcUser:"+env.getProperty("jdbc.user"));
		securitydataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securitydataSource.setUser(env.getProperty("jdbc.user"));
		securitydataSource.setPassword(env.getProperty("jdbc.password"));
		securitydataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securitydataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securitydataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securitydataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securitydataSource;
	}
	private int getIntProperty(String propName) {
		String propval=env.getProperty(propName);
		int parseInt = Integer.parseInt(propval);
		return parseInt;
	}
	
}
