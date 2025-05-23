package com.ronitCodes.demoAOP.DAO;

import com.ronitCodes.demoAOP.Account;

import java.util.List;

public interface AccountDAO {

void addAccount(Account theAccount, boolean vipFlag);

boolean addSillyMethod();

    public String getAccountName();

    public void setAccountName(String accountName);

    public String getAccountNumber();

    public void setAccountNumber(String accountNumber);

    List<Account> findAccount();

    List<Account> findAccount(boolean flag);

}
