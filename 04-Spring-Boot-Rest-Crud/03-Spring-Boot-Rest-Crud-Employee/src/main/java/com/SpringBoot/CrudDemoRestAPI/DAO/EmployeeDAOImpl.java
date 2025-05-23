package com.SpringBoot.CrudDemoRestAPI.DAO;

import com.SpringBoot.CrudDemoRestAPI.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //define field for entityManager
    private EntityManager theEntityManager;

    //set up Constructor Injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        this.theEntityManager = theEntityManager;
    }

    public List<Employee> findAll(){

        //create a query
        TypedQuery<Employee> theQuery = theEntityManager.createQuery("from Employee", Employee.class);

        //execute the query
        List<Employee > employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override

    public Employee save(Employee theEmployee) {

        //Save the Employee ID
        Employee dbEmployee = theEntityManager.merge(theEmployee);

        //Return
        return dbEmployee;
    }

    @Override
    public Employee findById(int theId) {

        //get Employee
        Employee theEmployee = theEntityManager.find(Employee.class, theId);

        //Return
        return theEmployee;
    }

    @Override
    public void removeById(int theId) {

        //Get Employee ID
        Employee delEmployee = theEntityManager.find(Employee.class, theId);

        //Remove the Employee
        theEntityManager.remove(delEmployee);
    }

}
