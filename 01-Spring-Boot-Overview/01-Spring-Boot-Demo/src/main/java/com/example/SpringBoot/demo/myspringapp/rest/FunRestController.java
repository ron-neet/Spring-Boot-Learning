package com.example.SpringBoot.demo.myspringapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayhello(){
        return "HelWorld";
    }
}
