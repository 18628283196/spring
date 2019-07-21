package com.itheima.test;

import org.springframework.stereotype.Component;

@Component
public class PersonServlet {
    public void person(){
        System.out.println("Person被调用");
    }
}
