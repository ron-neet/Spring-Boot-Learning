package com.ronitCodes.demoAOP.DAO;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMethod(){

        System.out.println(getClass()+"Membership Account Added Successfully");

        return true;
    }

    @Override
    public void addMembershipAccount(){

        System.out.println(getClass()+"Membership Account Added Successfully Again");
    }

}
