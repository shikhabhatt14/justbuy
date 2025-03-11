package com.app.justbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//(basePackageClasses = DeviceDataRepository.class)
public class JustbuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustbuyApplication.class, args);
	}

}
