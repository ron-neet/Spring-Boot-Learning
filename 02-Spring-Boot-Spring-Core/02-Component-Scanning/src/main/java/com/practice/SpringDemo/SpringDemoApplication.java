package com.practice.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TO Scan the Other Folder Package
 /* @SpringBootApplication(
		scanBasePackages = {
				"com.practice.SpringDemo",
				"com.practice.util"
		}
)*/

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
