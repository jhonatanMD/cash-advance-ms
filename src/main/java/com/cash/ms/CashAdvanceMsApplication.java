package com.cash.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class CashAdvanceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashAdvanceMsApplication.class, args);
	}

}
