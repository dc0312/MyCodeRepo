package com.dc.restfulwebservices.springboot.helloWorld.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldBean {
    private String message;

   /* public HelloWorldBean(String message) {
        this.message = message;
    }

    *//*public String getMessage() {
        return message;
    }*//*

    public void setMessage(String message) {
        this.message = message;
    }*/

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
