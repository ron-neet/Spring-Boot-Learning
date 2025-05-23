package com.springApplication.crudDemo.DAO;

import com.springApplication.crudDemo.Entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student thestudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
