package com.study.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件（比如该类上使用的@Component注解，将其注册为bean），才能使用容器提供的 @ConfigurationProperties功能；
 *
 * 注意：@ConfigurationProperties 和 @Value注解的区别
 * Created by Qian on 2018/7/12 0012.
 */
@Component
@ConfigurationProperties(prefix = "person")
//③、支持JSR303校验。JSR303校验的使用：首先需要加上@Validated注解，其次再在对应属性上加上对应校验注解@NotNull、@Min(value)、@Past、@Pattern(regex=,flag=)等
@Validated
public class Person {
    @NotNull //JSR303校验注解@NotNull：非空
    private String lastName;//①、松散语法绑定：配置文件对应属性可以写成lastName、last_name、last-name
    private Integer age;//②、配置文件中如果是SpEL的写法，如age=#{10*2}，则会映射失败
    private Boolean boss;
    @Past//JSR303校验注解@Past：必须是一个过去的时间
    private Date birth;

    private Map<String,Object> maps;//支持复杂类型封装
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
