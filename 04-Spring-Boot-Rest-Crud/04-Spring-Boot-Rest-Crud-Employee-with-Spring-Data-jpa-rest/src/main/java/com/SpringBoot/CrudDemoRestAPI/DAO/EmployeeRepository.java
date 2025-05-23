package com.SpringBoot.CrudDemoRestAPI.DAO;

import com.SpringBoot.CrudDemoRestAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")                                       //EntityType //Primary Key
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    // that's it........no need to write any code LOL!
}
