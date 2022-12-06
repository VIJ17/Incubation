package logiclayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import datacarier.ApplicantDetails;
import datacarier.CompanyDetails;
import datacarier.VacancyDetails;
import exceptions.WrongEntryException;
import jobportalframe.OnlineJobPortalInterface;
import storagelayer.JobPortalStorage;

public class JobPortalCache implements OnlineJobPortalInterface
{
	private JobPortalStorage cache = new JobPortalStorage();
	
	@Override
	public void applicantRegistration(ApplicantDetails applicantDetails)
	{
		long userID = applicantDetails.getUserID();
		Map<Long, ApplicantDetails> applicantMap = cache.getApplicantMap();
		applicantMap.put(userID, applicantDetails);
	}

	@Override
	public ApplicantDetails applicantLogin(long userID, String password) throws WrongEntryException
	{
		Map<Long, ApplicantDetails> applicantMap = cache.getApplicantMap();
		ApplicantDetails applicantDetails = applicantMap.get(userID);
		
		if(applicantDetails == null || (!applicantDetails.getPassword().equals(password)))
		{
			throw new WrongEntryException("UserID or Password is incorrect!");
		}
		
		return applicantDetails;
	}

	@Override
	public void companyRegistration(CompanyDetails companyDetails)
	{
		long userID = companyDetails.getUserID();
		Map<Long, CompanyDetails> companyMap = cache.getCompanyMap();
		companyMap.put(userID, companyDetails);
	}

	@Override
	public CompanyDetails companyLogin(long userID, String password) throws WrongEntryException
	{
		Map<Long, CompanyDetails> companyMap = cache.getCompanyMap();
		CompanyDetails companyDetails = companyMap.get(userID);
		
		if(companyDetails == null || (!companyDetails.getPassword().equals(password)))
		{
			throw new WrongEntryException("UserID or Password is incorrect!");
		}
		
		return companyDetails;
	}

	@Override
	public void vacancyRegistration(VacancyDetails vacancyDetails)
	{
		List<VacancyDetails> vacancyList = cache.getVacancyList();
		vacancyList.add(vacancyDetails);
	}

	@Override
	public List<VacancyDetails> jobSearch(ApplicantDetails applicantDetails)
	{
		List<VacancyDetails> vacancyList = cache.getVacancyList();
		List<VacancyDetails> matchedVacancyList = new ArrayList<>();
		
		for(int i = 0; i < vacancyList.size(); i++)
		{
			VacancyDetails vacancyDetails = vacancyList.get(i);
			
			if(vacancyDetails.getQualification().equals("ANY") || vacancyDetails.getQualification().equals(applicantDetails.getQualification()))
			{
				if(vacancyDetails.getSkill().equals(applicantDetails.getSkill()))
				{
					if(vacancyDetails.getExperience() <= applicantDetails.getExperience())
					{
						matchedVacancyList.add(vacancyDetails);
					}
				}
			}
		}
		
		return matchedVacancyList;
	}

	@Override
	public void notification()
	{
		
	}

}
