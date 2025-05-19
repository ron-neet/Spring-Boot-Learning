package com.practice.SpringDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements Coach{


    public tennisCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

public String getDailyWorkout(){
    return "Tennis Coach";
}
}