package com.practice.SpringDemo.Common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//For the Scope of Singleton Prototype etc
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class footballCoach implements Coach{

    public footballCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }

    public String getDailyWorkout(){
        return "The FootBall Coach";
    }
}
