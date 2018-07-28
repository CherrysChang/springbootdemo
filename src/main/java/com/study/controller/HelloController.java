package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 相关业务逻辑示例
 * Created by Qian on 2018/7/10 0010.
 */
@Controller
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }

    @ResponseBody
    @RequestMapping("/testValue")
    public String testValue(){
        return "Hello "+name;
    }

}
