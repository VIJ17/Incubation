package datacarier;

public class AccountDetails extends CustomerDetails
{
	
	private long customerID;			//Foreign Key...
	private long accountNo;				//Primary Key...
	private String accountType;
	private String accountStatus;
	private String ifscCode;
	private String branch;
	private double balance;
	
	public long getCustomerID() 
	{
		return customerID;
	}
	public void setCustomerID(long customerID)
	{
		this.customerID = customerID;
	}
	public long getAccountNo()
	{
		return accountNo;
	}
	public void setAccountNo(long accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getIfscCode()
	{
		return ifscCode;
	}
	public void setIfscCode(String ifscCode)
	{
		this.ifscCode = ifscCode;
	}
	public String getBranch()
	{
		return branch;
	}
	public void setBranch(String branch)
	{
		this.branch = branch;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public String getAccountStatus()
	{
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus)
	{
		this.accountStatus = accountStatus;
	}
	
}
