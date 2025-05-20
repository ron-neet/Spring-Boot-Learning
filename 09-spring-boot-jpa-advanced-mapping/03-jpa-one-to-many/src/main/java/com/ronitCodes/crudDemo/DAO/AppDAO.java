package com.ronitCodes.crudDemo.DAO;

import com.ronitCodes.crudDemo.entity.Instructor;
import com.ronitCodes.crudDemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

    // InstructorDetail

    InstructorDetail findInstructorDetailBydId(int theId);
    void deleteInstructorDetailById(int theId);
    void save(InstructorDetail theInstructorDetail);
}
