package com.practice.SpringDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class footballCoach implements Coach{

    public footballCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    public String getDailyWorkout(){
        return "The FootBall Coach";
    }
}
