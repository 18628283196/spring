package com.itheima.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建工厂代理对象
 */
public class BeanProxyFactory {
    //声明成员变量
    private UserServiceImpl userServletImpl;

    public BeanProxyFactory(UserServiceImpl userServletImpl) {
        this.userServletImpl = userServletImpl;
    }
    //创建获取代理的对象的方法
    public Object getProxyBean(){
        /**
         * 传递三个参数
         * 1. loader类加载器  传递参数是当前子类的类加载器用来加载代理对象
         * 2.Class<?>[] interfaces,当前类的所有接口的字节码对象数组，所有接口的方法要一致
         * InvocationHandler h  执行句柄
         */
        return  Proxy.newProxyInstance(
                userServletImpl.getClass().getClassLoader(),
                userServletImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理对象
                     * @param method 具体要执行的方法
                     * @param args 实际参数的数组
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //原始方法进行执行
                        method.invoke(userServletImpl);
                        //模拟添加日志（增强功能）
                        System.out.println("日志添加完成");
                        return null;
                    }
                });

    }
}
