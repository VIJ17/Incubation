package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import datacarier.AccountDetails;
import datacarier.AccountRequestDetails;
import datacarier.CustomerDetails;
import datacarier.TransactionDetails;
import datacarier.TransactionRequestDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import interfacemodule.BankingInterface;

public class BankDataBase implements BankingInterface
{
	private String url = "jdbc:mysql://localhost/Success_Bank";
	private String userName = "root";
	private String password = "Root@123";
	
	public void closeStatement(PreparedStatement stmt)
	{
		try
		{
			stmt.close();
		}
		catch(Exception e) {}
	}
	
	public void closeConnection(Connection connection)
	{
		try
		{
			connection.close();
		}
		catch(Exception e) {}
	}
	
	private Connection createConnection() throws SQLException
	{
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		return connection;
	
	}
	
	private PreparedStatement createPreparedStatement(String sql, Connection connection) throws SQLException
	{
		
		PreparedStatement stmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		return stmt;
	
	}
	
	private void dataAvailabilityCheck(ResultSet result) throws WrongEntryException, SQLException
	{
		if(result.next() == false)
		{
			throw new WrongEntryException("User ID or Password is incorrect.");
		}
		
	}
	
	private Map<Long,Map<Long,AccountDetails>>  convertResultToMap(ResultSet result) throws SQLException
	{
		Map<Long,Map<Long,AccountDetails>> map = new Hashtable<>();;
		
		Map<Long, AccountDetails> innerMap = null;
		
		while(result.next())
		{
			AccountDetails details = new AccountDetails();
			
			details.setCustomerID(result.getLong("CUSTOMER_ID"));
			details.setAccountNo(result.getLong("ACCOUNT_NO"));
			details.setAccountType(result.getString("ACC_TYPE"));
			details.setAccountStatus(result.getString("ACC_STATUS"));
			details.setIfscCode(result.getString("IFSC_CODE"));
			details.setBranch(result.getString("BRANCH"));
			details.setBalance(result.getDouble("BALANCE"));
			
			if(map.get(result.getLong("CUSTOMER_ID")) == null)
			{
				innerMap = new Hashtable<>();
			}
			
			innerMap.put(result.getLong("ACCOUNT_NO"), details);
			
			map.put(result.getLong("CUSTOMER_ID"), innerMap);
			
		}
		
		return map;
	}
	
