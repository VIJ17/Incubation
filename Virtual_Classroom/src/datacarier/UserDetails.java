package datacarier;

public class UserDetails
{
	private long userID;
	private String password;
	private String name;
	private int age;
	private long mobile;
	private String email;
	private String role;
	private String department;
	private String status;
	
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
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public long getMobile()
	{
		return mobile;
	}
	public void setMobile(long mobile)
	{
		this.mobile = mobile;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	@Override
	public String toString()
	{
		return "UserDetails [userID=" + userID + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", mobile=" + mobile + ", email=" + email + ", role=" + role + ", department=" + department
				+ ", status=" + status + "]";
	}
	
}
