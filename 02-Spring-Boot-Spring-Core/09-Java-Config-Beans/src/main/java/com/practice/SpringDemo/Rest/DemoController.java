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

// using the swimCoach as Qualifier
/*    @Autowired
  public DemoController(@Qualifier("swimCoach") Coach theCoach){
      System.out.println("In Constructor"+ getClass().getSimpleName());
      myCoach = theCoach;
  }
*/
// using Bean ID which is Aqua
    @Autowired
    public DemoController(@Qualifier("aqua") Coach theCoach){
        System.out.println("In Constructor"+ getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
