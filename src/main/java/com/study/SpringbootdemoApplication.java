package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序，说明这是一个Spring Boot 应用
 */
@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		//启动Spring应用
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
