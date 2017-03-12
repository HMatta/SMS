package com.bangsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bangsms.controllers.EmployeeController;


@SpringBootApplication(scanBasePackages={"com.bangsms"})
public class BangSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BangSmsApplication.class, args);
	}
}
