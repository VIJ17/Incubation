package datacarier;

public class CustomerDetails extends UserDetails
{
	
	private long customerID;			//References User_ID...& Primary Key...
	private String panNo;
	private long aadharNo;
	private String address;
	private String customerStatus;
	
	public long getCustomerID() 
	{
		return customerID;
	}
	public void setCustomerID(long customerID)
	{
		this.customerID = customerID;
	}
	public String getPanNo()
	{
		return panNo;
	}
	public void setPanNo(String panNo)
	{
		this.panNo = panNo;
	}
	public long getAadharNo()
	{
		return aadharNo;
	}
	public void setAadharNo(long aadharNo)
	{
		this.aadharNo = aadharNo;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getCustomerStatus()
	{
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus)
	{
		this.customerStatus = customerStatus;
	}
	
}
