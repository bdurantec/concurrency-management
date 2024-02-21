package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
public class DataSourceConfig {
	
	private final static String JDBC = "jdbc";
	private final static String SLASH = "/";
	private final static String DOUBLE_DOT = ":";

//	@Value("${database.provider}")
//	private String provider;
//	@Value("${database.url}")
//	private String url;
//	@Value("${database.port}")
//	private String port;
//	@Value("${database.user-name}")
//	private String userName;
//	@Value("${database.password}")
//	private String password;
//	@Value("${database.name}")
//	private String dataBaseName;
	
	@Bean
	public DataSource dataSource() {
		var dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://localhost:5432/rinha_backend");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("12345");
		
		return dataSourceBuilder.build();
	}

//	private String buildDataBaseUrl() {
//		return JDBC +
//				       DOUBLE_DOT +
//				       provider +
//				       DOUBLE_DOT +
//				       SLASH +
//				       SLASH +
//				       url +
//				       DOUBLE_DOT +
//				       port +
//				       SLASH +
//				       dataBaseName;
//	}
}
