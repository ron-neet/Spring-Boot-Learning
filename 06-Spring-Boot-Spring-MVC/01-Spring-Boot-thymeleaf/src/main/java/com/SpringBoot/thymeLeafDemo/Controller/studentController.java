package com.SpringBoot.thymeLeafDemo.Controller;

import com.SpringBoot.thymeLeafDemo.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class studentController {


    // Inject the countries list from application.properties
    @Value("${system}")
    private String system;

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model Model){

        // Student Object
        Student theStudent = new Student();

        // Add student Object
        Model.addAttribute("student", theStudent);
        Model.addAttribute("countries", countries);
        Model.addAttribute("languages", languages);
        Model.addAttribute("system", system);

        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // Log the Input Data
        System.out.println("theStudent : " + theStudent.getFirstName()+ theStudent.getLastName());

        return "student-confirmation";
    }
}
