package com.study.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 使用 @Value注解 获取 配置文件中 属性的值
 *
 * 注意：@ConfigurationProperties 和 @Value注解的区别
 *      - 功能上 @ConfigurationProperties 可以批量注入配置文件中的属性，@Value注解 只能一个个去指定属性
 *      - @ConfigurationProperties 支持【松散语法绑定】，@Value注解不支持，属性名字必须一致
 *          松散语法绑定：即配置文件中的属性使用驼峰式 firstName、或大写采用—和_：first-name，first_name，都能与@ConfigurationProperties配置的Bean属性（驼峰式xxYyy）一一映射
*       - @ConfigurationProperties 不支持 SpEL，@Value 支持
 *      - @ConfigurationProperties 支持JSR303数据校验，@Value 不支持
 *      - @ConfigurationProperties 支持复杂类型封装，@Value 不支持，它只能取出基本类型的数据
 *
 * 使用：配置文件yml还是properties上面两种方式都能获取到值
 *      - 只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用 @Value；
 *      - 专门编写了一个javaBean来和配置文件进行映射，我们就直接使用 @ConfigurationProperties；
 * Created by Qian on 2018/7/28 0028.
 */
@Component
public class Person1 {
    /**
     * @Value注解 类似于下面方式中的value属性
     * <bean class="Person">
     *      <property name="lastName" value="① 字面量/② ${key}从环境变量、配置文件中获取值/③ #{SpEL}"></property>
     * <bean/>
     */
    @Value("${person.last-name}")//指定配置文件的属性（${key}中key必须和配置文件中的属性名一致）
    private String lastName;
    //@Value("${person.age}")
    @Value("#{10*2}")//支持Spring表达式语言SpEL
    private Integer age;
    @Value("true")//字面量
    private Boolean boss;
    @Value("${person.birth}")
    private Date birth;

    //@Value("${person.maps}")//不支持复杂类型封装，启动会报错
    private Map<String,Object> maps;
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
