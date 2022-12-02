package com.qf.account;

import com.qf.account.Account;

import java.util.List;

public interface AccountDao {
    public int insert(Account account);
    public int delete(String cardNo);
    public int update(Account account);
    public Account select(String cardNo);
    public List<Account> selectAll();
}
