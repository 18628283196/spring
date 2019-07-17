package com.itheima.dao;

import org.springframework.stereotype.Repository;


public interface AccountDao {
    //转入
    public void transferIn(String inName,Double money);

    //转出
    public void transferout(String outName,Double money);
}
