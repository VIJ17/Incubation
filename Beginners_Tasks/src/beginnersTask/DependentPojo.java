package beginnersTask;

public class DependentPojo
{
	private String employeeId;
	private String dependentId;
	private String name;
	private int age;
	private String relationship;
	
	public String getEmployeeId()
	{
		return employeeId;
	}
	public String getDependentId()
	{
		return dependentId;
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
	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}
	public void setDependentId(String dependentId)
	{
		this.dependentId = dependentId;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getRelationship()
	{
		return relationship;
	}
	public void setRelationship(String relationship)
	{
		this.relationship = relationship;
	}
}
