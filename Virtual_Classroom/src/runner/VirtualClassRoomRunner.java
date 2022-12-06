package runner;

import java.util.Map;
import java.util.Scanner;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.InvalidException;
import logiclayer.Evaluator;

public class VirtualClassRoomRunner
{
	Scanner sc = new Scanner(System.in);
	
	private int getInt()
	{
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}
	
	private long getLong()
	{
		long value = sc.nextLong();
		sc.nextLine();
		return value;
	}
	
	private String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	private void editProfile(VirtualClassRoomRunner run, Evaluator eval) throws InvalidException
	{
		UserDetails userDetails = new UserDetails();
		A:
		for(int i = 0; i < 4; i++)
		{
			System.out.println("Press : \n1 - Name \n2 - Age \n3 - Mobile \n4 - Email");
			int value = run.getInt();
			switch(value)
			{
				case 1:
				{
					System.out.println("Enter Name.");
					String name = run.getString();
					userDetails.setName(name);
					break;
				}
				case 2:
				{
					System.out.println("Enter Age.");
					int age = run.getInt();
					userDetails.setAge(age);
					break;
				}
				case 3:
				{
					System.out.println("Enter mobile number.");
					long mobile = run.getLong();
					userDetails.setMobile(mobile);
					break;
				}
				case 4:
				{
					System.out.println("Enter Email ID.");
					String email = run.getString();
					userDetails.setEmail(email);
					break;
				}
			}
			System.out.println("Press : \n1 - Modify another detials \n2 - Done");
			value = run.getInt();
			switch(value)
			{
				case 1:
				{
					continue A;
				}
				case 2:
				{
					break A;
				}
			}
		}
		
		eval.editProfile(userDetails);
		System.out.println("Profile edited successfully.");
	}
	
