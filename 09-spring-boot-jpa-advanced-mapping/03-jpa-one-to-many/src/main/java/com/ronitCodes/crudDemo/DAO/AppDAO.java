package com.ronitCodes.crudDemo.DAO;

import com.ronitCodes.crudDemo.entity.Course;
import com.ronitCodes.crudDemo.entity.Instructor;
import com.ronitCodes.crudDemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);
    void deleteCourseById(int theId);
    Course findCourseById(int theId);
}