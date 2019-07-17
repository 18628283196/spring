package com.itheima.service;

import com.itheima.dao.AccountDaoImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Transactional可以防止类上，方法上，也可以防止接口上
 */
@Service
@Transactional//让该类中的所有事物都有事务管理
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDaoImpl accountDao;
    public void transfer(String inName, String outName, Double money) {
        accountDao.transferIn(inName,money);
        int i = 1/0;
        accountDao.transferout(outName,money);
    }
}
