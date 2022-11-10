package bankservlet;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banking.BankAdminLayer;
import banking.BankCustomerLayer;
import banking.BankUserLayer;
import datacarier.AccountDetails;
import datacarier.AccountRequestDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.TransactionRequestDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/myServlet")
public class BankServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public BankServlet()
    {
        
    }
    
    private Map<Long,Map<Long,AccountDetails>> getActiveAccountsMap(Map<Long,Map<Long,AccountDetails>> map, long customerID)
    {
    	Map<Long, AccountDetails> innerMap = map.get(customerID);
    	
    	Map<Long,Map<Long,AccountDetails>> map1 = new Hashtable<>();
    	
    	for(Map.Entry<Long, AccountDetails> entry : innerMap.entrySet())
			{
				AccountDetails accountDetails = entry.getValue();
				
				if(accountDetails.getAccountStatus().equals("ACTIVE"))
				{
					innerMap.put(entry.getKey(), accountDetails);
				}
				map1.put(customerID, innerMap);
			}
    	
    	return map1;
			
    }
    
    private Map<Integer, Long> getActiveAccountsList(Map<Long,Map<Long,AccountDetails>> map, long customerID)
	{
		Map<Integer, Long> accountsList = new Hashtable<>();
		
		Map<Long, AccountDetails> innerMap = map.get(customerID);
		
		int i = 1;
		
		for(Map.Entry<Long, AccountDetails> entry : innerMap.entrySet())
		{
			AccountDetails accountDetails = entry.getValue();
			
			if(accountDetails.getAccountStatus().equals("ACTIVE"))
			{
				long accountNo = accountDetails.getAccountNo();
				
				accountsList.put(i, accountNo);
				
				i++;
			}
		}
		
		return accountsList;
		
	}
    
    private Map<Integer, Long> getInactiveAccountsList(Map<Long,Map<Long,AccountDetails>> map, long customerID)
	{
		Map<Integer, Long> accountsList = new Hashtable<>();
		
		Map<Long, AccountDetails> innerMap = map.get(customerID);
		
		int i = 1;
		
		for(Map.Entry<Long, AccountDetails> entry : innerMap.entrySet())
		{
			AccountDetails accountDetails = entry.getValue();
			
			if(accountDetails.getAccountStatus().equals("INACTIVE"))
			{
				long accountNo = accountDetails.getAccountNo();
				
				accountsList.put(i, accountNo);
				
				i++;
			}
		}
		
		return accountsList;
		
	}
    
    private Map<Integer, Long> getAccountsList(Map<Long,Map<Long,AccountDetails>> map)
	{
		
		Map<Integer, Long> accountsList = new Hashtable<>();
		
		int i = 1;
		
		for(Map.Entry<Long,Map<Long,AccountDetails>> innerEntry : map.entrySet())
		{
			
			for(Map.Entry<Long,AccountDetails> entry : innerEntry.getValue().entrySet())
			{
				
				accountsList.put(i, entry.getKey());
				
				i++;
			}
		}
		
		return accountsList;
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		BankUserLayer bank = new BankUserLayer();
		String option = request.getParameter("action");
		String path = null;
		RequestDispatcher dispatcher;
		
		switch(option)
		{
			case "Login":
			{
				long userID = Long.parseLong(request.getParameter("userID"));
				String password = request.getParameter("password");
				try
				{
					UserDetails userDetails = bank.userLogin(userID, password);
					String userType = userDetails.getUserType();
					
					
					if(userType.equalsIgnoreCase("ADMIN"))
					{
						BankAdminLayer bankAdmin = new BankAdminLayer();
						Map<Long,Map<Long,AccountDetails>> completeAccountsList = bankAdmin.getcompleteAccountsList();
						Map<Integer, Long> activeAccountsList = getAccountsList(completeAccountsList);
						
						path = "JSP/admin.jsp";
						HttpSession session = request.getSession(true);
						session.setAttribute("userDetails", userDetails);
						session.setAttribute("activeAccountsList", activeAccountsList);
					}
					else if(userType.equalsIgnoreCase("CUSTOMER"))
					{
						BankCustomerLayer bankCus = new BankCustomerLayer();
						CustomerDetails customerDetails = bankCus.getCustomerDetails(userID);
						long customerID = customerDetails.getCustomerID();
						String customerStatus = customerDetails.getCustomerStatus();
						
						if(customerStatus.equalsIgnoreCase("ACTIVE"))
						{
							Map<Long,Map<Long,AccountDetails>> map = bankCus.getAccountDetails(customerID);
							
							Map<Integer, Long> activeAccountsList = getActiveAccountsList(map, customerID);
							
							Map<Integer, Long> inActiveAccountsList = getInactiveAccountsList(map, customerID);
							
							path = "JSP/customer.jsp";
							HttpSession session = request.getSession(true);
							session.setAttribute("userDetails", userDetails);
							session.setAttribute("customerDetails", customerDetails);
							session.setAttribute("activeAccountsList", activeAccountsList);
							session.setAttribute("inActiveAccountsList", inActiveAccountsList);
							
						}
						else if(customerStatus.equalsIgnoreCase("INACTIVE"))
						{
							request.setAttribute("userDetails", userDetails);
							request.setAttribute("customerDetails", customerDetails);
							path = "JSP/sendCustomerRequest.jsp";
							dispatcher = request.getRequestDispatcher(path);
							dispatcher.forward(request, response);
						}
					}
					
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch(WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/UserLogin.jsp");
					dispatcher.forward(request, response);
				}
				break;
			}
			case "Send Customer ID Request":
			{
				BankCustomerLayer bankCus = new BankCustomerLayer();
				long customerID = Long.parseLong(request.getParameter("customerID"));
				String customerStatus = request.getParameter("customerStatus");
				UserDetails userDetails = new UserDetails();
				userDetails.setUserID(customerID);
				String message = request.getParameter("description");
				try
				{
					bankCus.createCustomerIDRequest(userDetails, customerStatus, message);
					
					request.setAttribute("Message", "Request has been Submitted.");
					dispatcher = request.getRequestDispatcher("JSP/UserLogin.jsp");
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/UserLogin.jsp");
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Home":
			{
				path = "JSP/home.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Deposit":
			{
				path = "JSP/deposit.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Make Deposit":
			{
				HttpSession session = request.getSession(false);
				UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
				long customerID = userDetails.getUserID();
				
				BankCustomerLayer bankCus = new BankCustomerLayer();
				TransactionDetails transactionDetails = new TransactionDetails();
				try
				{
					Map<Long,Map<Long,AccountDetails>> map = bankCus.getAccountDetails(customerID);
					
					long toAccount = Long.parseLong(request.getParameter("accountNo"));
					double amount = Double.parseDouble(request.getParameter("amount"));
					AccountDetails accountDetails = map.get(customerID).get(toAccount);
					
					if(accountDetails.getAccountStatus().equalsIgnoreCase("ACTIVE"))
					{
						transactionDetails.setCustomerID(customerID);
						transactionDetails.setSecondaryAccount(toAccount);
						transactionDetails.setAmount(amount);
					
						bankCus.deposit(transactionDetails);
						request.setAttribute("Message", "Deposit Successfull.");
						dispatcher = request.getRequestDispatcher("JSP/deposit.jsp");
						dispatcher.forward(request, response);
					}
					else if(accountDetails.getAccountStatus().equalsIgnoreCase("INACTIVE"))
					{
						request.setAttribute("accountDetails", accountDetails);
						path = "JSP/sendAccountRequest.jsp";
						dispatcher = request.getRequestDispatcher(path);
						dispatcher.forward(request, response);
					}
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/deposit.jsp");
					dispatcher.forward(request, response);
				}
				break;
			}
			case "Admin Deposit":
			{
				path = "JSP/adminDeposit.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Admin Make Deposit":
			{
				BankAdminLayer bankAdmin = new BankAdminLayer();
				TransactionDetails transactionDetails = new TransactionDetails();
				try
				{
					long toAccount = Long.parseLong(request.getParameter("accountNo"));
					double amount = Double.parseDouble(request.getParameter("amount"));
					
					long customerID = bankAdmin.getCustomerID(toAccount);
					
					transactionDetails.setCustomerID(customerID);
					transactionDetails.setSecondaryAccount(toAccount);
					transactionDetails.setAmount(amount);
				
					bankAdmin.deposit(transactionDetails);
					request.setAttribute("Message", "Deposit Successfull.");
					dispatcher = request.getRequestDispatcher("JSP/adminDeposit.jsp");
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/adminDeposit.jsp");
					dispatcher.forward(request, response);
				}
				break;
			}
			case "Withdraw":
			{
				path = "JSP/withdraw.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Make Withdraw":
			{
				BankCustomerLayer bankCus = new BankCustomerLayer();
				
				HttpSession session = request.getSession(false);
				UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
				long customerID = userDetails.getUserID();
				try
				{
					Map<Long,Map<Long,AccountDetails>> map = bankCus.getAccountDetails(customerID);
					long fromAccount = Long.parseLong(request.getParameter("accountNo"));
					double amount = Double.parseDouble(request.getParameter("amount"));
					String description = request.getParameter("description");
					AccountDetails accountDetails = map.get(customerID).get(fromAccount);
					
					if(accountDetails.getAccountStatus().equalsIgnoreCase("ACTIVE"))
					{
						double balance = accountDetails.getBalance();
						if(balance >= amount)
						{
							TransactionRequestDetails transactionRequestDetails = new TransactionRequestDetails();
							
							transactionRequestDetails.setAccountNo(fromAccount);
							transactionRequestDetails.setAmount(amount);
							transactionRequestDetails.setCustomerID(customerID);
							transactionRequestDetails.setDescription(description);
							
							bankCus.createTransactionRequest(transactionRequestDetails);
							
							request.setAttribute("Message", "Withdraw Request has been Submitted.");
							dispatcher = request.getRequestDispatcher("JSP/withdraw.jsp");
							dispatcher.forward(request, response);
						}
						else
						{
							request.setAttribute("Message", "Insufficient balance to withdraw.");
							dispatcher = request.getRequestDispatcher("JSP/withdraw.jsp");
							dispatcher.forward(request, response);
						}
					}
					else if(accountDetails.getAccountStatus().equalsIgnoreCase("INACTIVE"))
					{
						request.setAttribute("accountDetails", accountDetails);
						path = "JSP/sendAccountRequest.jsp";
						dispatcher = request.getRequestDispatcher(path);
						dispatcher.forward(request, response);
					}
					
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/withdraw.jsp");
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Account Request":
			{
				path = "JSP/sendAccountRequest.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Send Account Request":
			{
				BankCustomerLayer bankCus = new BankCustomerLayer();
				
				HttpSession session = request.getSession(false);
				UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
				long customerID = userDetails.getUserID();
				try
				{
					Map<Long,Map<Long,AccountDetails>> map = bankCus.getAccountDetails(customerID);
					long accountNo = Long.parseLong(request.getParameter("accountNo"));
					String requestType = request.getParameter("requestType");
					AccountDetails accountDetails = map.get(customerID).get(accountNo);
					String message = null;
					if(requestType.equalsIgnoreCase("ACTIVATE"))
					{
						message = "Requesting to Activate.";
					}
					else if(requestType.equalsIgnoreCase("DEACTIVATE"))
					{
						message = "Requesting to Deactivate.";
					}
					
					bankCus.createAccountRequest(accountDetails, message);
					
					request.setAttribute("Message", "Request has been Submitted.");
					dispatcher = request.getRequestDispatcher("JSP/sendAccountRequest.jsp");
					dispatcher.forward(request, response);
					
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/sendAccountRequest.jsp");
					dispatcher.forward(request, response);
				}
				break;
			}
			case "Online Transfer":
			{
				path = "JSP/transfer.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Make Transfer":
			{
				BankCustomerLayer bankCus = new BankCustomerLayer();
				
				HttpSession session = request.getSession(false);
				UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
				long customerID = userDetails.getUserID();
				try
				{
					Map<Long,Map<Long,AccountDetails>> map = bankCus.getAccountDetails(customerID);
					long fromAccount = Long.parseLong(request.getParameter("fromAccountNo"));
					long toAccount = Long.parseLong(request.getParameter("toAccountNo"));
					double amount = Double.parseDouble(request.getParameter("amount"));
					String description = request.getParameter("description");
					AccountDetails fromAccountDetails = map.get(customerID).get(fromAccount);
					
					if(fromAccount == toAccount)
					{
						request.setAttribute("Message", "From Account and To Account should not be same.");
						dispatcher = request.getRequestDispatcher("JSP/transfer.jsp");
						dispatcher.forward(request, response);
					}
					
					if(fromAccountDetails.getAccountStatus().equalsIgnoreCase("ACTIVE"))
					{
						double balance = fromAccountDetails.getBalance();
						if(balance >= amount)
						{
							TransactionDetails transactionDetails = new TransactionDetails();
							
							transactionDetails.setPrimaryAccount(fromAccount);
							transactionDetails.setSecondaryAccount(toAccount);
							transactionDetails.setAmount(amount);
							transactionDetails.setCustomerID(customerID);
							transactionDetails.setRemarks(description);
							
							bankCus.onlineTransfer(transactionDetails);
							
							request.setAttribute("Message", "Transaction successfull.");
							dispatcher = request.getRequestDispatcher("JSP/transfer.jsp");
							dispatcher.forward(request, response);
						}
						else
						{
							request.setAttribute("Message", "Insufficient balance to make Transfer.");
							dispatcher = request.getRequestDispatcher("JSP/transfer.jsp");
							dispatcher.forward(request, response);
						}
					}
					else if(fromAccountDetails.getAccountStatus().equalsIgnoreCase("INACTIVE"))
					{
						request.setAttribute("accountDetails", fromAccountDetails);
						path = "JSP/sendAccountRequest.jsp";
						dispatcher = request.getRequestDispatcher(path);
						dispatcher.forward(request, response);
					}
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/transfer.jsp");
					dispatcher.forward(request, response);
				}
				break;
			}
			case "Profile":
			{
				path = "JSP/profile.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Update Profile":
			{
				long customerID = Long.parseLong(request.getParameter("userID"));
				String name = request.getParameter("name");
				long mobile = Long.parseLong(request.getParameter("mobile"));
				String email = request.getParameter("emailkID");
				
				UserDetails userDetails = new UserDetails();
				userDetails.setUserID(customerID);
				userDetails.setName(name);
				userDetails.setMobile(mobile);
				userDetails.setEmailID(email);
				
				try
				{
					bank.modifyUserDetails(userDetails);
					request.setAttribute("Message", "User Details Updated Successfully.");
					dispatcher = request.getRequestDispatcher("JSP/profile.jsp");
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher("JSP/profile.jsp");
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Change Password":
			{
				path = "JSP/changePassword.jsp";
				dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				break;
			}
			case "Update Password":
			{
				String oldPassword = request.getParameter("oldPassword");
				HttpSession session = request.getSession(false);
				UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
				String password = userDetails.getPassword();
				
				if(oldPassword.equals(password))
				{
					
					String newPassword = request.getParameter("newPassword");
					String confirmPassword = request.getParameter("confirmPassword");
					long customerID = Long.parseLong(request.getParameter("customerID"));
					
					if(newPassword.equals(confirmPassword))
					{
						try
						{
							bank.modifyPassword(customerID, oldPassword, newPassword);
							
							userDetails.setPassword(newPassword);
							
							request.setAttribute("Message", "Password Changed Successfully.");
							dispatcher = request.getRequestDispatcher("JSP/changePassword.jsp");
							dispatcher.forward(request, response);
							
						}
						catch (WrongEntryException e)
						{
							request.setAttribute("Message", e.getMessage());
							dispatcher = request.getRequestDispatcher("JSP/changePassword.jsp");
							dispatcher.forward(request, response);
						}
					}
					else
					{
						request.setAttribute("Message", "New Password mismatch.");
						dispatcher = request.getRequestDispatcher("JSP/changePassword.jsp");
						dispatcher.forward(request, response);
					}
				}
				else
				{
					request.setAttribute("Message", "Wrong Password.");
					dispatcher = request.getRequestDispatcher("JSP/changePassword.jsp");
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Account Details":
			{
				HttpSession session = request.getSession(false);
				UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
				long customerID = userDetails.getUserID();
				
				BankCustomerLayer bankCus = new BankCustomerLayer();
				try
				{
					Map<Long,Map<Long,AccountDetails>> map = bankCus.getAccountDetails(customerID);
					
					map = getActiveAccountsMap(map, customerID);
					
					request.setAttribute("completeAccountsMap", map);
					path = "JSP/completeAccountDetails.jsp";
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				break;
			}
			case "Complete Account Details":
			{
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					Map<Long,Map<Long,AccountDetails>> completeAccountsMap = bankAdmin.getcompleteAccountsList();
					
					request.setAttribute("completeAccountsMap", completeAccountsMap);
					path = "JSP/completeAccountDetails.jsp";
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					e.printStackTrace();
				}
				
				break;
			}
			case "Account Statement":
			{
				path = "JSP/statement.jsp";
				
				if(request.getParameter("accountNo") == null)
				{
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				else
				{
					long accountNo = Long.parseLong(request.getParameter("accountNo"));
					
					BankCustomerLayer bankCus = new BankCustomerLayer();
					try
					{
						List<TransactionDetails> transactionList = bankCus.getTransactionHistory(accountNo);
						
						request.setAttribute("accountNo", accountNo);
						request.setAttribute("transactionList", transactionList);
						dispatcher = request.getRequestDispatcher(path);
						dispatcher.forward(request, response);
					}
					catch (WrongEntryException e)
					{
						request.setAttribute("Message", e.getMessage());
						dispatcher = request.getRequestDispatcher(path);
						dispatcher.forward(request, response);
					}
				}
				
				break;
			}
			case "Add New User":
			{
				if(request.getParameter("dateOfBirth") == null)
				{
					path = "JSP/addNewUser.jsp";
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				String name = request.getParameter("name");
				long mobile = Long.parseLong(request.getParameter("mobile"));
				String emailID = request.getParameter("emailID");
				String dateOfBirth = request.getParameter("dateOfBirth");
				String userType = request.getParameter("userType");
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("confirmPassword");
				
				if(password.equals(confirmPassword))
				{
					UserDetails details = new UserDetails();
					details.setName(name);
					details.setMobile(mobile);
					details.setEmailID(emailID);
					details.setDateOfBirth(dateOfBirth);
					details.setPassword(password);
					details.setUserType(userType);
					try
					{
						BankAdminLayer bankAdmin = new BankAdminLayer();
						
						UserDetails userDetails = bankAdmin.addUser(details);
						
						request.setAttribute("userDetails", userDetails);
						path = "JSP/newUserDetails.jsp";
						dispatcher = request.getRequestDispatcher(path);
						dispatcher.forward(request, response);
					}
					catch (WrongEntryException e)
					{
						request.setAttribute("Message", e.getMessage());
						dispatcher = request.getRequestDispatcher("JSP/addNewUser.jsp");
						dispatcher.forward(request, response);
					}
				}
				else
				{
					request.setAttribute("Message", "Password Mismatch.");
					dispatcher = request.getRequestDispatcher("JSP/addNewUser.jsp");
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Account Requests":
			{
				path = "JSP/accountRequest.jsp";
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					Map<Integer,AccountRequestDetails> accountRequestList = bankAdmin.getAccountRequests();
					request.setAttribute("accountRequestMap", accountRequestList);
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Respond To Account Requests":
			{
				long requestID = Long.parseLong(request.getParameter("requestID"));
				long customerID = Long.parseLong(request.getParameter("customerID"));
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				String accountStatus = request.getParameter("accountStatus");
				String status = request.getParameter("status");
				String description = request.getParameter("description");
				
				AccountRequestDetails accountRequestDetails = new AccountRequestDetails();
				
				accountRequestDetails.setRequestID(requestID);
				accountRequestDetails.setCustomerID(customerID);
				accountRequestDetails.setAccountNo(accountNo);
				accountRequestDetails.setAccountStatus(accountStatus);
				accountRequestDetails.setStatus(status);
				accountRequestDetails.setDescription(description);
				
				path = "JSP/accountRequest.jsp";
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					bankAdmin.updateAccountRequest(accountRequestDetails);
					
					Map<Integer,AccountRequestDetails> accountRequestList = bankAdmin.getAccountRequests();
					
					request.setAttribute("accountRequestMap", accountRequestList);
					request.setAttribute("Message", "Updated Successfully.");
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Customer Requests":
			{
				path = "JSP/customerRequest.jsp";
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					Map<Integer,AccountRequestDetails> customerIDRequestList = bankAdmin.getCustomerIDRequests();
					
					request.setAttribute("customerIDRequestMap", customerIDRequestList);
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Respond To Customer Requests":
			{
				long requestID = Long.parseLong(request.getParameter("requestID"));
				long customerID = Long.parseLong(request.getParameter("customerID"));
				String customerStatus = request.getParameter("customerStatus");
				String status = request.getParameter("status");
				String description = request.getParameter("description");
				
				AccountRequestDetails accountRequestDetails = new AccountRequestDetails();
				
				accountRequestDetails.setRequestID(requestID);
				accountRequestDetails.setCustomerID(customerID);
				accountRequestDetails.setCustomerStatus(customerStatus);
				accountRequestDetails.setStatus(status);
				accountRequestDetails.setDescription(description);
				
				path = "JSP/customerRequest.jsp";
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					bankAdmin.updateAccountRequest(accountRequestDetails);
					
					Map<Integer,AccountRequestDetails> accountRequestList = bankAdmin.getAccountRequests();
					
					request.setAttribute("accountRequestMap", accountRequestList);
					request.setAttribute("Message", "Updated Successfully.");
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Transaction Requests":
			{
				path = "JSP/transactionRequest.jsp";
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					Map<Integer,TransactionRequestDetails> transactionRequestList = bankAdmin.getTransactionRequests();
					
					request.setAttribute("transactionRequestMap", transactionRequestList);
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Respond To Transaction Requests":
			{
				long requestID = Long.parseLong(request.getParameter("requestID"));
				long customerID = Long.parseLong(request.getParameter("customerID"));
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				double amount = Double.parseDouble(request.getParameter("amount"));
				String status = request.getParameter("status");
				String description = request.getParameter("description");
				
				TransactionRequestDetails transactionRequestDetails = new TransactionRequestDetails();
				
				transactionRequestDetails.setRequestID(requestID);
				transactionRequestDetails.setCustomerID(customerID);
				transactionRequestDetails.setAccountNo(accountNo);
				transactionRequestDetails.setAmount(amount);
				transactionRequestDetails.setStatus(status);
				transactionRequestDetails.setDescription(description);
				
				path = "JSP/transactionRequest.jsp";
				BankAdminLayer bankAdmin = new BankAdminLayer();
				try
				{
					bankAdmin.withdraw(transactionRequestDetails);
					
					Map<Integer,TransactionRequestDetails> transactionRequestList = bankAdmin.getTransactionRequests();
					
					request.setAttribute("transactionRequestMap", transactionRequestList);
					request.setAttribute("Message", "Updated Successfully.");
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				catch (WrongEntryException e)
				{
					request.setAttribute("Message", e.getMessage());
					dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
				
				break;
			}
			case "Logout":
			{
				HttpSession session = request.getSession(false);
				session.invalidate();
				path = "JSP/UserLogin.jsp";
				response.sendRedirect(path);
				break;
			}
		}
		
	}

}
