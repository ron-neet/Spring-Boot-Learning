package com.SpringClass.RestServices.entity;

public class Student {
    private String FirstName;
    private String LastName;

    public Student(String FirstName, String LastName){
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    // GETTER METHOD
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    //SETTER METHOD
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
}
