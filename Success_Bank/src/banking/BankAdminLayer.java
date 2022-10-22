package banking;

import java.util.Map;

import datacarier.AccountDetails;
import datacarier.AccountRequestDetails;
import datacarier.TransactionRequestDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public class BankAdminLayer extends BankCustomerLayer
{
	
//	private InputCheck check = new InputCheck();
	private BankDataBase db = new BankDataBase();
	
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
	
	public long addUser(UserDetails userDetails) throws WrongEntryException
	{
		
		long userID = db.addUser(userDetails);
		
		return userID;
		
	}
	
	public Map<Integer,AccountRequestDetails> getAccountRequests() throws WrongEntryException
	{
		
		Map<Integer,AccountRequestDetails> requestList = bankInterf.getAccountRequests();
		
		return requestList;
	}
	
	public Map<Integer,TransactionRequestDetails> getTransactionRequests() throws WrongEntryException
	{
		
		Map<Integer,TransactionRequestDetails> requestList = bankInterf.getTransactionRequests();
		
		return requestList;
		
	}
	
	public void updateRejectedTransaction(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException
	{
		
		db.updateRejectedTransaction(transactionRequestDetails);
		
	}
	
}
