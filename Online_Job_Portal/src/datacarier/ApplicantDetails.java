package datacarier;

public class ApplicantDetails
{
	private long userID;
	private String password;
	private String name;
	private int age;
	private String qualification;
	private int Experience;
	private String skill;
	
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
	public String getQualification()
	{
		return qualification;
	}
	public void setQualification(String qualification)
	{
		this.qualification = qualification;
	}
	public int getExperience()
	{
		return Experience;
	}
	public void setExperience(int experience)
	{
		Experience = experience;
	}
	public String getSkill()
	{
		return skill;
	}
	public void setSkills(String skills)
	{
		this.skill = skills;
	}
}
