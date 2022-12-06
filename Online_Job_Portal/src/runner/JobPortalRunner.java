package runner;

import java.util.List;
import java.util.Scanner;

import datacarier.ApplicantDetails;
import datacarier.CompanyDetails;
import datacarier.VacancyDetails;
import exceptions.WrongEntryException;
import logiclayer.ApplicantLayer;
import logiclayer.CompanyLayer;

public class JobPortalRunner
{
	private static Scanner sc = new Scanner(System.in);
	
	private long getLong()
	{
		long value = sc.nextLong();
		sc.nextLine();
		return value;
	}
	
	private int getInt()
	{
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}
	
	private String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	private void jobSearch(JobPortalRunner run, ApplicantLayer applicant, ApplicantDetails applicantDetails)
	{
		List<VacancyDetails> matchedVacancyList = applicant.jobSearch(applicantDetails);
		System.out.println("______________________________________________________________");
		if(matchedVacancyList.size() == 0)
		{
			System.out.println("No Maching Job has been found.");
			System.out.println("______________________________________________________________");
		}
		else
		{
			for(int i = 0; i < matchedVacancyList.size(); i++)
			{
				VacancyDetails vacancyDetails = matchedVacancyList.get(i);
				System.out.println("To Apply for this job press : " + (i+1));
				System.out.println("COMPANY NAME : " + vacancyDetails.getCompanyName());
				System.out.println("ROLE : " + vacancyDetails.getRole());
				System.out.println("QUALIFICATION : " + vacancyDetails.getQualification());
				System.out.println("EXPERIENCE : " + vacancyDetails.getExperience());
				System.out.println("SKILL : " + vacancyDetails.getSkill());
				System.out.println("NO OF OPENINGS : " + vacancyDetails.getNoOfOpenings());
				System.out.println("______________________________________________________________");
			}
			int i = run.getInt();
			VacancyDetails vacancyDetails = matchedVacancyList.get(i-1);
			System.out.println("Your application has been submitted successfully.");
			System.out.println("*-----------------*");
			System.out.println("|Interview Details|");
			System.out.println("*-----------------*");
			System.out.println("COMPANY NAME : " + vacancyDetails.getCompanyName());
			System.out.println("ROLE : " + vacancyDetails.getRole());
			System.out.println("INTERVIEW DATE : 25/12/2022");
		}
	}
	
	private void applicantLogin(JobPortalRunner run, ApplicantLayer applicant)
	{
		System.out.println("Enter UserID.");
		long userID = run.getLong();
		System.out.println("Enter password.");
		String password = run.getString();
		boolean condition = true;
		do
		{
			System.out.println("Enter case number.");
			int value = run.getInt();
			switch(value)
			{
				case 1:
				{
					try
					{
						ApplicantDetails applicantDetails = applicant.applicantLogin(userID, password);
						
						run.jobSearch(run, applicant, applicantDetails);
					}
					catch (WrongEntryException e)
					{
						System.out.println(e.getMessage());
					}
				}
				case 2:							//Logout...
				{
					condition = false;
				}
			}
		}while(condition);
	}
	private void applicantRegister(JobPortalRunner run, ApplicantLayer applicant)
	{
		ApplicantDetails applicantDetails = new ApplicantDetails();
		System.out.println("Enter Name.");
		String name = run.getString();
		System.out.println("Enter Age.");
		int age = run.getInt();
		System.out.println("Enter Qualification.");
		String qualification = run.getString();
		System.out.println("Enter Experience.");
		int experience = run.getInt();
		System.out.println("Enter Skill.");
		String skill = run.getString();
		System.out.println("Set UserID.");
		long userID = run.getLong();
		System.out.println("Set password.");
		String password = run.getString();
		applicantDetails.setName(name);
		applicantDetails.setAge(age);
		applicantDetails.setQualification(qualification);
		applicantDetails.setExperience(experience);
		applicantDetails.setSkills(skill);;
		applicantDetails.setUserID(userID);
		applicantDetails.setPassword(password);
		
		applicant.applicantRegistration(applicantDetails);
		System.out.println("Registration successfull.");
	}
	
