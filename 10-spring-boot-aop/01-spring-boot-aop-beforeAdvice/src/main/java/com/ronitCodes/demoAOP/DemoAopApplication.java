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

		// call the business method
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.addSillyMethod();

		// Call Membership Account
		theMembershipDAO.addSillyMethod();
		theMembershipDAO.addMembershipAccount();

	}
}
