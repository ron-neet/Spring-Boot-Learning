package com.practice.SpringDemo.Common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class baseballCoach implements Coach{

    public baseballCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "BAse Ball Coach";
    }
}
