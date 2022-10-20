package interfacemodule;

import java.util.List;
import java.util.Map;

import datacarier.AccountDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public interface BankingInterface
{
	
	UserDetails userLogin(long customerID, String password) throws WrongEntryException;
	
	Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID, String password) throws WrongEntryException;
	
	double getBalance(long accountNo, String password) throws WrongEntryException;
	
	void deposit(TransactionDetails transactionDetails) throws WrongEntryException;
	
	double withdraw(TransactionDetails transactionDetails, String password) throws WrongEntryException;
	
	void onlineTransfer(TransactionDetails transactionDetails, String password) throws WrongEntryException;

	List<TransactionDetails> getTransactionHistory(long accountNo, long customerID) throws WrongEntryException;

	CustomerDetails getCustomerDetails(long customerID) throws WrongEntryException;
	
	void modifyUserDetails(UserDetails userDetails) throws WrongEntryException;
	
	void modifyPassword(long userID, String oldPassword, String newPassword) throws WrongEntryException;
	
	public void addUser(UserDetails userDetails) throws WrongEntryException;
	
}
