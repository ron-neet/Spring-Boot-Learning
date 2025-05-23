package com.springApplication.crudDemo;

import com.springApplication.crudDemo.DAO.StudentDAO;
import com.springApplication.crudDemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			// createStudent(studentDAO);
			 createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students");

	}

	private void deleteStudent(StudentDAO studentDAO) {

		// Defining the Student who is to be deleted
		int studentId = 3;
		System.out.println("Deleting the student whose id is : "+ studentId );

		// Deleting the Student
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve the student based on the id
		int studentId =  1;
		System.out.println("Getting the student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//Change first name to scooby
		System.out.println("Updating the student with id : " + myStudent.getId());
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		//Display the updated Student
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// Get the List of Student By Lastname
		List<Student> theStudentList = studentDAO.findByLastName("sha");

		// Display the Student
		for(Student theStudentDisplay:theStudentList){
			System.out.println(theStudentDisplay);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of all Students
		List<Student> theStudents = studentDAO.findAll();

		//display a the list of the students
		for(Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create the object
		System.out.println("Creating the Object");
		Student tempStudent = new Student("Reena", "shrestha","email");

		// Save the student
		System.out.println("Saving student");
		studentDAO.save(tempStudent);

		//display id of saved Student
		int theId = tempStudent.getId();
		System.out.println("Finding student with id: " + theId);

		// Retrieve Student based on the id : primary Key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display Student
		System.out.println(myStudent);
	}


	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create Multiple Students
		Student tempStudent1 = new Student("Scooby", "Doo", "Hari@gmail.com");
		Student tempStudent2 = new Student("Adams", "Smith", "Har@gmail.com");
		Student tempStudent3 = new Student("John", "Doe", "Hai@gmail.com");

		//Save the objects
		System.out.println("Saving the Data object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO){

		// create the student Object
		Student NewStudent = new Student("Ronit","Sha","Ronitstha!7@gmail.com");

		// save the student Object
		studentDAO.save(NewStudent);

		//display id of the saved Student
		System.out.println("Student created! ID: "+ NewStudent.getId());
	}

}
