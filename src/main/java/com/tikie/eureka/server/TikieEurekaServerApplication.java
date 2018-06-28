package com.tikie.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TikieEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TikieEurekaServerApplication.class, args);
	}
}
