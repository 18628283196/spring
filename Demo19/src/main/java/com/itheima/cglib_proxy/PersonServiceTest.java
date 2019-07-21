package com.itheima.cglib_proxy;

import org.junit.Test;

public class PersonServiceTest {
    @Test
    public void test(){
        //创建工厂对象
        PersonProxyFacory facory = new PersonProxyFacory(new PersonService());

        //调用工厂方法获取代理对象
        PersonService proxyBean = (PersonService) facory.getProxyBean();

        //通过代理对象调用添加用户的方法
        proxyBean.addUser("老王");
    }
}
