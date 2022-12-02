package datacarier;

public class TransactionDetails
{
	
	private long customerID;
	private long ID;
	private String referenceID;
	private Long primaryAccount;
	private Long secondaryAccount;
	private double amount;
	private double closingBalance;
	private long milliSeconds;
	private String modeOfTransaction;
	private String type;
	private String remarks;
	private String status;
	
	public long getCustomerID()
	{
		return customerID;
	}
	public void setCustomerID(long customerID)
	{
		this.customerID = customerID;
	}
	public long getID()
	{
		return ID;
	}
	public void setID(long iD)
	{
		ID = iD;
	}
	public String getReferenceID()
	{
		return referenceID;
	}
	public void setReferenceID(String referenceID)
	{
		this.referenceID = referenceID;
	}
	public Long getPrimaryAccount()
	{
		return primaryAccount;
	}
	public void setPrimaryAccount(Long primaryAccount)
	{
		this.primaryAccount = primaryAccount;
	}
	public Long getSecondaryAccount()
	{
		return secondaryAccount;
	}
	public void setSecondaryAccount(Long secondaryAccount)
	{
		this.secondaryAccount = secondaryAccount;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public double getClosingBalance()
	{
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance)
	{
		this.closingBalance = closingBalance;
	}
	public long getMilliSeconds()
	{
		return milliSeconds;
	}
	public void setMilliSeconds(long milliSeconds)
	{
		this.milliSeconds = milliSeconds;
	}
	public String getModeOfTransaction()
	{
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction)
	{
		this.modeOfTransaction = modeOfTransaction;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
}
