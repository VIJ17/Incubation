package datacarier;

public class CompanyDetails
{
	private long UserID;
	private String password;
	private String companyName;
	
	public long getUserID()
	{
		return UserID;
	}
	public void setUserID(long userID)
	{
		UserID = userID;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
}
