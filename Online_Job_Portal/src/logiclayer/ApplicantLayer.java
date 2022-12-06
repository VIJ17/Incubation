package logiclayer;

import java.util.List;

import datacarier.ApplicantDetails;
import datacarier.VacancyDetails;
import exceptions.WrongEntryException;

public class ApplicantLayer
{
	JobPortalCache portal = new JobPortalCache();
	
	public void applicantRegistration(ApplicantDetails applicantDetails)
	{
		portal.applicantRegistration(applicantDetails);
	}
	
	public ApplicantDetails applicantLogin(long userID, String password) throws WrongEntryException
	{
		ApplicantDetails applicantDetails = portal.applicantLogin(userID, password);
		
		return applicantDetails;
	}
	
	public List<VacancyDetails> jobSearch(ApplicantDetails applicantDetails)
	{
		List<VacancyDetails> matchedVacancyList = portal.jobSearch(applicantDetails);
		
		return matchedVacancyList;
	}
}
