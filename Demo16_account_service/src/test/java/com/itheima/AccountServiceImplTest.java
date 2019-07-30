package com.itheima;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AccountServiceImplTest {

    @org.junit.Test
    public void transfer() throws SQLException {
        AccountServiceImpl as = new AccountServiceImpl();
        as.transfer("jack","rose",222);
    }
}