package com.SpringBoot.CrudDemoRestAPI.DAO;

import com.SpringBoot.CrudDemoRestAPI.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    //Retrieve all the Id
    List<Employee> findAll();

    // Insert Id
    Employee save(Employee theEmployee);

    //Find Specific Data
    Employee findById(int theId);

    //Delete the data
    void removeById(int theId);
}
