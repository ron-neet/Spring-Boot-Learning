package com.practice.SpringDemo.Rest;

import com.practice.SpringDemo.Common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

 //Private Field of Dependency
    private Coach myCoach;


    @Autowired
  public DemoController(@Qualifier("footballCoach") Coach theCoach
                         ){
      System.out.println("In Constructor"+ getClass().getSimpleName());
      myCoach = theCoach;
  }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
