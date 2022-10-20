package runner;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import banking.BankAdminLayer;
import banking.BankCustomerLayer;
import banking.BankUserLayer;
import datacarier.AccountDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import util.GetTimeFromMillisecond;

public class BankingRunner
{
	
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static Scanner sc = new Scanner(System.in);
	static BankingRunner runner = new BankingRunner();
	
	private int getInteger()
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
	
	private double getDouble()
	{
		double value = sc.nextDouble();
		sc.nextLine();
		return value;
	}
	
	private String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	private Map<Integer, Long> getAvailableAccountsList(Map<Long,Map<Long,AccountDetails>> map, long customerID)
	{
		Map<Integer, Long> accountsList = new Hashtable<>();
		
		Map<Long, AccountDetails> innerMap = map.get(customerID);
		
		int i = 1;
		
		for(Map.Entry<Long, AccountDetails> entry : innerMap.entrySet())
		{
			long accountNo = entry.getKey();
			
			accountsList.put(i, accountNo);
			
			i++;
		}
		
		return accountsList;
		
	}
	
	private Map<Integer, Long> getAvailableCustomersList(Map<Long,Map<Long,AccountDetails>> map)
	{
		Map<Integer, Long> customersList = new Hashtable<>();
		
		int i = 1;
		
		for(Map.Entry<Long, Map<Long,AccountDetails>> entry : map.entrySet())
		{
			
			long customerID = entry.getKey();
			
			customersList.put(i, customerID);
			
			i++;
		}
		
		return customersList;
		
	}
	
	private Map<Integer, Long> getAccountsList(Map<Long,Map<Long,AccountDetails>> map, long customerID)
	{
		
		Map<Integer, Long> accountsList = new Hashtable<>();
		
		Map<Long, AccountDetails> innerMap = map.get(customerID);
		
		int i = 1;
		
		for(Map.Entry<Long,AccountDetails> entry : innerMap.entrySet())
		{
			
			long accountNo = entry.getKey();
			
			accountsList.put(i, accountNo);
			
			i++;
		}
		
		return accountsList;
		
	}
	
	private void printAccountsList(Map<Integer, Long> accountsList)
	{
		
		int length = accountsList.size();
		
		for(int i = 1; i<=length; i++)
		{
			System.out.println("Enter " +i+ " for " +accountsList.get(i));
		}
		
	}
	
	private void printCompleteAccountDetailsOfID(Map<Long,Map<Long,AccountDetails>> map, long customerID)
	{
		Map<Long, AccountDetails> innerMap = map.get(customerID);
		
		for(Map.Entry<Long, AccountDetails> entry : innerMap.entrySet())
		{
			AccountDetails pojo = entry.getValue();
			
			System.out.println("__________________________________________________________");
			System.out.println("CUSTOMER ID : " + pojo.getCustomerID());
			System.out.println("ACCOUNT_NO : " + pojo.getAccountNo());
			System.out.println("IFSC_CODE : " + pojo.getIfscCode());
			System.out.println("BRANCH : " + pojo.getBranch());
			System.out.println("BALANCE : " + pojo.getBalance());
			System.out.println("ACCOUNT_TYPE : " + pojo.getAccountType());
			System.out.println("ACCOUNT_STATUS : " + pojo.getAccountStatus());
			System.out.println("__________________________________________________________");
			
		}	
	}
	
	private void printParticularAccountDetails(Map<Long,Map<Long,AccountDetails>> map, long customerID, long accountNo)
	{
	
		logger.info("Account details corresponding to the given Customer ID is :\n");
		
		Map<Long,AccountDetails> innerMap = map.get(customerID);
		
		AccountDetails pojo = innerMap.get(accountNo);
		
		System.out.println("__________________________________________________________");
		System.out.println("CUSTOMER ID : " + pojo.getCustomerID());
		System.out.println("ACCOUNT_NO : " + pojo.getAccountNo());
		System.out.println("IFSC_CODE : " + pojo.getIfscCode());
		System.out.println("BRANCH : " + pojo.getBranch());
		System.out.println("BALANCE : " + pojo.getBalance());
		System.out.println("ACCOUNT_TYPE : " + pojo.getAccountType());
		System.out.println("ACCOUNT_STATUS : " + pojo.getAccountStatus());
		System.out.println("__________________________________________________________");
			
	}
	
