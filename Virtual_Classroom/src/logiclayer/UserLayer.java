package logiclayer;

import datacarier.UserDetails;
import exceptions.WrongEntryException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class UserLayer
{
	VirtualClassRoomInterface dbInterf = new VirtualClassRoomDataBase();
	
	public UserDetails userRegistration(UserDetails userDetails) throws WrongEntryException
	{
		userDetails = dbInterf.userRegistration(userDetails);
		
		return userDetails;
	}
	
	public UserDetails userLogin(long userID, String password) throws WrongEntryException
	{
		UserDetails userDetails = dbInterf.userLogin(userID, password);
		
		return userDetails;
	}
	
	public boolean editProfile(UserDetails userDetails) throws WrongEntryException
	{
		boolean result = dbInterf.editProfile(userDetails);
		
		return result;
	}
}
