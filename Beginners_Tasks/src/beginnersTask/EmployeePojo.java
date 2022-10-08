package beginnersTask;

public class EmployeePojo
{
	private String employeeId;
	private String name;
	private String mobileNum;
	private String emailId;
	private String department;
	
	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setMobileNum(String mobileNum)
	{
		this.mobileNum = mobileNum;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getEmployeeId()
	{
		return employeeId;
	}
	public String getName()
	{
		return name;
	}
	public String getMobileNum()
	{
		return mobileNum;
	}
	public String getEmailId()
	{
		return emailId;
	}
	public String getDepartment()
	{
		return department;
	}
}
