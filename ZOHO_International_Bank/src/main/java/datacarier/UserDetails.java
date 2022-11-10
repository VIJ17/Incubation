package datacarier;

public class UserDetails
{
	
	private long userID;
	private String password;
	private String name;
	private long mobile;
	private String emailID;
	private String dateOfBirth;
	private String userType;
	
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public long getMobile()
	{
		return mobile;
	}
	public void setMobile(long mobile)
	{
		this.mobile = mobile;
	}
	public String getEmailID()
	{
		return emailID;
	}
	public void setEmailID(String emailID)
	{
		this.emailID = emailID;
	}
	public long getUserID()
	{
		return userID;
	}
	public void setUserID(long userID)
	{
		this.userID = userID;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getUserType()
	{
		return userType;
	}
	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	
}
