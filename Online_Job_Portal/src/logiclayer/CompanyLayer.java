package logiclayer;

import datacarier.CompanyDetails;
import datacarier.VacancyDetails;
import exceptions.WrongEntryException;

public class CompanyLayer
{
	JobPortalCache portal = new JobPortalCache();
	
	public void companyRegistration(CompanyDetails companyDetails)
	{
		portal.companyRegistration(companyDetails);
	}
	
	public CompanyDetails companyLogin(long userID, String password) throws WrongEntryException
	{
		CompanyDetails companyDetails = portal.companyLogin(userID, password);
		
		return companyDetails;
	}
	
	public void vacancyRegistration(VacancyDetails vacancyDetails)
	{
		portal.vacancyRegistration(vacancyDetails);
	}
}
