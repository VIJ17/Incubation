package datacarier;

public class TransactionDetails
{
	
	private long customerID;
	private long transactionID;
	private Long fromAccount;
	private Long toAccount;
	private double amount;
	private double closingBalance;
	private long milliSeconds;
	private String modeOfTransaction;
	private String type;
	private String remarks;
	
	public long getTransactionID()
	{
		return transactionID;
	}
	public void setTransactionID(long transactionID)
	{
		this.transactionID = transactionID;
	}
	public long getFromAccount()
	{
		return fromAccount;
	}
	public void setFromAccount(long fromAccount)
	{
		this.fromAccount = fromAccount;
	}
	public long getToAccount()
	{
		return toAccount;
	}
	public void setToAccount(long toAccount)
	{
		this.toAccount = toAccount;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public long getMilliSeconds()
	{
		return milliSeconds;
	}
	public void setMilliSeconds(long milliSeconds)
	{
		this.milliSeconds = milliSeconds;
	}
	public long getCustomerID()
	{
		return customerID;
	}
	public void setCustomerID(long customerID)
	{
		this.customerID = customerID;
	}
	public double getClosingBalance()
	{
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance)
	{
		this.closingBalance = closingBalance;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
