package com.practice.SpringDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class cricketCoach implements Coach {

    public cricketCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Cricket Coach with Setter Injection";
    }
}
