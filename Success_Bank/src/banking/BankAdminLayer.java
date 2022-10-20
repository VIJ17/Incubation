package banking;

import java.util.Map;

import datacarier.AccountDetails;
import datacarier.TransactionDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import util.InputCheck;

public class BankAdminLayer extends BankCustomerLayer
{
	
	InputCheck check = new InputCheck();
	BankDataBase db = new BankDataBase();
	
	public Map<Long,Map<Long,AccountDetails>> getcompleteAccountsList() throws WrongEntryException
	{
		Map<Long,Map<Long,AccountDetails>> completeAccountsList = db.getcompleteAccountsList();
		
		return completeAccountsList;
	}
	
	//Specific to manager (OVERLOADED)
//	public Map<Long, Map<Long, AccountDetails>> getAccountDetails(long customerID) throws WrongEntryException
//	{
//		
//		Map<Long, Map<Long, AccountDetails>> map = db.getAccountDetails(customerID);
//		
//		return map;
//	}
	
	//Specific to manager (OVERLOADED)
	public double getBalance(long accountNo) throws WrongEntryException
	{
		double balance = db.getBalance(accountNo);
		
		return balance;
	}
	
	public void deposit(TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		db.deposit(transactionDetails);
			
	}
	
	public void addUser(UserDetails userDetails) throws WrongEntryException
	{
		
		db.addUser(userDetails);
		
	}
	
}
