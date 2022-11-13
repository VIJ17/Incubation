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
	
	Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID) throws WrongEntryException;
	
	double getBalance(long accountNo) throws WrongEntryException;
	
	void deposit(TransactionDetails transactionDetails) throws WrongEntryException;
	
	double withdraw(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException;
	
	void onlineTransfer(TransactionDetails transactionDetails) throws WrongEntryException;
	
	List<TransactionDetails> getTransactionHistory(long accountNo) throws WrongEntryException;
	
	CustomerDetails getCustomerDetails(long customerID) throws WrongEntryException;
	
	void modifyUserDetails(UserDetails userDetails) throws WrongEntryException;
	
	void modifyPassword(long userID, String oldPassword, String newPassword) throws WrongEntryException;
	
	UserDetails addUser(UserDetails userDetails) throws WrongEntryException;
	
	AccountDetails addAccount(AccountDetails accountDetails) throws WrongEntryException;
	
	void createCustomerIDRequest(UserDetails userDetails, String customerStatus, String message) throws WrongEntryException;
	
	void createAccountRequest(AccountDetails accountDetails, String message) throws WrongEntryException;
	
	Map<Integer,AccountRequestDetails> getCustomerIDRequests() throws WrongEntryException;
	
	Map<Integer, AccountRequestDetails> getAccountRequests() throws WrongEntryException;
	
	void createTransactionRequest(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException;
	
	Map<Integer, TransactionRequestDetails> getTransactionRequests() throws WrongEntryException;
	
}
