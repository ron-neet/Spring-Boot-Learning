package com.SpringBoot.thymeLeafDemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need Controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloWorld-form";
    }

    // need Controller method to Process the html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }

    // need Controller method to READ and ADD Data
    @RequestMapping("/displayData")
    public String displayData(HttpServletRequest request, Model model){

        // Read the Request Parameter from the HTML form
        String theData = request.getParameter("studentName");

        // Convert To UpperCase
        String upperCaseData = theData.toUpperCase();

        // Display the Result
        String result = "Yooooo!! I some what got idea yo : " + upperCaseData;

        // Add Data or message To Model
        model.addAttribute("message", result);

        return "helloWorld";
    }


    @PostMapping("/displayData2")
    public String processFormVersionTwo(@RequestParam("studentName") String theName, Model model){

        // Convert To UpperCase
        String upperCaseData = theName.toUpperCase();

        // Display the Result
        String result = "Hey!! I want a job : " + upperCaseData;

        // Add Data or message To Model
        model.addAttribute("message", result);

        return "helloWorld";
    }
}
