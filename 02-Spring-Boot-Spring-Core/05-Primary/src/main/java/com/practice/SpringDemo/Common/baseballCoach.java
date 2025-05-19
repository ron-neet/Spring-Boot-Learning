package com.practice.SpringDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class baseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "BAse Ball Coach";
    }
}
