package com.practice.SpringDemo.Common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements Coach{

public String getDailyWorkout(){
    return "Tennis Coach";
}
}