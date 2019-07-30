package com.itheima;

import java.sql.SQLException;

public interface AccountService {
    public void transfer(String inName,String outName,double money) throws SQLException;
}
