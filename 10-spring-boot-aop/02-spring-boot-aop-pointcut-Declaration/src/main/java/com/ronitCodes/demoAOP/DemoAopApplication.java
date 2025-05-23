package com.ronitCodes.demoAOP;

import com.ronitCodes.demoAOP.DAO.AccountDAO;
import com.ronitCodes.demoAOP.DAO.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account theAccount = new Account();

		theAccount.setAccountName("Ronit");
		theAccount.setAccountNumber("1234567890");

		// call the business method
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.addSillyMethod();

		// Call Account's getter and setter methods
		theAccountDAO.setAccountName("Ronit");
		theAccountDAO.setAccountNumber("Hello");

		String name = theAccountDAO.getAccountName();
		String number = theAccountDAO.getAccountNumber();

		System.out.println("Name: " + name + " Number: " + number);

		// Call Membership Account
		theMembershipDAO.addSillyMethod();
		theMembershipDAO.addMembershipAccount();

	}
}
