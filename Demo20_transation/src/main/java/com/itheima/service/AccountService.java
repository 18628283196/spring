package com.itheima.service;

import org.springframework.stereotype.Service;


public interface AccountService {
    public void transfer(String inName,String outName,Double money);
}
