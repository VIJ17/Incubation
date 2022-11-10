package datacarier;

public class TransactionRequestDetails
{
	
	private long requestID;
	private long customerID;
	private long accountNo;
	private double amount;
	private String status;
	private String description;
	
	public long getRequestID()
	{
		return requestID;
	}
	public void setRequestID(long requestID)
	{
		this.requestID = requestID;
	}
	public long getCustomerID()
	{
		return customerID;
	}
	public void setCustomerID(long customerID)
	{
		this.customerID = customerID;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public long getAccountNo()
	{
		return accountNo;
	}
	public void setAccountNo(long accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}
