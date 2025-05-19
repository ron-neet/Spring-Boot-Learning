package com.practice.SpringDemo.Common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class footballCoach implements Coach{

    public footballCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    public String getDailyWorkout(){
        return "The FootBall Coach";
    }
}
