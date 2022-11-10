package util;

import exceptions.WrongEntryException;

public class InputCheck
{
	public  void nullCheck(String password) throws WrongEntryException
	{
		if(password == null)
		{
			throw new WrongEntryException("Password cannot be null.");
		}
	}
}
