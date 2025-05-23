package com.luv2code.springboot.thymeleafdemo.Controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Add Mapping for list of Employees
    @GetMapping("/List")
    public String ListEmployees(Model theModel){

        //Get the employees From DB
        List<Employee> theemployees = employeeService.findAll();

        // Add to spring Model
        theModel.addAttribute("employees", theemployees);

        return "list-employees";

    }

}
