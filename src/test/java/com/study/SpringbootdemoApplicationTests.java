package com.study;

import com.study.bean.Person;
import com.study.bean.Person1;
import com.study.bean.Person2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot 单元测试类：
 *
 * 可以在测试期间可以很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)//② 单元测试使用SpringRunner驱动器来跑，而不是原来的JUnit
@SpringBootTest//① 标识这是SpringBoot的单元测试
public class SpringbootdemoApplicationTests {

	@Autowired
	Person person;
	@Autowired
	Person1 person1;
	@Autowired
	Person2 person2;

	@Autowired
	ApplicationContext ioc;//注入IOC容器

	/**
	 * 测试 @ConfigurationProperties注解
	 */
	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	/**
	 * 测试 @Value注解
	 */
	@Test
	public void contextLoads1() {
		System.out.println(person1);
	}

	/**
	 * 测试 @PropertySource 注解
	 */
	@Test
	public void contextLoads2() {
		System.out.println(person2);
	}

	/**
	 * 该项目中加入了 我们自己编写的Spring的配置文件 beans.xml
	 * 测试 ioc容器 有没有 helloService这个Bean
	 * 如果不进行配置，是不能进行自动识别。--------测试运行：b为 false
	 * 想要Spring的配置文件生效，加载进来，需要使用 @ImportResource标注在一个配置类上
	 * 此示例我们将 @ImportResource 标注在主配置类上 SpringbootdemoApplication。--------测试运行：b为true
	 */
	@Test
	public void testHelloService(){
		boolean b = ioc.containsBean("helloService");//containsBean方法是否包含指定bean
		System.out.println(b);//默认false，不能自动识别Spring配置文件
	}

}
