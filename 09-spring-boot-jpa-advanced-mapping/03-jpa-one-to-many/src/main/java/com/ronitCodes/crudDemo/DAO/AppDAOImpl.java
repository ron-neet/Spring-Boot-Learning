package com.ronitCodes.crudDemo.DAO;

import com.ronitCodes.crudDemo.entity.Instructor;
import com.ronitCodes.crudDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    // Define Entity Manager
    // Inject the Entity Manager using Constructor Injection

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor){
        entityManager.persist(theInstructor);
    }

    @Override
    @Transactional
    public Instructor findInstructorById(int theId){
       return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId){
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public InstructorDetail findInstructorDetailBydId(int theId){
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId){
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    @Transactional
    public void save(InstructorDetail theInstructorDetail){
        entityManager.persist(theInstructorDetail);
    }

}
