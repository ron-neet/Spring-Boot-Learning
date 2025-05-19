package com.practice.SpringDemo.Common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class cricketCoach implements Coach {

    public cricketCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Cricket Coach with Setter Injection";
    }
}