	private void printTransactionHistory(List<TransactionDetails> transactionList)
	{
		
		int length = transactionList.size();
		
		if(length == 0)
		{
			System.out.println("No Transactions have been done yet.");
		}
		else
		{
			for(TransactionDetails pojo : transactionList)
			{
				
				System.out.println("_______________________________________________________");
				System.out.println("CUSTOMER_ID : " + pojo.getCustomerID());
				System.out.println("TRANSACTION_ID : " + pojo.getTransactionID());
				System.out.println("SENDER_ACCOUNT_NO : " + pojo.getFromAccount());
				System.out.println("RECEIVER_ACCOUNT_NO : " + pojo.getToAccount());
				System.out.println("AMOUNT :" + pojo.getAmount());
				System.out.println("CLOSING_BALANCE : " + pojo.getClosingBalance());
				
				long millisecond = pojo.getMilliSeconds();
				GetTimeFromMillisecond time = new GetTimeFromMillisecond();
				String dateAndTime = time.getInstantTimeAndDate(millisecond);
				
				System.out.println("DATE_AND_TIME : " + dateAndTime);
				System.out.println("MODE_OF_TRANSACTION : " + pojo.getModeOfTransaction());
				System.out.println("TYPE : " + pojo.getType());
				System.out.println("_______________________________________________________");
				
			}
		}
	}
	
	private long getCustomerID(Map<Integer, Long> customersList)
	{
		
		printAccountsList(customersList);
		
		int key = runner.getInteger();
		long customerID = customersList.get(key);
		
		return customerID;
		
	}
	
	private long getAccountNo(Map<Integer, Long> accountsList)
	{
		
		printAccountsList(accountsList);
		
		int key = runner.getInteger();
		long accountNo = accountsList.get(key);
		
		return accountNo;
		
	}
	
	private double updateCacheForDeposit(Map<Long,Map<Long,AccountDetails>> map, TransactionDetails transactionDetails)
	{
		
		long toAccount = transactionDetails.getFromAccount();
		double amount = transactionDetails.getAmount();
		long customerID = transactionDetails.getCustomerID();
		
		AccountDetails pojo = map.get(customerID).get(toAccount);
		
		double balance = pojo.getBalance();
		
		pojo.setBalance((balance + amount));
		
		return (balance + amount);
		
	}
	
	private double updateCacheForWithdraw(Map<Long,Map<Long,AccountDetails>> map, TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		long fromAccount = transactionDetails.getFromAccount();
		double amount = transactionDetails.getAmount();
		long customerID = transactionDetails.getCustomerID();
		
		AccountDetails pojo = map.get(customerID).get(fromAccount);
		
		double balance = pojo.getBalance();
		
		if(balance>=amount)
		{
			pojo.setBalance((balance - amount));

			return (balance - amount);
		}
		else
		{
			throw new WrongEntryException("Insufficient Balance to proceed Transaction.");
		}
		
	}
	
	private String getDateOfBirth()
	{
		
		logger.info("Enter date.");
		String date = runner.getString();
		logger.info("Enter month.");
		String month = runner.getString();
		logger.info("Enter year.");
		String year = runner.getString();
		
		String dateOfBirth = date + "/" + month + "/" + year;
		
		return dateOfBirth;
		
	}
	
