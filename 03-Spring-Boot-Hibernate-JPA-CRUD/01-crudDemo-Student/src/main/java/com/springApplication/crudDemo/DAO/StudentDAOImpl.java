package com.springApplication.crudDemo.DAO;

import com.springApplication.crudDemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //defining the field for Entity Manager
    private final EntityManager entitymanager;

    @Autowired
    //Inject Entity Manager using constructor Injection
    public StudentDAOImpl(EntityManager entitymanager){
        this.entitymanager = entitymanager;
    }

    //Implement save Method
    @Override
    @Transactional
    public void save(Student thestudent) {
        entitymanager.persist(thestudent);
    }

    @Override
    public Student findById(Integer id) {
        return entitymanager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // Create the query
        TypedQuery<Student> theQuery= entitymanager.createQuery("From Student", Student.class);

        // return query Result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        // Create the query
        TypedQuery<Student> theQuery = entitymanager.createQuery(
                "From Student where LastName=:theData", Student.class);

        //Set the query Parameter
        theQuery.setParameter("theData", lastName);

        //return Result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entitymanager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

       //Retrieve the Student
         Student theStudent = entitymanager.find(Student.class,id);

        //Delete the Student
        entitymanager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entitymanager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }

}
