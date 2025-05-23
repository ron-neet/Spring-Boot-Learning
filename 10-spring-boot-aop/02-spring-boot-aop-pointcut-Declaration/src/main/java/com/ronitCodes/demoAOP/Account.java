package com.ronitCodes.demoAOP;

public class Account {

    private String accountName;
    private String accountNumber;

    public Account() {
    }

    public Account(String accountName, String accountNumber){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
