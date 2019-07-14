package com.itheima.controller;

import com.itheima.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccoutController extends BaseHandlerException {
    @Autowired
    private AccountService service;
    @RequestMapping("transfer.action")
    public String tansfer(String inName,String outName,double money ){
        service.tansfer(inName,outName,money);
        return "success";
    }
}
