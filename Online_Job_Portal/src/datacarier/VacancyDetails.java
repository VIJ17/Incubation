package datacarier;

public class VacancyDetails
{
	private String companyName;
	private String role;
	private String qualification;
	private int experience;
	private String skill;
	private int noOfOpenings;
	
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
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
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
	}
	public String getSkill()
	{
		return skill;
	}
	public void setSkill(String skill)
	{
		this.skill = skill;
	}
	public String getCompanyName()
	{
		return companyName;
	}
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	public int getNoOfOpenings()
	{
		return noOfOpenings;
	}
	public void setNoOfOpenings(int noOfOpenings)
	{
		this.noOfOpenings = noOfOpenings;
	}
}
