package com.study;

import com.study.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
