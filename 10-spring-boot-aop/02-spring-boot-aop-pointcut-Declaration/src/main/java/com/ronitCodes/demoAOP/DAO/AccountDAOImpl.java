package com.ronitCodes.demoAOP.DAO;


import com.ronitCodes.demoAOP.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String accountName;
    private String accountNumber;

    @Override
    public List<Account> findAccount(boolean flag){

        // For academic purpose Stimulate an exception

        if(flag){
            throw new RuntimeException("Exception Stimulated");
        }
        List<Account> myAccount = new ArrayList<>();

        // Create a sample Account
        Account tempAccount = new Account("Codez", "178122121");
        Account tempAccount1 = new Account("HiCodez", "1547811");
        Account tempAccount2 = new Account("RECodez", "15441");

        // Add them to our Account List
        myAccount.add(tempAccount);
        myAccount.add(tempAccount1);
        myAccount.add(tempAccount2);

        return myAccount;

    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass()+"Account Added Successfully");
    }

    @Override
    public boolean addSillyMethod(){

        System.out.println(getClass()+"Silly Method Added Successfully");
        return true;
    }

    public String getAccountName() {
        System.out.println(getClass()+"Silly Method Added Successfully getAccountName()");
        return accountName;
    }

    public void setAccountName(String accountName) {
        System.out.println(getClass()+"Method Added Successfully setAccountName()");
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        System.out.println(getClass()+"Silly Method Added Successfully getAccountNumber() ");
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        System.out.println(getClass()+"Method Added Successfully setAccountNumber()");
        this.accountNumber = accountNumber;
    }

    @Override
    public List<Account> findAccount(){

//        List<Account> myAccount = new ArrayList<>();
//
//        // Create a sample Account
//        Account tempAccount = new Account("Codez", "178122121");
//        Account tempAccount1 = new Account("HiCodez", "1547811");
//        Account tempAccount2 = new Account("RECodez", "15441");
//
//        // Add them to our Account List
//        myAccount.add(tempAccount);
//        myAccount.add(tempAccount1);
//        myAccount.add(tempAccount2);
//
//        return myAccount;

        return findAccount(false);
    }
}
