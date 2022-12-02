package bankservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import banking.BankAdminLayer;
import banking.BankCustomerLayer;
import banking.BankUserLayer;
import datacarier.AccountDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

@WebServlet("/BankServlet")
public class TestBankServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public TestBankServlet()
    {
        super();
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
		Long customerID = Long.parseLong(request.getParameter("customerID"));
		BankAdminLayer bankAdmin = new BankAdminLayer();
		
		try
		{
			Map<Long, Map<Long, AccountDetails>> completeAccountsList = bankAdmin.getcompleteAccountsList();
			Map<Long,AccountDetails> accountsList = completeAccountsList.get(customerID);
			
			JSONObject jsonObj = new JSONObject(accountsList);
			String jsonObjStr = jsonObj.toString();
			
			response.getWriter().write(jsonObjStr);
			
		}
		catch (WrongEntryException e)
		{
			String str = "Error!";
			response.getWriter().write(str);
		}
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BankUserLayer bank = new BankUserLayer();
		BufferedReader buff = request.getReader();
		String data = buff.readLine();
		StringBuffer strBuff = new StringBuffer();
		if(data != null)
		{
			strBuff.append(data);
		}
		JSONObject jsonObj = new JSONObject(strBuff.toString());
		String option = jsonObj.optString("action");
		
		switch(option)
		{
			case "Login":
			{
				long userID = Long.parseLong(jsonObj.optString("userID"));
				String password = jsonObj.optString("password");
				try
				{
					UserDetails userDetails = bank.userLogin(userID, password);
					String userType = userDetails.getUserType();
					String urlPath = "";
					
					if(userType.equalsIgnoreCase("ADMIN"))
					{
						BankAdminLayer bankAdmin = new BankAdminLayer();
						Map<Long,Map<Long,AccountDetails>> completeAccountsList = bankAdmin.getcompleteAccountsList();
						Map<Integer, Long> activeAccountsList = getAccountsList(completeAccountsList);
						
						HttpSession session = request.getSession(true);
						session.setAttribute("userDetails", userDetails);
						session.setAttribute("activeAccountsList", activeAccountsList);
						urlPath = "{ path : admin.html}";
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
							
							HttpSession session = request.getSession(true);
							session.setAttribute("userDetails", userDetails);
							session.setAttribute("customerDetails", customerDetails);
							session.setAttribute("activeAccountsList", activeAccountsList);
							session.setAttribute("inActiveAccountsList", inActiveAccountsList);
							urlPath = "{ path : customer.html}";
							
						}
						else if(customerStatus.equalsIgnoreCase("INACTIVE"))
						{
							request.setAttribute("userDetails", userDetails);
							request.setAttribute("customerDetails", customerDetails);
//							path = "JSP/sendCustomerRequest.jsp";
//							dispatcher = request.getRequestDispatcher(path);
//							dispatcher.forward(request, response);
						}
					}
					
					JSONObject jsonObj1 = new JSONObject(urlPath);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
				}
				catch(WrongEntryException e)
				{
					String message = "{message : " + e.getMessage() + "}";
					JSONObject jsonObj1 = new JSONObject(message);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
				}
				break;
			}
			case "getName" :
			{
				HttpSession session = request.getSession(false);
				if(session != null)
				{
					UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
					Map<String, UserDetails> map = new Hashtable<>();
					map.put("userDetails", userDetails);
					JSONObject jsonObj1 = new JSONObject(map);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
					break;
				}
			}
			case "getActiveAccounts" :
			{
				HttpSession session = request.getSession(false);
				if(session != null)
				{
					Map<Integer, Long> activeAccountsList = (Map<Integer, Long>) session.getAttribute("activeAccountsList");
					JSONObject jsonObj1 = new JSONObject(activeAccountsList);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
				}
				else
				{
					String urlPath = "{ path : UserLogin.html}";
					JSONObject jsonObj1 = new JSONObject(urlPath);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
				}
				break;
			}
			case "Admin Deposite" :
			{
				BankAdminLayer bankAdmin = new BankAdminLayer();
				TransactionDetails transactionDetails = new TransactionDetails();
				try
				{
					long toAccount = Long.parseLong(jsonObj.optString("accountNo"));
					double amount = Double.parseDouble(jsonObj.optString("amount"));
					
					long customerID = bankAdmin.getCustomerID(toAccount);
					
					transactionDetails.setCustomerID(customerID);
					transactionDetails.setSecondaryAccount(toAccount);
					transactionDetails.setAmount(amount);
				
					bankAdmin.deposit(transactionDetails);
					request.setAttribute("Message", "Deposit Successfull.");
					String message = "{message : Deposit Successfull.}";
					JSONObject jsonObj1 = new JSONObject(message);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
				}
				catch (WrongEntryException e)
				{
					String message = "{message : " + e.getMessage() + "}";
					JSONObject jsonObj1 = new JSONObject(message);
					String jsonObjStr = jsonObj1.toString();
					response.getWriter().write(jsonObjStr);
				}
				break;
			}
			case "Logout" :
			{
				HttpSession session = request.getSession(false);
				if(session != null)
				{
					session.invalidate();
				}
				String urlPath = "{ path : UserLogin.html}";
				JSONObject jsonObj1 = new JSONObject(urlPath);
				String jsonObjStr = jsonObj1.toString();
				response.getWriter().write(jsonObjStr);
			}
		}
	}

}
