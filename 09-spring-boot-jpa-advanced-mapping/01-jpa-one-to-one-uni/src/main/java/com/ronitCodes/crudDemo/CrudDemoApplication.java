package com.ronitCodes.crudDemo;

import com.ronitCodes.crudDemo.DAO.AppDAO;
import com.ronitCodes.crudDemo.entity.Instructor;
import com.ronitCodes.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			// Below is of Instructor

			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);

			// Below is for instructorDetails

			//findInstructorDetails(appDAO);
			//deleteInstructorDetail(appDAO);
			createInstructorDetail(appDAO);
		};
	}

	private void createInstructorDetail(AppDAO appDAO){

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("RonitCodes", "Haha! Depends on the Mood");

		Instructor tempInstructor =
				new Instructor("Ronit", "Codes", "ronitstha17@gmail.com");


		tempInstructorDetail.setInstructor(tempInstructor);

		System.out.println("Saving Instructor Details"+ tempInstructorDetail);
		System.out.println("Saving Instructor Details"+ tempInstructor);
		appDAO.save(tempInstructorDetail);

	}

	private void deleteInstructorDetail(AppDAO appDAO){

		int theId = 1;
		System.out.println("Found the Instructor Detail");

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Deleted the Instructor Details");

	}

	private void findInstructorDetails(AppDAO appDAO){
		int theId = 1;
		System.out.println("Find the instructor with ID : " + theId);

		InstructorDetail tempInstructorDetails = appDAO.findInstructorDetailBydId(theId);

		System.out.println("The Instructor Details : "+ tempInstructorDetails);
		System.out.println("The associated Details : " + tempInstructorDetails.getInstructor());

		System.out.println("Haha! Completed It ");
	}


	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;

		 System.out.println("Found the Instructor");

		 appDAO.deleteInstructorById(theId);
		 System.out.println("Deleted the Instructor");

	}

	private void findInstructor(AppDAO appDAO){

		int theId = 2;
		System.out.println("Find Instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Temp Instructor" + tempInstructor);
		System.out.println("The associated Instructor Details"+ tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO){
/*
		// Create the Instructor
		Instructor tempInstructor =
				new Instructor("Ronit","Codes","ronitstha17@gmail.com");

		// Create the Instructor Details
		InstructorDetail tempInstructorDetails =
				new InstructorDetail("RonitCodes", "Depend on Mood");
*/
		// Create the Instructor
		Instructor tempInstructor =
				new Instructor("legato","Shrestha","Legato17@gmail.com");

		// Create the Instructor Details
		InstructorDetail tempInstructorDetails =
				new InstructorDetail("LegatoPlayz", "Gaming");
		// Associating the object
		tempInstructor.setInstructorDetail(tempInstructorDetails);

		//
		// This will also save the Details Object
		// because of CascadeType.ALL
		//
		System.out.println("Saving Instructor"+ tempInstructor);
		appDAO.save(tempInstructor);
	}


}
