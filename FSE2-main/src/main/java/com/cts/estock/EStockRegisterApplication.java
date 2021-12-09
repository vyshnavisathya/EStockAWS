package com.cts.estock;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EStockRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EStockRegisterApplication.class, args);
	}

}
