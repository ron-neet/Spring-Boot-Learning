package com.practice.SpringDemo;

import org.springframework.stereotype.Component;

@Component
public class cricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice for Cricket Coach";
    }

}
