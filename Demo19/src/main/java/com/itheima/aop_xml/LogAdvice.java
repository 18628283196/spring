package com.itheima.aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;

//这是一个增强方法
public class LogAdvice {
    public void logService(){
        System.out.println("添加日志完成。。");
    }
    //前置增强
    public void beforeAdvice(){
        System.out.println("前置通知增强的方法。。。记录日志");
    }

    //后置增强
    public void afterAdvice(){
        System.out.println("后置通知增强的方法。。。记录日志");
    }

    //环绕增强
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前增强的方法。。。记录日志");
        proceedingJoinPoint.proceed();
        System.out.println("环绕后通知增强的方法。。。记录日志");
    }

    //异常增强通知
    public void throwAbleAdvice(){
        System.out.println("异常通知增强的方法。。。记录日志");
    }

    //最终增强通知
    public void lastAdvice(){
        System.out.println("最终通知增强的方法。。。记录日志");
    }
}
