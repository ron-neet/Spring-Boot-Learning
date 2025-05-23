package com.SpringClass.RestServices.rest;

import com.SpringClass.RestServices.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;

    // define @PostController to load the student Data .... only once
    @GetMapping("/students")
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Ronit", "Shrestha"));
        theStudents.add(new Student("Hari", "Doe"));
        theStudents.add(new Student("Scooby","Dooo"));
    }

    // defining the end point for(/students)- return a list of students
    // It's not the best implementation so @PostConstruct is used above
    /*   public List<Student> getStudent() {
        theStudents.add(new Student("Ronit", "Shrestha"));
        theStudents.add(new Student("Hari", "Doe"));
        theStudents.add(new Student("Scooby","Dooo"));
        return theStudents;
      }
    */


    // Define the endpoint or "/students/{studentID" - return student at the index
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){

        //Just index into the list keeping it Simple for now

        // Check the studentID and List Size
        if(studentID >= theStudents.size() || (studentID < 0) ){

            throw new StudentNotFoundException("Student with ID " + studentID + " not found");
        }

        return theStudents.get(studentID);
    }


    // Add exception Handling using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setHttpStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception Handler ......... to catch any exception(Catch ALL)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("An error occurred");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
