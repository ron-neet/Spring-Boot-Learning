package com.SpringBoot.CrudDemoRestAPI.service;

import com.SpringBoot.CrudDemoRestAPI.DAO.EmployeeDAO;
import com.SpringBoot.CrudDemoRestAPI.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    //Constructor Injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public void removeById(int theId) {
        employeeDAO.removeById(theId);
    }
}
