package banking;

import datacarier.UserDetails;
import exceptions.WrongEntryException;
import interfacemodule.BankingInterface;
import util.InputCheck;

public class BankUserLayer
{
	
	private InputCheck check = new InputCheck();
	protected BankingInterface bankInterf = new BankDataBase();
	
	public UserDetails userLogin(long userID, String password) throws WrongEntryException			//updated
	{
		check.nullCheck(password);
		
		UserDetails	userDetails = bankInterf.userLogin(userID, password);
		
		return userDetails;
	}
	
	public void modifyUserDetails(UserDetails userDetails) throws WrongEntryException
	{
		
		bankInterf.modifyUserDetails(userDetails);
	
	}
	
	public void modifyPassword(long userID, String oldPassword, String newPassword) throws WrongEntryException
	{
		check.nullCheck(newPassword);
		check.nullCheck(oldPassword);
		
		bankInterf.modifyPassword(userID, oldPassword, newPassword);
		
	}
	
}
