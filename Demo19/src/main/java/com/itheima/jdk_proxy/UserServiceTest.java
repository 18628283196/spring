package com.itheima.jdk_proxy;

import org.junit.Test;


public class UserServiceTest {
    @Test
   public void test(){
       //创建代理对象
       BeanProxyFactory factory = new BeanProxyFactory(new UserServiceImpl());
       //获取代理对象,调用BeanProxyFactory里面的getProxyBean方法
       UserService proxyBean = (UserService) factory.getProxyBean();
       //执行QueryUser方法
       proxyBean.queryUser();
   }

}