	@Override
	public CustomerDetails getCustomerDetails(long customerID) throws WrongEntryException
	{
		
		String sql = "SELECT * FROM CUSTOMER_DETAILS WHERE CUSTOMER_ID = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, customerID);
			
			ResultSet result = stmt.executeQuery();
			
			CustomerDetails customerDetails = new CustomerDetails();
			
			while(result.next())
			{
				
				customerDetails.setCustomerID(result.getLong("CUSTOMER_ID"));
				customerDetails.setPanNo(result.getString("PAN_NO"));
				customerDetails.setAadharNo(result.getLong("AADHAR_NO"));
				customerDetails.setAddress(result.getString("ADDRESS"));
				customerDetails.setCustomerStatus(result.getString("CUS_STATUS"));
				
			}
			
			return customerDetails;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	private void checkAccountStatus(long accountNo) throws WrongEntryException
	{
		String sql = "SELECT ACC_STATUS FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, accountNo);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			String accountStatus = result.getString("ACC_STATUS");
			
			if(!(accountStatus.equalsIgnoreCase("ACTIVE")))
			{
				throw new WrongEntryException("Account is Blocked. \nContact Admin to unblock.");
			}
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public UserDetails userLogin(long userID, String password) throws WrongEntryException
	{
		
		String sql = "SELECT * FROM USER_DETAILS WHERE USER_ID = ? AND PASSWORD = ?";
//		SELECT * FROM USER_DETAILS WHERE USER_ID = 1 AND PASSWORD = 'Vijay@17.';
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, userID);
			stmt.setString(2, password);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			result.beforeFirst();
			
			UserDetails userDetails = getUserDetails(result);
			
			return userDetails;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
////Specific to Admin...
//	public boolean adminLogin(long userID, String password) throws WrongEntryException
//	{
//		
//		String sql = "SELECT * FROM USER_DETAILS WHERE USER_TYPE = 'ADMIN' AND USER_ID = ? AND PASSWORD = ?";
////		SELECT * FROM USER_DETAILS WHERE USER_TYPE = 'ADMIN' AND USER_ID = 1 AND PASSWORD = 'Vijay@17.';
//		
//		Connection connection = null;
//		PreparedStatement stmt = null;
//		
//		try
//		{
//			connection = createConnection();
//			
//			stmt = createPreparedStatement(sql, connection);
//			
//			stmt.setLong(1, userID);
//			stmt.setString(2, password);
//			
//			ResultSet result = stmt.executeQuery();
//			
//			if(result.next())
//			{
//				return true;
//			}
//			
//			return false;
//			
//		}
//		catch(SQLException e)
//		{
//			throw new WrongEntryException(e);
//		}
//		
//	}
	
	@Override
	public Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID) throws WrongEntryException
	{
		
		String sql = "SELECT * FROM ACCOUNT_DETAILS WHERE CUSTOMER_ID = ?";
//		SELECT * FROM ACCOUNT_DETAILS WHERE CUSTOMER_ID = 2;		
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, customerID);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			result.beforeFirst();
			
			Map<Long,Map<Long,AccountDetails>> map = convertResultToMap(result);
			
			return map;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
////Specific to Admin(OVERLOADED)	
//	public Map<Long,Map<Long,AccountDetails>> getAccountDetails(long customerID) throws WrongEntryException
//	{
//		String sql = "SELECT * FROM ACCOUNT_DETAILS WHERE CUSTOMER_ID = ?";
//		
//		Connection connection = null;
//		PreparedStatement stmt = null;
//		
//		try
//		{
//			connection = createConnection();
//			
//			stmt = createPreparedStatement(sql, connection);
//			
//			stmt.setLong(1, customerID);
//			
//			ResultSet result = stmt.executeQuery();
//			
//			Map<Long,Map<Long,AccountDetails>> map = convertResultToMap(result);
//			
//			return map;
//		}
//		catch(SQLException e)
//		{
//			throw new WrongEntryException(e);
//		}
//		finally
//		{
//			closeStatement(stmt);
//			closeConnection(connection);
//		}
//		
//	}
	
	@Override
	public double getBalance(long accountNo) throws WrongEntryException
	{
		String sql = "SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, accountNo);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			double balance = result.getLong("BALANCE");
			
			return balance;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
//	@Override
//	public double getBalance(long accountNo, String password) throws WrongEntryException
//	{
//		
//		checkAccountStatus(accountNo);
//		
//		String sql = "SELECT ACCOUNT_DETAILS.BALANCE FROM ACCOUNT_DETAILS INNER JOIN USER_DETAILS ON ACCOUNT_DETAILS.CUSTOMER_ID = USER_DETAILS.USER_ID WHERE ACCOUNT_DETAILS.ACCOUNT_NO = ? AND USER_DETAILS.PASSWORD = ?";
////		SELECT ACCOUNT_DETAILS.BALANCE FROM ACCOUNT_DETAILS INNER JOIN USER_DETAILS ON ACCOUNT_DETAILS.CUSTOMER_ID = USER_DETAILS.USER_ID WHERE ACCOUNT_DETAILS.ACCOUNT_NO = 1621000008120 AND USER_DETAILS.PASSWORD = 'Anzar@09.';	
//		
//		Connection connection = null;
//		PreparedStatement stmt = null;
//		
//		try
//		{
//			connection = createConnection();
//			
//			stmt = createPreparedStatement(sql, connection);
//			
//			stmt.setLong(1, accountNo);
//			stmt.setString(2, password);
//			
//			ResultSet result = stmt.executeQuery();
//			
//			dataAvailabilityCheck(result);
//			
//			double balance = result.getLong("BALANCE");
//			
//			return balance;
//		}
//		catch(SQLException e)
//		{
//			throw new WrongEntryException(e);
//		}
//		finally
//		{
//			closeStatement(stmt);
//			closeConnection(connection);
//		}
//	}
	
	public long getCustomerID(long accountNo) throws WrongEntryException
	{
		String sql = "SELECT CUSTOMER_ID FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, accountNo);
			
			ResultSet result = stmt.executeQuery();
			
			result.next();
		
			long receiverCustomerID = result.getLong("CUSTOMER_ID");
			
			return receiverCustomerID;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	@Override
	public void deposit(TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		long toAccount = transactionDetails.getSecondaryAccount();
		double amount = transactionDetails.getAmount();
		long customerID = transactionDetails.getCustomerID();
		String remarks = transactionDetails.getRemarks();
		
		checkAccountStatus(toAccount);
		
		String sql = "SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
//		SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = 1621000008120;
		
		Connection connection = null;
		PreparedStatement stmt = null;
		Savepoint S1 = null;
		
		try
		{
			connection = createConnection();
			
			connection.setAutoCommit(false);
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, toAccount);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			double balance = result.getLong("BALANCE");
			
			balance = balance + amount;
			
			closeStatement(stmt);
			
			sql = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
//			UPDATE ACCOUNT_DETAILS SET BALANCE = 10000 WHERE ACCOUNT_NO = 1621000008119
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setDouble(1, balance);
			stmt.setLong(2, toAccount);
			
			S1 = connection.setSavepoint();
			
			stmt.execute();
			
			closeStatement(stmt);
			
////////////////////////////////////Updating Transaction Details////////////////////////////////////
			
			sql = "INSERT INTO TRANSACTION_DETAILS (CUSTOMER_ID, REFERENCE_ID, PRIMARY_ACC, AMOUNT, CLOSING_BALANCE, TRANSACTION_TIME, MODE_OF_TRANSACTION, TYPE, STATUS, REMARKS) VALUES (?, ? ,? ,? ,? ,? ,?, ?, ?, ?)";
			
			stmt = createPreparedStatement(sql, connection);
			
			long millisecond = System.currentTimeMillis();
			String referenceID = "REF" + millisecond;
			
			stmt.setLong(1, customerID);
			stmt.setString(2, referenceID);
			stmt.setLong(3, toAccount);
			stmt.setDouble(4, amount);
			stmt.setDouble(5, balance);
			stmt.setLong(6, millisecond);
			stmt.setString(7, "DEPOSIT");
			stmt.setString(8, "CREDIT");
			stmt.setString(9, "SUCCESS");
			stmt.setString(10, remarks);
			
			stmt.execute();
			
			connection.commit();
			
		}
		catch (SQLException e)
		{
			try
			{
				connection.rollback(S1);
			}
			catch (SQLException e1)
			{
				throw new WrongEntryException("Failed to Roll Back.", e);
			}
			
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public double withdraw(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException
	{
		
		long fromAccount = transactionRequestDetails.getAccountNo();
		double amount = transactionRequestDetails.getAmount();
		long customerID = transactionRequestDetails.getCustomerID();
		String remarks = transactionRequestDetails.getDescription();
		long requestID = transactionRequestDetails.getRequestID();
		String status = transactionRequestDetails.getStatus();
		
		checkAccountStatus(fromAccount);
		
		Connection connection = null;
		PreparedStatement stmt = null;
		Savepoint S1 = null;
		String sql = null;
		
		try
		{
			double balance = getBalance(fromAccount);
			
			connection = createConnection();
			
			connection.setAutoCommit(false);
			
			if(status.equals("APPROVED"))
			{
				sql = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
//				UPDATE ACCOUNT_DETAILS SET BALANCE = 2500000 WHERE ACCOUNT_NO = 1621000008119;
				
				if(balance >= amount)
				{
					balance = balance - amount;
					
					stmt = createPreparedStatement(sql, connection);
					
					stmt.setDouble(1, balance);
					stmt.setLong(2, fromAccount);
					
					S1 = connection.setSavepoint();
					
					stmt.execute();
					
				}
				else
				{
					throw new WrongEntryException("Insufficient balance to withdraw. \nTransaction Failed.");
				}
				
				closeStatement(stmt);
			}
			
////////////////////////////////////Updating Transaction Details////////////////////////////////////
			
			sql = "INSERT INTO TRANSACTION_DETAILS (CUSTOMER_ID, REFERENCE_ID, PRIMARY_ACC, AMOUNT, CLOSING_BALANCE, TRANSACTION_TIME, MODE_OF_TRANSACTION, TYPE, REMARKS, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = createPreparedStatement(sql, connection);
			
			long millisecond = System.currentTimeMillis();
			String referenceID = "REF" + millisecond;
			
			stmt.setLong(1, customerID);
			stmt.setString(2, referenceID);
			stmt.setLong(3, fromAccount);
			stmt.setDouble(4, amount);
			stmt.setDouble(5, balance);
			stmt.setLong(6, millisecond);
			stmt.setString(7, "WITHDRAW");
			stmt.setString(8, "DEBIT");
			stmt.setString(9, remarks);
			stmt.setString(10, status);
			
			stmt.execute();
			
			closeStatement(stmt);
			
/////////////////////////////////////////UPDATING REQUEST TABLE//////////////////////////////////////
			
			sql = "UPDATE TRANSACTION_REQUEST SET STATUS = ? WHERE REQUEST_ID = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, status);
			stmt.setLong(2, requestID);
			stmt.execute();
			
			connection.commit();
			
			return balance;
			
		}
		catch (SQLException e)
		{
			try
			{
				connection.rollback(S1);
			}
			catch (SQLException e1)
			{
				throw new WrongEntryException("Failed to Roll Back.", e);
			}
			
			throw new WrongEntryException("Incorrect Account number.", e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	public void updateRejectedTransaction(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException
	{
		
		long fromAccount = transactionRequestDetails.getAccountNo();
		double amount = transactionRequestDetails.getAmount();
		long customerID = transactionRequestDetails.getCustomerID();
		String remarks = transactionRequestDetails.getDescription();
		long requestID = transactionRequestDetails.getRequestID();
		
		String sql = "SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		Savepoint S1 = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setDouble(1, fromAccount);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			double balance = result.getDouble("BALANCE");
			
			closeStatement(stmt);
			
/////////////////////////////////////////UPDATING TRANSACTION_DETAILS//////////////////////////////////////			
			
			sql = "INSERT INTO TRANSACTION_DETAILS (CUSTOMER_ID, REFERENCE_ID, PRIMARY_ACC, AMOUNT, CLOSING_BALANCE, TRANSACTION_TIME, MODE_OF_TRANSACTION, TYPE, STATUS, REMARKS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			connection.setAutoCommit(false);
			
			stmt = createPreparedStatement(sql, connection);
			
			long millisecond = System.currentTimeMillis();
			String referenceID = "REF" + millisecond;
			
			stmt.setLong(1, customerID);
			stmt.setString(2, referenceID);
			stmt.setLong(3, fromAccount);
			stmt.setDouble(4, amount);
			stmt.setDouble(5, balance);
			stmt.setLong(6, millisecond);
			stmt.setString(7, "WITHDRAW");
			stmt.setString(8, "DEBIT");
			stmt.setString(9, "REJECTED");
			stmt.setString(10, remarks);
			System.out.println();
			
			S1 = connection.setSavepoint();
			
			stmt.execute();
			
			closeStatement(stmt);
			
////////////////////////////////////////////UPDATING TRANSACTION REQUEST////////////////////////////////////
			
			sql = "UPDATE TRANSACTION_REQUEST SET STATUS = 'REJECTED' WHERE REQUEST_ID = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, requestID);
			
			stmt.execute();
			
			connection.commit();
			
		}
		catch(SQLException e)
		{
			try
			{
				connection.rollback(S1);
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			throw new WrongEntryException("Error!");
		}
		finally
		{
//			closeStatement(stmt);
//			closeConnection(connection);
		}
		
	}
	
	@Override
	public void onlineTransfer(TransactionDetails transactionDetails) throws WrongEntryException
	{
		
		long fromAccount = transactionDetails.getPrimaryAccount();
		long toAccount = transactionDetails.getSecondaryAccount();
		double amount = transactionDetails.getAmount();
		long customerID = transactionDetails.getCustomerID();
		String remarks = transactionDetails.getRemarks();
		
		checkAccountStatus(fromAccount);
		checkAccountStatus(toAccount);
		
		Connection connection = null;
		PreparedStatement stmt = null;
		Savepoint S1 = null;
		String referenceID;
		long millisecond;
		
		try
		{
			double fromAccountBalance = getBalance(fromAccount);
			
			connection = createConnection();
			
			connection.setAutoCommit(false);
			
////////////////////////////////////withdraw From Account////////////////////////////////////
			
			if(fromAccountBalance >= amount)
			{
				fromAccountBalance = fromAccountBalance - amount;
				
				String sql = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
				
				stmt = createPreparedStatement(sql, connection);
				
				stmt.setDouble(1, fromAccountBalance);
				stmt.setLong(2, fromAccount);
				
				S1 = connection.setSavepoint();
				
				stmt.execute();
				
				closeStatement(stmt);				//Closing statement...
				
////////////////////////////////////Updating Transaction Details////////////////////////////////////
				
				sql = "INSERT INTO TRANSACTION_DETAILS (CUSTOMER_ID, REFERENCE_ID, PRIMARY_ACC, SECONDARY_ACC, AMOUNT, CLOSING_BALANCE, TRANSACTION_TIME, MODE_OF_TRANSACTION, TYPE, STATUS, REMARKS) VALUES (?, ? ,? ,? ,? ,? ,?, ?, ?, ?, ?)";
				
				stmt = createPreparedStatement(sql, connection);
				
				millisecond = System.currentTimeMillis();
				referenceID = "REF" + millisecond;
				
				stmt.setLong(1, customerID);
				stmt.setString(2, referenceID);
				stmt.setLong(3, fromAccount);
				stmt.setLong(4, toAccount);
				stmt.setDouble(5, amount);
				stmt.setDouble(6, fromAccountBalance);
				stmt.setLong(7, millisecond);
				stmt.setString(8, "ONLINE TRANSFER");
				stmt.setString(9, "DEBIT");
				stmt.setString(10, "SUCCESS");
				stmt.setString(11, remarks);
				
				stmt.execute();
				
				closeStatement(stmt);			//Closing statement...
				
			}
			else
			{
				throw new WrongEntryException("Insufficient balance to withdraw. \nTransaction Failed.");
			}
			
////////////////////////////////////Deposit To Account////////////////////////////////////
			
			String sql = "SELECT BALANCE FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, toAccount);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			double toAccountBalance = result.getLong("BALANCE");
			
			toAccountBalance = toAccountBalance + amount;
			
			closeStatement(stmt);			//Closing statement...
			
			sql = "UPDATE ACCOUNT_DETAILS SET BALANCE = ? WHERE ACCOUNT_NO = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setDouble(1, toAccountBalance);
			stmt.setLong(2, toAccount);
			
			stmt.execute();
			
			closeStatement(stmt);			//Closing statement...
			
////////////////////////////////////Updating Transaction Details////////////////////////////////////
			
			sql = "SELECT CUSTOMER_ID FROM ACCOUNT_DETAILS WHERE ACCOUNT_NO = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, toAccount);
			
			result = stmt.executeQuery();
			
			result.next();
			
			long receiverCustomerID = result.getLong("CUSTOMER_ID");
			
			closeStatement(stmt);			//Closing statement...
			
			sql = "INSERT INTO TRANSACTION_DETAILS (CUSTOMER_ID, REFERENCE_ID, PRIMARY_ACC, SECONDARY_ACC, AMOUNT, CLOSING_BALANCE, TRANSACTION_TIME, MODE_OF_TRANSACTION, TYPE, STATUS, REMARKS) VALUES (?, ? ,? ,? ,? ,? ,?, ?, ?, ?, ?)";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, receiverCustomerID);
			stmt.setString(2, referenceID);
			stmt.setLong(3, toAccount);
			stmt.setLong(4, fromAccount);
			stmt.setDouble(5, amount);
			stmt.setDouble(6, toAccountBalance);
			stmt.setLong(7, millisecond);
			stmt.setString(8, "ONLINE TRANSFER");
			stmt.setString(9, "CREDIT");
			stmt.setString(10, "SUCCESS");
			stmt.setString(11, remarks);
			
			stmt.execute();
			
			connection.commit();
			
		}
		catch (SQLException e)
		{
			try
			{
				connection.rollback(S1);
			}
			catch (SQLException e1)
			{
				throw new WrongEntryException("Error in Roll Back.", e);
			}
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	@Override
	public List<TransactionDetails> getTransactionHistory(long accountNo) throws WrongEntryException
	{
		
//		checkAccountStatus(accountNo);
		
		String sql = "SELECT * FROM TRANSACTION_DETAILS WHERE PRIMARY_ACC = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, accountNo);
			
			ResultSet result = stmt.executeQuery();
			
			List<TransactionDetails> transactionList = createtransactionList(result);
			
			return transactionList;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	private List<TransactionDetails> createtransactionList(ResultSet result) throws SQLException
	{
		List<TransactionDetails> transactionList = new ArrayList<>();
		
		while(result.next())
		{
			TransactionDetails details = new TransactionDetails();
			
			details.setCustomerID(result.getLong("CUSTOMER_ID"));
			details.setID(result.getLong("ID"));
			details.setReferenceID(result.getString("REFERENCE_ID"));
			details.setPrimaryAccount(result.getLong("PRIMARY_ACC"));
			details.setSecondaryAccount(result.getLong("SECONDARY_ACC"));
			details.setAmount(result.getDouble("AMOUNT"));
			details.setClosingBalance(result.getDouble("CLOSING_BALANCE"));
			details.setMilliSeconds(result.getLong("TRANSACTION_TIME"));
			details.setModeOfTransaction(result.getString("MODE_OF_TRANSACTION"));
			details.setType(result.getString("TYPE"));
			details.setRemarks(result.getString("REMARKS"));
			details.setStatus(result.getString("STATUS"));
			
			transactionList.add(details);
			
		}
		
		return transactionList;
		
	}
	
//Specific to Admin...	
	public Map<Long,Map<Long,AccountDetails>> getcompleteAccountsList() throws WrongEntryException
	{
		
		String sql = "SELECT * FROM ACCOUNT_DETAILS";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			
			result.beforeFirst();
			
			Map<Long,Map<Long,AccountDetails>> completeAccountsList = convertResultToMap(result);
			
			return completeAccountsList;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public void modifyUserDetails(UserDetails userDetails) throws WrongEntryException
	{
		
/////////////////////////////////////////CREATING QUERY/////////////////////////////////////////
		
		StringBuilder strBuil = new StringBuilder();
		
		strBuil.append("UPDATE USER_DETAILS SET ");
		
		if(userDetails.getName() != null)
		{
			strBuil.append("NAME = '" + userDetails.getName() + "',");
		}
		if(userDetails.getMobile() != 0)
		{
			strBuil.append("MOBILE = '" + userDetails.getMobile() + "',");
		}
		if(userDetails.getEmailID() != null)
		{
			strBuil.append("EMAIL = '" + userDetails.getEmailID() + "',");
		}
		if(userDetails.getDateOfBirth() != null)
		{
			strBuil.append("DOB = '" + userDetails.getDateOfBirth() + "',");
		}
		
		int length = strBuil.length();
		
		String sql = strBuil.substring(0, length-1).toString();
		
		strBuil.delete(0, length);
		
		strBuil.append(sql + " WHERE USER_ID = " + userDetails.getUserID());
		
		sql = strBuil.toString();
		
/////////////////////////////////////////QUERY CREATED/////////////////////////////////////////
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.execute();
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	public void modifyPassword(long userID, String oldPassword, String newPassword) throws WrongEntryException
	{
		
		String sql = "UPDATE USER_DETAILS SET PASSWORD = ? WHERE USER_ID = ? AND PASSWORD = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, newPassword);
			stmt.setLong(2, userID);
			stmt.setString(3, oldPassword);
			
			stmt.execute();
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	private UserDetails getUserDetails(ResultSet result) throws SQLException
	{
		UserDetails userDetails = new UserDetails();
		
		while(result.next())
		{
			
			userDetails.setUserID(result.getLong("USER_ID"));
			userDetails.setPassword(result.getString("PASSWORD"));
			userDetails.setName(result.getString("NAME"));
			userDetails.setMobile(result.getLong("MOBILE"));
			userDetails.setEmailID(result.getString("EMAIL"));
			userDetails.setDateOfBirth(result.getString("DOB"));
			userDetails.setUserType(result.getString("USER_TYPE"));
			
		}
		
		return userDetails;
	}
	
	@Override
	public UserDetails addUser(UserDetails userDetails) throws WrongEntryException
	{
		
		String password = userDetails.getPassword();
		String name = userDetails.getName();
		long mobile = userDetails.getMobile();
		String emailID = userDetails.getEmailID();
		String dateOfBirth = userDetails.getDateOfBirth();
		String userType = userDetails.getUserType();
		
		String sql = "INSERT INTO USER_DETAILS (PASSWORD,NAME,MOBILE,EMAIL,DOB,USER_TYPE) VALUES (?, ?, ?, ?, ?, ?)";
		

		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, password);
			stmt.setString(2, name);
			stmt.setLong(3, mobile);
			stmt.setString(4, emailID);
			stmt.setString(5, dateOfBirth);
			stmt.setString(6, userType);
			
			stmt.execute();
			
			closeStatement(stmt);						//Closing Statement...
			
			sql = "SELECT * FROM USER_DETAILS WHERE NAME = ? AND PASSWORD = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, name);
			stmt.setString(2, password);
			
			ResultSet result = stmt.executeQuery();
			
			userDetails = getUserDetails(result);
			
			return userDetails;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public void createCustomerIDRequest(UserDetails userDetails, String customerStatus, String message) throws WrongEntryException
	{
		
		long customerID = userDetails.getUserID();
		
		String sql = "SELECT * FROM ACCOUNT_REQUEST WHERE CUSTOMER_ID = ? AND STATUS = 'PENDING' AND ACCOUNT_NO IS NULL";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, customerID);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next())
			{
				throw new WrongEntryException("Request Already Submitted.");
			}
			
			closeStatement(stmt);						//Closing Statement...
			
			sql = "INSERT INTO ACCOUNT_REQUEST (CUSTOMER_ID,STATUS,DESCRIPTION,CUS_STATUS) VALUES (?, ?, ?, ?)";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, customerID);
			stmt.setString(2, "PENDING");
			stmt.setString(3, message);
			stmt.setString(4, customerStatus);
			
			stmt.execute();
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public Map<Integer,AccountRequestDetails> getCustomerIDRequests() throws WrongEntryException
	{
		
		String sql = "SELECT * FROM ACCOUNT_REQUEST WHERE STATUS = 'PENDING' AND ACCOUNT_NO IS NULL";
		

		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			
			Map<Integer,AccountRequestDetails> requestList = null;
			
			if(result.next())
			{
				result.beforeFirst();
				
				requestList = convertAccountRequestToMap(result);
				
			}
			
			return requestList;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public void createAccountRequest(AccountDetails accountDetails, String message) throws WrongEntryException
	{
		
		long customerID = accountDetails.getCustomerID();
		long accountNo = accountDetails.getAccountNo();
		String accountStatus = accountDetails.getAccountStatus();
		
		String sql = "SELECT * FROM ACCOUNT_REQUEST WHERE ACCOUNT_NO = ? AND STATUS = 'PENDING'";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, accountNo);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next())
			{
				throw new WrongEntryException("Request Already Submitted.");
			}
			
			closeStatement(stmt);						//Closing Statement...
			
			sql = "INSERT INTO ACCOUNT_REQUEST (CUSTOMER_ID,ACCOUNT_NO,STATUS,DESCRIPTION,ACC_STATUS) VALUES (?, ?, ?, ?, ?)";
		
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, customerID);
			stmt.setLong(2, accountNo);
			stmt.setString(3, "PENDING");
			stmt.setString(4, message);
			stmt.setString(5, accountStatus);
			
			stmt.execute();
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public Map<Integer,AccountRequestDetails> getAccountRequests() throws WrongEntryException
	{
		
		String sql = "SELECT * FROM ACCOUNT_REQUEST WHERE STATUS = 'PENDING' AND ACCOUNT_NO IS NOT NULL";
		

		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			
			Map<Integer,AccountRequestDetails> requestList = null;
			
			if(result.next())
			{
				result.beforeFirst();
				
				requestList = convertAccountRequestToMap(result);
				
			}
			
			return requestList;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	public void updateAccountRequest(AccountRequestDetails accountRequestDetails) throws WrongEntryException
	{
		
		String status = accountRequestDetails.getStatus();
		long requestID = accountRequestDetails.getRequestID();
		long accountNo = accountRequestDetails.getAccountNo();
		String accountStatus = accountRequestDetails.getAccountStatus();
		String customerStatus = accountRequestDetails.getCustomerStatus();
		long customerID = accountRequestDetails.getCustomerID();
		
		String sql =null;
		
		Connection connection = null;
		PreparedStatement stmt = null;
		Savepoint S1 = null;
		
		try
		{
			connection = createConnection();
			connection.setAutoCommit(false);
			
			if(customerStatus == null)
			{
				if(status.equals("APPROVED"))
				{
					if(accountStatus.equals("ACTIVE"))
					{
						accountStatus = "INACTIVE";
					}
					else if(accountStatus.equals("INACTIVE"))
					{
						accountStatus = "ACTIVE";
					}
					
					sql = "UPDATE ACCOUNT_DETAILS SET ACC_STATUS = ? WHERE ACCOUNT_NO = ?";
					
					stmt = createPreparedStatement(sql, connection);
					
					stmt.setString(1, accountStatus);
					stmt.setLong(2, accountNo);
					
					S1 = connection.setSavepoint();
					
					stmt.execute();
					
					closeStatement(stmt);				//Closing Statement...
				}
				
	//////////////////////////////////////UPDATING ACCOUNT REQUEST TABLE//////////////////////////////////
				
				sql = "UPDATE ACCOUNT_REQUEST SET STATUS = ?,ACC_STATUS = ? WHERE REQUEST_ID = ?";
			
				stmt = createPreparedStatement(sql, connection);
				
				stmt.setString(1, status);
				stmt.setString(2, accountStatus);
				stmt.setLong(3, requestID);
				
				stmt.execute();
				connection.commit();
			}
			else if(accountStatus == null)
			{
				if(status.equals("APPROVED"))
				{
					if(customerStatus.equals("ACTIVE"))
					{
						customerStatus = "INACTIVE";
					}
					else if(customerStatus.equals("INACTIVE"))
					{
						customerStatus = "ACTIVE";
					}
					
					sql = "UPDATE CUSTOMER_DETAILS SET CUS_STATUS = ? WHERE CUSTOMER_ID = ?";
					
					stmt = createPreparedStatement(sql, connection);
					
					stmt.setString(1, customerStatus);
					stmt.setLong(2, customerID);
					
					S1 = connection.setSavepoint();
					
					stmt.execute();
					
					closeStatement(stmt);				//Closing Statement...
				}
				
	//////////////////////////////////////UPDATING ACCOUNT REQUEST TABLE//////////////////////////////////
				
				sql = "UPDATE ACCOUNT_REQUEST SET STATUS = ?,CUS_STATUS = ? WHERE REQUEST_ID = ?";
			
				stmt = createPreparedStatement(sql, connection);
				
				stmt.setString(1, status);
				stmt.setString(2, customerStatus);
				stmt.setLong(3, requestID);
				
				stmt.execute();
				connection.commit();
			}
		}
		catch(SQLException e)
		{
			try
			{
				connection.rollback(S1);
			}
			catch (SQLException e1)
			{
				throw new WrongEntryException("Failed to Roll Back.", e);
			}
			
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	private Map<Integer,AccountRequestDetails> convertAccountRequestToMap(ResultSet result) throws SQLException
	{
		
		Map<Integer,AccountRequestDetails> requestList = new Hashtable<>();
		int i = 1;
		
		while(result.next())
		{
			
			AccountRequestDetails details = new AccountRequestDetails();
			
			details.setRequestID(result.getLong("REQUEST_ID"));
			details.setCustomerID(result.getLong("CUSTOMER_ID"));
			details.setAccountNo(result.getLong("ACCOUNT_NO"));
			details.setStatus(result.getString("STATUS"));
			details.setAccountStatus(result.getString("ACC_STATUS"));
			details.setCustomerStatus(result.getString("CUS_STATUS"));
			details.setDescription(result.getString("DESCRIPTION"));
			
			requestList.put(i, details);
			
			i++;
			
		}
		
		return requestList;
		
	}
	
	@Override
	public void createTransactionRequest(TransactionRequestDetails transactionRequestDetails) throws WrongEntryException
	{
		long customerID = transactionRequestDetails.getCustomerID();
		long accountNo = transactionRequestDetails.getAccountNo();
		double amount = transactionRequestDetails.getAmount();
		
		String sql;
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			sql = "INSERT INTO TRANSACTION_REQUEST (CUSTOMER_ID,ACCOUNT_NO,AMOUNT,STATUS) VALUES (?, ?, ?, ?)";
			
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, customerID);
			stmt.setLong(2, accountNo);
			stmt.setDouble(3, amount);
			stmt.setString(4, "PENDING");
			
			stmt.execute();
				
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	@Override
	public Map<Integer,TransactionRequestDetails> getTransactionRequests() throws WrongEntryException
	{
		
		String sql = "SELECT * FROM TRANSACTION_REQUEST WHERE STATUS = 'PENDING'";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			
			Map<Integer,TransactionRequestDetails> requestList = null;
			
			if(result.next())
			{
				result.beforeFirst();
				
				requestList = convertTransactionRequestToMap(result);
				
			}
			
			return requestList;
			
		}
		catch(SQLException e)
		{
			throw new WrongEntryException("Error!");
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
		
	}
	
	private Map<Integer,TransactionRequestDetails> convertTransactionRequestToMap(ResultSet result) throws SQLException
	{
		
		Map<Integer,TransactionRequestDetails> requestList = new Hashtable<>();
		int i = 1;
		
		while(result.next())
		{
			
			TransactionRequestDetails details = new TransactionRequestDetails();
			
			details.setRequestID(result.getLong("REQUEST_ID"));
			details.setCustomerID(result.getLong("CUSTOMER_ID"));
			details.setAccountNo(result.getLong("ACCOUNT_NO"));
			details.setAmount(result.getDouble("AMOUNT"));
			details.setStatus(result.getString("STATUS"));
			details.setDescription(result.getString("DESCRIPTION"));
			
			requestList.put(i, details);
			i++;
			
		}
		
		return requestList;
		
	}
	
}
