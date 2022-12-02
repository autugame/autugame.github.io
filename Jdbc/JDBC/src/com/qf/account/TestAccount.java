package com.qf.account;

public class TestAccount {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.transfer("6002", "1234", "6003", 1000);
    }
}
