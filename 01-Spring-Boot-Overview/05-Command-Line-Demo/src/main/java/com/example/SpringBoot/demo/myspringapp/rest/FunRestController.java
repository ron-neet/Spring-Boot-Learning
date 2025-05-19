package com.example.SpringBoot.demo.myspringapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayhello(){

        return "Hello World";
    }

    @GetMapping("/workout")
    public String GetDailyWorkout(){
        return "Run daily workout";
    }

    @GetMapping("/workout/task")
    public String GetDailyWorkoutTask(){
        return "Run 100 Miles";
    }
}
