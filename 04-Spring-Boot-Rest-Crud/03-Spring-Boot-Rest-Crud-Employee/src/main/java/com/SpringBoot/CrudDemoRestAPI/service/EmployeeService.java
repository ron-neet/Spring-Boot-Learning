package com.SpringBoot.CrudDemoRestAPI.service;

import com.SpringBoot.CrudDemoRestAPI.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //Retrieve all the Id
    List<Employee> findAll();

    // Insert Id
    Employee save(Employee theEmployee);

    //Find Specific Data
    Employee findById(int theId);

    //Delete the data
    void removeById(int theId);
}
