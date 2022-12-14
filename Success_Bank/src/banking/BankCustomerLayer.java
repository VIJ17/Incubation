package banking;

import java.util.List;
import java.util.Map;

import datacarier.AccountDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.TransactionRequestDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import util.InputCheck;

public class BankCustomerLayer extends BankUserLayer
{
	private InputCheck check = new InputCheck();
	
	public CustomerDetails getCustomerDetails(long customerID) throws WrongEntryException		//updated
	{
		CustomerDetails customerDetails = bankInterf.getCustomerDetails(customerID);
		
		return customerDetails;
	}
	
	public Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID, String password) throws WrongEntryException
	{
		check.nullCheck(password);
		
		Map<Long,Map<Long,AccountDetails>> map = bankInterf.getAccountDetails(customerID, password);
		
		return map;
	}

	public double getBalance(long accountNo, String password) throws WrongEntryException
	{
		check.nullCheck(password);
		
		double balance = bankInterf.getBalance(accountNo, password);
		
		return balance;
	}

	public void deposit(TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		bankInterf.deposit(transactionDetails);
			
	}

	public double withdraw(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException
	{
		
		double balance = bankInterf.withdraw(transactionRequestDetails);
			
		return balance;
	}
	
	public void onlineTransfer(TransactionDetails transactionDetails, String password) throws WrongEntryException
	{
		check.nullCheck(password);
		
		bankInterf.onlineTransfer(transactionDetails, password);
		
	}
	
	public List<TransactionDetails> getTransactionHistory(long accountNo) throws WrongEntryException
	{
		
		List<TransactionDetails> transactionList = bankInterf.getTransactionHistory(accountNo);
		
		return transactionList;
	}
	
	public void createCustomerIDRequest(UserDetails userDetails, String message) throws WrongEntryException
	{
		
		bankInterf.createCustomerIDRequest(userDetails, message);
		
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
