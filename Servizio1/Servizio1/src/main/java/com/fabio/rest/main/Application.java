package com.fabio.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages= {"com.fabio.rest.controller","com.fabio.res.servizio"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
