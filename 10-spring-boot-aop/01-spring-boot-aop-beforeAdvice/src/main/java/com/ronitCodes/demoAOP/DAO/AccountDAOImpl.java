package com.ronitCodes.demoAOP.DAO;


import com.ronitCodes.demoAOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag){

        System.out.println(getClass()+"Account Added Successfully");
    }

    @Override
    public boolean addSillyMethod(){

        System.out.println(getClass()+"Silly Method Added Successfully");
        return true;
    }

}
