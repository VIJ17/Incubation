package banking;

import java.util.List;
import java.util.Map;

import datacarier.AccountDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.TransactionRequestDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public class BankCustomerLayer extends BankUserLayer
{
	
	public CustomerDetails getCustomerDetails(long customerID) throws WrongEntryException		//updated
	{
		CustomerDetails customerDetails = bankInterf.getCustomerDetails(customerID);
		
		return customerDetails;
	}
	
	public Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID) throws WrongEntryException
	{
		
		Map<Long,Map<Long,AccountDetails>> map = bankInterf.getAccountDetails(customerID);
		
		return map;
	}

	public void deposit(TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		bankInterf.deposit(transactionDetails);
			
	}

	public void onlineTransfer(TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		bankInterf.onlineTransfer(transactionDetails);
		
	}
	
	public List<TransactionDetails> getTransactionHistory(long accountNo) throws WrongEntryException
	{
		
		List<TransactionDetails> transactionList = bankInterf.getTransactionHistory(accountNo);
		
		return transactionList;
	}
	
	public void createCustomerIDRequest(UserDetails userDetails, String customerStatus, String message) throws WrongEntryException
	{
		
		bankInterf.createCustomerIDRequest(userDetails, customerStatus, message);
		
	}
	
	public void createAccountRequest(AccountDetails accountDetails, String message) throws WrongEntryException
	{
		
		bankInterf.createAccountRequest(accountDetails, message);
		
	}
	
	public void createTransactionRequest(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException
	{
		
		bankInterf.createTransactionRequest(transactionRequestDetails);
		
	}
	
}