	private void applicant(JobPortalRunner run) throws WrongEntryException
	{
		ApplicantLayer applicant = new ApplicantLayer();
		System.out.println("Press : \n1 - Login \n2 - Register");
		int value = run.getInt();
		String type = null;
		switch(value)
		{
			case 1:
			{
				type = "LOGIN";
				break;
			}
			case 2:
			{
				type = "REGISTER";
				break;
			}
		}
		
		switch(type)
		{
			case "REGISTER":
			{
				run.applicantRegister(run, applicant);
			}	
			case "LOGIN":
			{
				run.applicantLogin(run, applicant);
				break;
			}
		}
	}
	
	private void vacancyRegistration(JobPortalRunner run, CompanyLayer company, CompanyDetails companyDetails)
	{
		VacancyDetails vacancyDetails = new VacancyDetails();
		System.out.println("Enter role.");
		String role = run.getString();
		System.out.println("Enter Qualification.");
		String qualification = run.getString();
		System.out.println("Enter Experience.");
		int experience = run.getInt();
		System.out.println("Enter Skill.");
		String skill = run.getString();
		System.out.println("Enter number of openings.");
		int noOfOpenings = run.getInt();
		String companyName = companyDetails.getCompanyName();
		vacancyDetails.setRole(role);
		vacancyDetails.setQualification(qualification);
		vacancyDetails.setExperience(experience);
		vacancyDetails.setSkill(skill);
		vacancyDetails.setCompanyName(companyName);
		vacancyDetails.setNoOfOpenings(noOfOpenings);
		
		
	}
	
	private void companyLogin(JobPortalRunner run, CompanyLayer company)
	{
		System.out.println("Enter UserID.");
		long userID = run.getLong();
		System.out.println("Enter password.");
		String password = run.getString();
		
		try
		{
			CompanyDetails companyDetails = company.companyLogin(userID, password);
			
			run.vacancyRegistration(run, company, companyDetails);
		}
		catch (WrongEntryException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private void companyRegister(JobPortalRunner run, CompanyLayer company)
	{
		CompanyDetails companyDetails = new CompanyDetails();
		System.out.println("Enter Company Name.");
		String companyName = run.getString();
		System.out.println("Set UserID.");
		long userID = run.getLong();
		System.out.println("Set password.");
		String password = run.getString();
		companyDetails.setCompanyName(companyName);
		companyDetails.setUserID(userID);
		companyDetails.setPassword(password);
		
		company.companyRegistration(companyDetails);
		System.out.println("Registration successfull.");
	}
	
	private void company(JobPortalRunner run)
	{
		CompanyLayer company = new CompanyLayer();
		System.out.println("Press : \n1 - Login \n2 - Register");
		int value = run.getInt();
		String type = null;
		switch(value)
		{
			case 1:
			{
				type = "LOGIN";
				break;
			}
			case 2:
			{
				type = "REGISTER";
				break;
			}
		}
		
		switch(type)
		{
			case "REGISTER":
			{
				run.companyRegister(run, company);
			}
			case "LOGIN":
			{
				run.companyLogin(run, company);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws WrongEntryException
	{
		JobPortalRunner run =new  JobPortalRunner();
		boolean condition = true;
		do
		{
			System.out.println("Press : \n1 - Applicant \n2 - Company \n3 - Logout");
			int value = run.getInt();
			String userType = null;
			switch(value)
			{
				case 1:
				{
					userType = "APPLICANT";
					break;
				}
				case 2:
				{
					userType = "COMPANY";
					break;
				}
				case 3:
				{
					userType = "LOGOUT";
					break;
				}
			}
			
			switch(userType)
			{
				case "APPLICANT":
				{
					run.applicant(run);
					break;
				}
				case "COMPANY":
				{
					run.company(run);
					break;
				}
				case "LOGOUT":
				{
					condition = false;
					break;
				}
			}
		}while(condition);
	}

}
