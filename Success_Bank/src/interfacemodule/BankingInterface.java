package interfacemodule;

import java.util.List;
import java.util.Map;

import datacarier.AccountDetails;
import datacarier.AccountRequestDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.TransactionRequestDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public interface BankingInterface
{
	
	UserDetails userLogin(long customerID, String password) throws WrongEntryException;
	
	Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID, String password) throws WrongEntryException;
	
	double getBalance(long accountNo, String password) throws WrongEntryException;
	
	void deposit(TransactionDetails transactionDetails) throws WrongEntryException;
	
	double withdraw(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException;
	
	void onlineTransfer(TransactionDetails transactionDetails, String password) throws WrongEntryException;

	List<TransactionDetails> getTransactionHistory(long accountNo, long customerID) throws WrongEntryException;

	CustomerDetails getCustomerDetails(long customerID) throws WrongEntryException;
	
	void modifyUserDetails(UserDetails userDetails) throws WrongEntryException;
	
	void modifyPassword(long userID, String oldPassword, String newPassword) throws WrongEntryException;
	
	void addUser(UserDetails userDetails) throws WrongEntryException;
	
	void createCustomerIDRequest(UserDetails userDetails, String message) throws WrongEntryException;
	
	void createAccountRequest(AccountDetails accountDetails, String message) throws WrongEntryException;

	Map<Integer, AccountRequestDetails> getAccountRequests() throws WrongEntryException;

	void createTransactionRequest(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException;

	Map<Integer, TransactionRequestDetails> getTransactionRequests() throws WrongEntryException;
	
}
