package datacarier;

import java.io.Serializable;

public class UserDetails implements Serializable
{
	private static final long serialVersionUID = 3661491817702991221L;
	
	private long userID;
	private String password;
	private String name;
	private int age;
	private long mobileNo;
	private long aadharNo;
	
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
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public long getAadharNo()
	{
		return aadharNo;
	}
	public void setAadharNo(long aadharNo)
	{
		this.aadharNo = aadharNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
