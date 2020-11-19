package com.fabio.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages= {"com.fabio.rest.controller","com.fabio.rest.servizi"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