	private void customer(UserDetails userDetails) throws WrongEntryException
	{
		BankCustomerLayer bank = new BankCustomerLayer();
		
		long customerID = userDetails.getUserID();
		String password = userDetails.getPassword();
		
		CustomerDetails customerDetails = bank.getCustomerDetails(customerID);
		
		Map<Long,Map<Long,AccountDetails>> map = bank.getAccountDetails(customerID, password);
		
		Map<Integer, Long> accountsList = getAvailableAccountsList(map, customerID);
		
		A:
		while(true)
		{
			try
			{
				logger.info("Enter the case number to execute...");
				int caseValue = runner.getInteger();
				
				switch(caseValue)
				{
					case 1:						//To get specified personal account details...
					{
						
						logger.info("Select Account number to see its details.");
						
						long accountNo = getAccountNo(accountsList);
						
						runner.printParticularAccountDetails(map, customerID, accountNo);
						
						break;
					}
					case 2:						//To get complete personal account list...
					{
						
						runner.printCompleteAccountDetailsOfID(map, customerID);
						
						break;
					}
					case 3:						//To get balance...
					{
						logger.info("Select Account number to get balance.");
						
						long accountNo = getAccountNo(accountsList);
						
						AccountDetails pojo = map.get(customerID).get(accountNo);
						
						double balance = pojo.getBalance();
						
//						double balance = bank.getBalance(accountNo, password);
						
						logger.info("Amount in your account is : " + balance);
						
						break;
					}
					case 4:						//To deposite Amount...
					{
						logger.info("Select Account number to deposit.");
						
						long toAccount = getAccountNo(accountsList);
						
						logger.info("Enter the Amount to Deposite.");
						double amount = runner.getDouble();
						
						TransactionDetails transactionDetails = new TransactionDetails();
						
						transactionDetails.setToAccount(toAccount);
						transactionDetails.setAmount(amount);
						transactionDetails.setCustomerID(customerID);
						
						bank.deposit(transactionDetails);
						
						double balance = updateCacheForDeposit(map, transactionDetails);
						
						logger.info("Transaction successfull. \nUpdated Balance : " + balance);
						
						break;
					}
					case 5:						//To withdraw Amount...
					{
						logger.info("Select Account number to withdraw.");
						
						long fromAccount = getAccountNo(accountsList);
						
						logger.info("Enter the Amount to Withdraw.");
						double amount = runner.getDouble();
						
						TransactionDetails transactionDetails = new TransactionDetails();
						
						transactionDetails.setFromAccount(fromAccount);
						transactionDetails.setAmount(amount);
						transactionDetails.setCustomerID(customerID);
						
						double balance = bank.withdraw(transactionDetails, password);
						
						updateCacheForWithdraw(map, transactionDetails);
							
						logger.info("Available Balance : " + balance);
						
						break;
					}
					case 6:						//To transfer amount to own accounts...
					{
						logger.info("Please select from Account to transfer amount.");
						
						long fromAccount = getAccountNo(accountsList);
						
						logger.info("Please select ToAccount to transfer amount.");
						
						long toAccount = getAccountNo(accountsList);
						
						logger.info("Enter amount to transfer.");
						double amount = runner.getDouble();
						
						TransactionDetails transactionDetails = new TransactionDetails();
						
						transactionDetails.setFromAccount(fromAccount);
						transactionDetails.setToAccount(toAccount);
						transactionDetails.setAmount(amount);
						transactionDetails.setCustomerID(customerID);
						
						bank.onlineTransfer(transactionDetails, password);
						
						updateCacheForWithdraw(map, transactionDetails);
							
						updateCacheForDeposit(map, transactionDetails);
							
						logger.info("Transaction Successful.");
						
						break;
						
					}
					case 7:						//To transfer amount to another person's account...
					{
						logger.info("Please select from Account to transfer amount.");
						
						long fromAccount = getAccountNo(accountsList);
						
						logger.info("Enter ToAccount to transfer amount.");
						
						long toAccount = runner.getLong();
						
						logger.info("Enter amount to transfer.");
						double amount = runner.getDouble();
						
						TransactionDetails transactionDetails = new TransactionDetails();
						
						transactionDetails.setFromAccount(fromAccount);
						transactionDetails.setToAccount(toAccount);
						transactionDetails.setAmount(amount);
						transactionDetails.setCustomerID(customerID);
						
						bank.onlineTransfer(transactionDetails, password);
						
						updateCacheForWithdraw(map, transactionDetails);
							
						logger.info("Transaction Successful.");
						
						break;
						
					}
					case 8:						//To see transaction details...
					{
						printAccountsList(accountsList);
						
						int key = runner.getInteger();
						
						long accountNo = accountsList.get(key);
						
						List<TransactionDetails> transactionList = bank.getTransactionHistory(accountNo, customerID);
						
						printTransactionHistory(transactionList);
						
						break;
					}
					case 9:						//To print customer details...
					{
						
						System.out.println("__________________________________________________________");
						System.out.println("CUSTOMER_ID : " + customerDetails.getCustomerID());
						System.out.println("PAN_NO : " + customerDetails.getPanNo());
						System.out.println("AADHAR_NO : " + customerDetails.getAadharNo());
						System.out.println("ADDRESS : " + customerDetails.getAddress());
						System.out.println("CUSTOMER_STATUS : " + customerDetails.getCustomerStatus());
						System.out.println("__________________________________________________________");
						
						break;
						
					}
					case 10:					//To modify specific personal details...
					{
						UserDetails details = new UserDetails();
						details.setUserID(customerID);
						boolean condition = false;
						
						B:
						do
						{
							logger.info("Enter : 1 to change Name.\n              2 to change Mobile number.\n              3 to change Email ID.\n              4 to change Date Of Birth.");
							int decision = runner.getInteger();
							
							switch(decision)
							{
								case 1:
								{
									logger.info("Enter Name to change.");
									String name = runner.getString();
									details.setName(name);
									break;
								}
								case 2:
								{
									logger.info("Enter Mobile number to change.");
									long mobile = runner.getLong();
									details.setMobile(mobile);
									break;
								}
								case 3:
								{
									logger.info("Enter Email ID to change.");
									String emailID = runner.getString();
									details.setEmailID(emailID);
									break;
								}
								case 4:
								{
									logger.info("Enter Date Of Birth to change.");
									String dateOfBirth = getDateOfBirth();
									details.setDateOfBirth(dateOfBirth);
									break;
								}
								default:
								{
									logger.info("Enter valid input.");
									continue B;
								}
							}
							
							logger.info("Enter 1 if you want to modify another detail. \nEnter 2 if you are done.");
							int n = runner.getInteger();
							
							if(n == 1)
							{
								condition = true;
							}
							else if(n == 2)
							{
								condition = false;
							}
							
						}while(condition);
						
						bank.modifyUserDetails(details);
						
						logger.info("Data Modified Successfully.");
						
						break;
						
					}
					case 11:					//To change Password...
					{
						logger.info("Enter old Password to modify it.");
						String oldPassword = runner.getString();
						logger.info("Enter new password to set");
						String newPassword = runner.getString();
						
						bank.modifyPassword(customerID, oldPassword, newPassword);
						
						logger.info("Password changed Successfully.");
						
						break;
						
					}
					case 0:						//To Logout Account...
					{
						boolean condition = false;
						do 
						{
							logger.info("Do you want to Logout? \nEnter Ok to Logout. \nEnter Cancel to continue.");
							String decision = runner.getString().toUpperCase();
							
							switch(decision)
							{
								case "OK":
								{
									break A;
								}
								case "CANCEL":
								{
									continue A;
								}
								default:
								{
									logger.info("Enter correct input.");
									condition = true;
								}
							}
						}while(condition);
						
						break;
						
					}
					default:
					{
						logger.info("Invalid case number.");
						break;
					}
				}
			}
			catch(InputMismatchException e)
			{
				logger.warning("Data type mismatch...");
				sc.nextLine();
			}
			catch (WrongEntryException e)
			{
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	
	private void admin(UserDetails userDetails) throws WrongEntryException
	{
		BankAdminLayer bank = new BankAdminLayer();
		
//		long userID = userDetails.getUserID();
//		String password = userDetails.getPassword();
		
		Map<Long,Map<Long,AccountDetails>> completeAccountsList = bank.getcompleteAccountsList();
		
		Map<Integer, Long> customersList = getAvailableCustomersList(completeAccountsList);
		
		A:
		while(true)
		{
			try
			{
				logger.info("Enter the case number to execute...");
				int caseValue = runner.getInteger();
				
				switch(caseValue)
				{
					case 1:						//To deposite in a account...
					{
						logger.info("Select a customer ID to deposit.");
						
						long customerID = getCustomerID(customersList);
						
						Map<Integer, Long> accountsList = getAccountsList(completeAccountsList, customerID);
						
						logger.info("Select Account number to deposit.");
						
						long toAccount = getAccountNo(accountsList);
						
						logger.info("Enter the Amount to Deposite.");
						double amount = runner.getDouble();
						
						TransactionDetails transactionDetails = new TransactionDetails();
						
						transactionDetails.setToAccount(toAccount);
						transactionDetails.setAmount(amount);
						transactionDetails.setCustomerID(customerID);
						
						bank.deposit(transactionDetails);
						
						updateCacheForDeposit(completeAccountsList, transactionDetails);
						
						logger.info("Transaction successfull.");
						
						break;
					}
					case 2:						//To get specific user's accounts details...
					{
						logger.info("Select a customer ID.");
						
						long customerId = getCustomerID(customersList);
						
						runner.printCompleteAccountDetailsOfID(completeAccountsList, customerId);
						
						break;
					}
					case 3:					//To get specific account details...
					{
						logger.info("Select a customer ID.");
						
						long customerID = getCustomerID(customersList);
						
						Map<Integer, Long> accountsList = getAccountsList(completeAccountsList, customerID);
						
						logger.info("Select Account number to see details.");
						
						long accountNo = getAccountNo(accountsList);
						
						printParticularAccountDetails(completeAccountsList, customerID, accountNo);
						
					}
					case 4:						//To get specific user's account balance...
					{
						logger.info("Select a customer ID.");
						
						long customerID = getCustomerID(customersList);
						
						Map<Integer, Long> accountsList = getAccountsList(completeAccountsList, customerID);
						
						logger.info("Select Account number to see details.");
						
						long accountNo = getAccountNo(accountsList);
						
						AccountDetails pojo = completeAccountsList.get(customerID).get(accountNo);
						
						double balance = pojo.getBalance();
						
						logger.info("Amount in your account is : " + balance);
						
						break;
					}
					case 5:						//To see transaction details...
					{
						logger.info("Select a Customer ID to see Transaction History.");
						
						long customerID = getCustomerID(customersList);
						
						Map<Integer, Long> accountsList = getAccountsList(completeAccountsList, customerID);
						
						logger.info("Select Account number to see Transaction History.");
						
						long accountNo = getAccountNo(accountsList);
						
						List<TransactionDetails> transactionList = bank.getTransactionHistory(accountNo, customerID);
						
						printTransactionHistory(transactionList);
						
						break;
					}
					case 6:						//To add New User...
					{
						logger.info("Enter user Name.");
						String name = runner.getString();
						logger.info("Enter Mobile number.");
						long mobile = runner.getLong();
						logger.info("Enter email ID.");
						String emailID = runner.getString();
						logger.info("Enter date of Birth.");
						String dateOfBirth = getDateOfBirth();
						logger.info("Set password.");
						String password = runner.getString();
						logger.info("Enter user type.");
						String userType = runner.getString().toUpperCase();
						
						UserDetails details = new UserDetails();
						
						details.setName(name);
						details.setMobile(mobile);
						details.setEmailID(emailID);
						details.setDateOfBirth(dateOfBirth);
						details.setPassword(password);
						details.setUserType(userType);
						
						bank.addUser(userDetails);
						
						break;
						
					}
					case 0:						//To Logout Account...
					{
						boolean condition = false;
						do 
						{
							logger.info("Do you want to Logout? \nEnter Ok to Logout. \nEnter Cancel to continue.");
							String decision = runner.getString().toUpperCase();
							
							switch(decision)
							{
								case "OK":
								{
									break A;
								}
								case "CANCEL":
								{
									continue A;
								}
								default:
								{
									logger.info("Enter correct input.");
									condition = true;
								}
							}
						}while(condition);
					}
					default:
					{
						logger.info("Invalid case number.");
						break;
					}
				}
			}
			catch(InputMismatchException e)
			{
				logger.warning("Data type mismatch...");
				sc.nextLine();
			}
			catch (WrongEntryException e)
			{
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		BankUserLayer bank = new BankUserLayer();
		
		A:
		while(true)
		{
			try
			{
				logger.info("Enter User ID.");
				long userID = runner.getLong();
				logger.info("Enter Password.");
				String password = runner.getString();
				
				UserDetails userDetails = bank.userLogin(userID, password);				//User Details pojo object...
				
				logger.info("Login Successfull.");
				
				String userType = userDetails.getUserType();
				
				if(userType.equalsIgnoreCase("ADMIN"))
				{
					runner.admin(userDetails);
				}
				else if(userType.equalsIgnoreCase("CUSTOMER"))
				{
					runner.customer(userDetails);
				}
				
				logger.info("Do you want to Exit ? \nEnter 1 to Exit. \nEnter 2 to Continue.");
				int decision = runner.getInteger();
				
				boolean whileCondition = false;
				
				do
				{
					switch(decision)
					{
						case 1:
						{
							break A;
						}
						case 2:
						{
							continue A;
						}
						default:
						{
							logger.info("Please enter valid input.");
							whileCondition = true;
						}
					}
				}while(whileCondition);
				
			}
			catch (WrongEntryException e)
			{
				logger.info(e.getMessage());
				e.printStackTrace();
			}
			catch(InputMismatchException e)
			{
				logger.info("Invalid Data type.");
				e.printStackTrace();
				sc.nextLine();
			}
		}
	}
}
