package com.example.SpringBoot.demo.myspringapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${Programmer.name}")
    private String Programmer_Name;

    @Value("${Programmer.age}")
    private String Programmer_Age;

    @Value("${Programmer.address}")
    private String Programmer_Address;

    @GetMapping("/ProgrammerInfo")
    public String ProgrammerInfo() {
        System.out.println(Programmer_Name);

        return Programmer_Name + " and " + Programmer_Age + " " + Programmer_Address;
    }

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


