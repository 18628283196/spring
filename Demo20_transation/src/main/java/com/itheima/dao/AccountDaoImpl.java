package com.itheima.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void transferIn(String inName, Double money) {
       jdbcTemplate.update("update account set money = money + ? where name = ?", money, inName);
    }

    public void transferout(String outName, Double money) {
        jdbcTemplate.update("update account set money = money - ? where name = ?", money, outName);
    }
}
