package com.dc.restfulwebservices.springboot.helloWorld.controller;

import com.dc.restfulwebservices.springboot.helloWorld.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleContextResolver;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello-world")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Word!!");
    }

    @GetMapping("/path/{name}")
    public HelloWorldBean pathHello(@PathVariable("name") String s, @RequestParam("name2") String id){
        return new HelloWorldBean(String.format("Hello World, %s. Your Id is %s", s,id));
    }

    @GetMapping("/foos")
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

    @GetMapping("/hello-international")
    public String getInternationalHello(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
 }
