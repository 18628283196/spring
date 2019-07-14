package com.itheima.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public void tansfer(String inName,String outName,double money);

}
