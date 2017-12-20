package com.poilt;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.poilt.mapper.*Mapper")
public class Application extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	public static void main(String[] args) {
		logger.info("springBoot 启动了");
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
