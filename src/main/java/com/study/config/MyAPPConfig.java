package com.study.config;

import com.study.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义一个配置类
 *  @Configuration： 指明当前类是一个配置类； 就是来替代之前的 Spring配置文件
 *  以前在 Spring配置文件中是用<bean><bean/>标签添加组件。
 *  现在在配置类中 使用 @Bean 注解。
 * Created by Qian on 2018/7/28 0028.
 */
@Configuration
public class MyAPPConfig {
    /**
     * 将方法的返回值添加到容器中；容器中这个组件默认的 id 就是方法名
     */
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