	private void student(VirtualClassRoomRunner run, Evaluator eval)
	{
		System.out.println("Enter User ID.");
		long userID = run.getLong();
		System.out.println("Enter password.");
		String password = run.getString();
		
		try
		{
			UserDetails userDetails = eval.userLogin(userID, password);
			String status = userDetails.getStatus();
			if(status.equals("ACTIVE"))
			{
				boolean condition = true;
				do
				{
					System.out.println("Enter case Number.");
					int caseNumber = run.getInt();
					switch(caseNumber)
					{
						case 1:									//Edit Profile...
						{
							editProfile(run, eval);
							break;
						}
						case 2:									//Show Materials...
						{
							Map<Integer, MaterialDetails> materialMap = eval.showMaterials();
							System.out.println("________________________________________________________");
							
							for(int i = 1; i <= materialMap.size(); i++)
							{
								System.out.println("Press : " + i + "to ask questions.");
								MaterialDetails materialDetails = materialMap.get(i);
								System.out.println("MATERIAL ID : " + materialDetails.getMaterialID());
								System.out.println("TITLE : " + materialDetails.getTitle());
								System.out.println("CONTENT : " + materialDetails.getContent());
								System.out.println("________________________________________________________");
							}
							
							int value = run.getInt();
							MaterialDetails materialDetails = materialMap.get(value);
							QADetails qaDetails = new QADetails();
							qaDetails.setMaterialID(materialDetails.getMaterialID());
							System.out.println("Type the question.");
							String question = run.getString();
							qaDetails.setQuestion(question);
							
							eval.askQuestion(qaDetails);
							System.out.println("Question posted successfully.");
							break;
						}
						case 3:									//Show Answers...
						{
							Map<Integer, QADetails> qaMap = eval.showAnswers();
							System.out.println("________________________________________________________");
							
							for(int i = 1; i <= qaMap.size(); i++)
							{
								System.out.println("Press : " + i + "to ask questions.");
								QADetails qaDetails = qaMap.get(i);
								System.out.println("QUESTION ID : " + qaDetails.getQuestionID());
								System.out.println("MATERIAL ID : " + qaDetails.getMaterialID());
								System.out.println("QUESTION : " + qaDetails.getQuestion());
								System.out.println("ANSWER : " + qaDetails.getAnswer());
								System.out.println("________________________________________________________");
							}
							break;
						}
						case 4:									//Logout...
						{
							condition = false;
							break;
						}
					}
				}while(condition);
			}
			else if(status.equals("INACTIVE"))
			{
				System.out.println("Your ID is inactive. \nPlease contact admin.");
			}
			else
			{
				System.out.println("Your registration request is still pending. \nPlease contact admin.");
			}
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
	}
	
	private void faculty(VirtualClassRoomRunner run, Evaluator eval)
	{
		System.out.println("Enter User ID.");
		long userID = run.getLong();
		System.out.println("Enter password.");
		String password = run.getString();
		
		try
		{
			UserDetails userDetails = eval.userLogin(userID, password);
			String status = userDetails.getStatus();
			if(status.equals("ACTIVE"))
			{
				boolean condition = true;
				do
				{
					System.out.println("Enter case Number.");
					int caseNumber = run.getInt();
					switch(caseNumber)
					{
						case 1:									//Edit Profile...
						{
							editProfile(run, eval);
							break;
						}
						case 2:									//Upload Material...
						{
							MaterialDetails materialDetails = new MaterialDetails();
							System.out.println("Enter Title.");
							String title = run.getString();
							System.out.println("Enter content.");
							String content = run.getString();
							materialDetails.setPostedBy(userID);
							materialDetails.setTitle(title);
							materialDetails.setContent(content);
							
							eval.uploadMaterials(materialDetails);
							System.out.println("Material Posted successfully.");
							break;
						}
						case 3:									//Remove Material...
						{
							System.out.println("Enter Material ID.");
							long materialID = run.getLong();
							
							eval.removeMaterial(materialID);
							System.out.println("Material removed successfully.");
							break;
						}
						case 4:									//Show Questions...
						{
							Map<Integer, QADetails> qaMap = eval.showQuestions(userID);
							System.out.println("_____________________________________________________");
							
							for(int i = 1; i <= qaMap.size(); i++)
							{
								System.out.println("Press : " + i + "to Answer the question.");
								QADetails qaDetails = qaMap.get(i);
								System.out.println("QUESTION ID : " + qaDetails.getQuestionID());
								System.out.println("MATERIAL ID : " + qaDetails.getMaterialID());
								System.out.println("QUESTION : " + qaDetails.getQuestion());
								System.out.println("_____________________________________________________");
							}
							
							int i = run.getInt();
							QADetails qaDetails = qaMap.get(i);
							System.out.println("Type the answer.");
							String answer = run.getString();
							qaDetails.setAnswer(answer);
							
							eval.uploadAnswers(qaDetails);
							System.out.println("Answer posted successfully.");
							break;
						}
						case 5:
						{
							condition = false;
							break;
						}
					}
				}while(condition);
			}
			else if(status.equals("INACTIVE"))
			{
				System.out.println("Your ID is inactive. \nPlease contact admin.");
			}
			else
			{
				System.out.println("Your registration request is still pending. \nPlease contact admin.");
			}
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
	}
	
	private void admin(VirtualClassRoomRunner run, Evaluator eval)
	{
		System.out.println("Enter User ID.");
		long userID = run.getLong();
		System.out.println("Enter password.");
		String password = run.getString();
		
		try
		{
			eval.userLogin(userID, password);
			boolean condition = true;
			do
			{
				System.out.println("Enter case Number.");
				int caseNumber = run.getInt();
				switch(caseNumber)
				{
					case 1:									//Users List...
					{
						Map<Integer, UserDetails> usersList = eval.getUsersList();
						
						for(int i = 1; i <= usersList.size(); i++)
						{
							UserDetails userDetails1 = usersList.get(i);
							System.out.println("NAME : " + userDetails1.getName());
							System.out.println("ROLE : " + userDetails1.getRole());
							System.out.println("STATUS : " + userDetails1.getStatus());
						}
						break;
					}
					case 2:									//Request List...
					{
						Map<Integer, UserDetails> usersList = eval.getUsersList();
						
						for(int i = 1; i <= usersList.size(); i++)
						{
							UserDetails userDetails1 = usersList.get(i);
							System.out.println("AUSER ID : " + userDetails1.getUserID());
							System.out.println("NAME : " + userDetails1.getName());
							System.out.println("AGE : " + userDetails1.getAge());
							System.out.println("MOBILE : " + userDetails1.getMobile());
							System.out.println("EMAIL : " + userDetails1.getEmail());
							System.out.println("ROLE : " + userDetails1.getRole());
							System.out.println("DEPARTMENT" + userDetails1.getDepartment());
							System.out.println("STATUS : " + userDetails1.getStatus());
						}
						break;
					}
					case 3:									//Show QA...
					{
						Map<Integer, QADetails> qaMap = eval.showQuestionsAndAnswers();
						
						for(int i = 1; i <= qaMap.size(); i++)
						{
							System.out.println("Press : " + i + "to Delete this QA Entry.");
							QADetails qaDetails = qaMap.get(i);
							System.out.println("QUESTION ID : " + qaDetails.getQuestionID());
							System.out.println("MATERIAL ID : " + qaDetails.getMaterialID());
							System.out.println("QUESTION : " + qaDetails.getQuestion());
							System.out.println("ANSWER" + qaDetails.getAnswer());
						}
						
						int i = run.getInt();
						QADetails qaDetails = qaMap.get(i);
						long questionId = qaDetails.getQuestionID();
						
						eval.deleteQADetails(questionId);
						System.out.println("Question Answer entry removed.");
						break;
					}
					case 4:									//Logout...
					{
						condition = false;
						break;
					}
				}
			}while(condition);
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
	}
	
	private void login(VirtualClassRoomRunner run, Evaluator eval)
	{
		System.out.println("Press : \n1 - Student \n2 - Faculty \n3 - Admin");
		int value = run.getInt();
		String userType = null;
		switch(value)
		{
			case 1:
			{
				userType = "STUDENT";
				break;
			}
			case 2:
			{
				userType = "FACULTY";
				break;
			}
			case 3:
			{
				userType = "ADMIN";
				break;
			}
		}
		switch(userType)
		{
			case "STUDENT":
			{
				run.student(run, eval);
				break;
			}
			case "FACULTY":
			{
				run.faculty(run, eval);
				break;
			}
			case "ADMIN":
			{
				run.admin(run, eval);
				break;
			}
		}
	}
	
	private void register(VirtualClassRoomRunner run, Evaluator eval)
	{
		System.out.println("Enter Name.");
		String name = run.getString();
		System.out.println("Enter Age.");
		int age = run.getInt();
		System.out.println("Enter Mobile number.");
		long mobile = run.getLong();
		System.out.println("Enter Email ID.");
		String email = run.getString();
		System.out.println("Press : \n1 - Student \n2 - Faculty");
		int value = run.getInt();
		String role = null;	
		switch(value)
		{
			case 1:
			{
				role = "STUDENT";
				break;
			}
			case 2:
			{
				role = "FACULTY";
				break;
			}
		}
		System.out.println("Set Password.");
		String password = run.getString();
		UserDetails userDetails = new UserDetails();
		userDetails.setName(name);
		userDetails.setAge(age);
		userDetails.setMobile(mobile);
		userDetails.setEmail(email);
		userDetails.setRole(role);
		userDetails.setPassword(password);
		userDetails.setDepartment("MECH");
		
		try
		{
			userDetails = eval.userRegistration(userDetails);
			System.out.println("*------------------------*");
			System.out.println("|Registration Successfull|");
			System.out.println("*------------------------*");
			System.out.println(userDetails);
		}
		catch (InvalidException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		VirtualClassRoomRunner run = new VirtualClassRoomRunner();
		boolean condition = true;
		do
		{
			System.out.println("Press : \n1 - Login \n2 - Register \n3 - Exit");
			int value = run.getInt();
			Evaluator eval = new Evaluator();
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
				case 3:
				{
					type = "EXIT";
					break;
				}
			}
			switch(type)
			{
				case "REGISTER":
				{
					run.register(run, eval);
					break;
				}
				case "LOGIN":
				{
					run.login(run, eval);
					break;
				}
				case "EXIT":
				{
					condition = false;
					break;
				}
			}
		}while(condition);
	}

}
