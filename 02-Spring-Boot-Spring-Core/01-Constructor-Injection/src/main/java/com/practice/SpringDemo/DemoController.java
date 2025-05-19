package com.practice.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

 //Private Field of Dependency
    private Coach myCoach;


    //Autowired tells spring to inject dependencies
    @Autowired
    public DemoController(Coach thecoach) {
        myCoach = thecoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyworkout(){
        return myCoach.getDailyWorkout();
    }



}
