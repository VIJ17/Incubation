package storagelayer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import datacarier.ApplicantDetails;
import datacarier.CompanyDetails;
import datacarier.VacancyDetails;

public class JobPortalStorage
{
	private Map<Long, CompanyDetails> companyMap = new Hashtable<>();
	private Map<Long,ApplicantDetails> applicantMap = new Hashtable<>();
	private List<VacancyDetails> vacancyList = new ArrayList<>();
	
	public JobPortalStorage()
	{
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCompanyName("RVN Softwares");
		companyDetails.setUserID(1);
		companyDetails.setPassword("Rvn@123.");
		companyMap.put(1L, companyDetails);
		companyDetails = new CompanyDetails();
		companyDetails.setCompanyName("ZOHO Travels");
		companyDetails.setUserID(2);
		companyDetails.setPassword("Zoho@123.");
		companyMap.put(2L, companyDetails);
		companyDetails = new CompanyDetails();
		companyDetails.setCompanyName("Dream Builders");
		companyDetails.setUserID(3);
		companyDetails.setPassword("Dream@123.");
		companyMap.put(3L, companyDetails);
		ApplicantDetails applicantDetails = new ApplicantDetails();
		applicantDetails.setUserID(1);
		applicantDetails.setPassword("Vijay@17.");
		applicantDetails.setName("VIJAY R");
		applicantDetails.setAge(22);
		applicantDetails.setQualification("MECH");
		applicantDetails.setExperience(1);
		applicantDetails.setSkills("DRIVING");
		applicantMap.put(1L, applicantDetails);
		applicantDetails = new ApplicantDetails();
		applicantDetails.setUserID(2);
		applicantDetails.setPassword("Anzar@09.");
		applicantDetails.setName("ANZAR M");
		applicantDetails.setAge(23);
		applicantDetails.setQualification("CS");
		applicantDetails.setExperience(2);
		applicantDetails.setSkills("JAVA");
		applicantMap.put(2L, applicantDetails);
		applicantDetails = new ApplicantDetails();
		applicantDetails.setUserID(3);
		applicantDetails.setPassword("Siva@10.");
		applicantDetails.setName("SIVA V");
		applicantDetails.setAge(21);
		applicantDetails.setQualification("CS");
		applicantDetails.setExperience(0);
		applicantDetails.setSkills("JAVA");
		applicantMap.put(3L, applicantDetails);
		applicantDetails = new ApplicantDetails();
		applicantDetails.setUserID(4);
		applicantDetails.setPassword("Jebaraj@10.");
		applicantDetails.setName("JEBARAJ V");
		applicantDetails.setAge(23);
		applicantDetails.setQualification("CIVIL");
		applicantDetails.setExperience(1);
		applicantDetails.setSkills("CADD");
		applicantMap.put(4L, applicantDetails);
		VacancyDetails vacancyDetails = new VacancyDetails();
		vacancyDetails.setCompanyName("RVN Softwares");
		vacancyDetails.setRole("Developer");
		vacancyDetails.setQualification("CS");
		vacancyDetails.setExperience(0);
		vacancyDetails.setSkill("JAVA");
		vacancyDetails.setNoOfOpenings(5);
		vacancyList.add(vacancyDetails);
		vacancyDetails = new VacancyDetails();
		vacancyDetails.setCompanyName("ZOHO Travels");
		vacancyDetails.setRole("Mechanic");
		vacancyDetails.setQualification("MECH");
		vacancyDetails.setExperience(1);
		vacancyDetails.setSkill("DRIVING");
		vacancyDetails.setNoOfOpenings(5);
		vacancyList.add(vacancyDetails);
		vacancyDetails = new VacancyDetails();
		vacancyDetails.setCompanyName("Dream Builders");
		vacancyDetails.setRole("Site Engineer");
		vacancyDetails.setQualification("CIVIL");
		vacancyDetails.setExperience(0);
		vacancyDetails.setSkill("ANY");
		vacancyDetails.setNoOfOpenings(5);
		vacancyList.add(vacancyDetails);
	}
	
	public Map<Long, CompanyDetails> getCompanyMap()
	{
		return companyMap;
	}

	public Map<Long, ApplicantDetails> getApplicantMap()
	{
		return applicantMap;
	}
	
	public List<VacancyDetails> getVacancyList()
	{
		return vacancyList;
	}
	
}
