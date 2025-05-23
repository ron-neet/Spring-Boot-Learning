package com.ronitCodes.demoAOP;

import com.ronitCodes.demoAOP.DAO.AccountDAO;
import com.ronitCodes.demoAOP.DAO.MembershipDAO;
import com.ronitCodes.demoAOP.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {

		return runner -> {

			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

			// demoTheAfterReturningAdvice(theAccountDAO);

			// demoTheAfterThrowingAdvice(theAccountDAO);

			// demoTheAfterAdvice(theAccountDAO);

			// demoTheAroundAdvice(theTrafficFortuneService);

			// demoTheAroundAdviceHandleException(theTrafficFortuneService);

			demoTheArounfAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheArounfAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n\n Main Program : demoTheAroundAdviceHandleException : ");

		System.out.println("\n Calling the getFortune() : ");


		boolean flag = true;
		String data = theTrafficFortuneService.getFortune(flag);

		System.out.println("\n My fortune is : " + data);

		System.out.println("\n Done");

	}


	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n\n Main Program : demoTheAroundAdviceHandleException : ");

		System.out.println("\n Calling the getFortune() : ");


		boolean flag = true;
		String data = theTrafficFortuneService.getFortune(flag);

		System.out.println("\n My fortune is : " + data);

		System.out.println("\n Done");

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n\n Main Program : demoTheAroundAdvice : ");

		System.out.println("\n Calling the getFortune: ");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\n My fortune is : " + data);

		System.out.println("\n Done");


	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO){
		// Call the method to find the Account
		List<Account> theAccounts = null;
		try {

			// add a boolean flag to stimulate
			boolean flag = false;
			theAccounts = theAccountDAO.findAccount(flag);
		}
		catch (Exception exc){

			System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice : ");
			System.out.println("Exception : " + exc);
		}


		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice : ");
		System.out.println("=============================================");
		System.out.println("The Accounts are : " + theAccounts);

		System.out.println("\n Done");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// Call the method to find the Account
		List<Account> theAccounts = null;
		try {
			// add a bolean flag to stimulate
			boolean flag = true;

			theAccounts = theAccountDAO.findAccount(flag);
		}
		catch (Exception exc){
			System.out.println("\n\n Main Program : demotheAfterThrowingAdvice : ");
			System.out.println("Exception : " + exc);

		}


		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice : ");
		System.out.println("=============================================");
		System.out.println("The Accounts are : " + theAccounts);

		System.out.println("\n Done");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO){

		// Call the method to find the Account
		List<Account> accounts = theAccountDAO.findAccount();

		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice : ");
		System.out.println("=============================================");
		System.out.println("The Accounts are : " + accounts);

		System.out.println("\n Done");
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
