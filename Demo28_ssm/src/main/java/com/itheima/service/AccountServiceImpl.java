package com.itheima.service;

import com.itheima.controller.BaseHandlerException;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl extends BaseHandlerException implements AccountService {
    @Autowired
    private UserMapper mapper;

    @Transactional
    public void tansfer(String inName, String outName, double money) {
        mapper.transferIn(inName,money);
        //int i = 1/0;
        mapper.transferOut(outName,money);
    }
}
