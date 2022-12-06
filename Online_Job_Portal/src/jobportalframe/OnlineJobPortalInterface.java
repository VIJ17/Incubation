package jobportalframe;

import java.util.List;

import datacarier.ApplicantDetails;
import datacarier.CompanyDetails;
import datacarier.VacancyDetails;
import exceptions.WrongEntryException;

public interface OnlineJobPortalInterface
{
	void applicantRegistration(ApplicantDetails applicantDetails);
	
	ApplicantDetails applicantLogin(long userID, String password) throws WrongEntryException;
	
	void companyRegistration(CompanyDetails companyDetails);
	
	CompanyDetails companyLogin(long userID, String password) throws WrongEntryException;
	
	void vacancyRegistration(VacancyDetails vacancyDetails);
	
	List<VacancyDetails> jobSearch(ApplicantDetails applicantDetails);
	
	void notification();
}
