package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 来标注一个主程序，说明这是一个Spring Boot 应用
 * 标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就应该运行这个类的main方法来启动SpringBoot应用。
 */
//@ImportResource(value = {"classpath:beans.xml"})//导入Spring的配置文件让其生效
@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		//启动Spring应用
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
