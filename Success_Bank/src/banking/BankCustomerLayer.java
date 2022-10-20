package banking;

import java.util.List;
import java.util.Map;

import datacarier.AccountDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import exceptions.WrongEntryException;
import interfacemodule.BankingInterface;
import util.InputCheck;

public class BankCustomerLayer extends BankUserLayer
{
	private InputCheck check = new InputCheck();
	private BankingInterface bankInterf = new BankDataBase();
	
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

	public double withdraw(TransactionDetails transactionDetails, String password) throws WrongEntryException
	{
		check.nullCheck(password);
		
		long fromAccount = transactionDetails.getFromAccount();
		
		double balance = bankInterf.withdraw(transactionDetails, password);
			
		balance = bankInterf.getBalance(fromAccount, password);
		
		return balance;
	}
	
	public void onlineTransfer(TransactionDetails transactionDetails, String password) throws WrongEntryException
	{
		check.nullCheck(password);
		
		bankInterf.onlineTransfer(transactionDetails, password);
		
	}
	
	public List<TransactionDetails> getTransactionHistory(long accountNo, long customerID) throws WrongEntryException
	{
		
		List<TransactionDetails> transactionList = bankInterf.getTransactionHistory(accountNo, customerID);
		
		return transactionList;
	}
	
}
