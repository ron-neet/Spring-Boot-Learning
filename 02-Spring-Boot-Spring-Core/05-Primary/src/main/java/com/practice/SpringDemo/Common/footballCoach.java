package com.practice.SpringDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class footballCoach implements Coach{

    public String getDailyWorkout(){
        return "The FootBall Coach";
    }
}
