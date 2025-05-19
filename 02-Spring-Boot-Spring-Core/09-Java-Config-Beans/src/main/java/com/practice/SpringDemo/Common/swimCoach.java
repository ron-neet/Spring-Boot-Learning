package com.practice.SpringDemo.Common;

public class swimCoach implements Coach{

    public swimCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Swim Coach";
    }

}
