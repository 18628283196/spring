package com.itheima.cglib_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.xml.ws.Service;
import java.lang.reflect.Method;

/**
 * 编写一个工厂
 */
public class PersonProxyFacory {
    //定义一个成员变量
    private PersonService personService;
    //给一个构造方法
    public PersonProxyFacory(PersonService personService) {
        this.personService = personService;
    }

    //编写一个创建代理对象的方法
    public Object getProxyBean(){
        //cglib的核心对象
        Enhancer enhancer = new Enhancer();
        //设置supper字节码对象
        enhancer.setSuperclass(personService.getClass());
        //设置回调函数
        //传递的参数是方法拦截器：可以对方法进行拦截，拦截之后可以增强
        //通过代理对象调用原来的方法的时候，就会先拦截，执行拦截方法
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o   代理对象
             * @param method  方法对象  就是personService里的addUser方法
             * @param objects   addUser方法里的参数
             * @param methodProxy   方法代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //调用原来的方法
                method.invoke(personService,objects);
                //模拟增强
                System.out.println("添加日志完成。。");
                return null;
            }
        });
        //返回代理对象
        return enhancer.create();
    }
}
