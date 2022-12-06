package logiclayer;

import datacarier.UserDetails;
import exceptions.InvalidException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class UserLayer
{
	protected static VirtualClassRoomInterface dbInterf = new VirtualClassRoomDataBase();
	
	public UserDetails userRegistration(UserDetails userDetails) throws InvalidException
	{
		userDetails = dbInterf.userRegistration(userDetails);
		
		return userDetails;
	}
	
	public UserDetails userLogin(long userID, String password) throws InvalidException
	{
		UserDetails userDetails = dbInterf.userLogin(userID, password);
		
		return userDetails;
	}
	
	public boolean editProfile(UserDetails userDetails) throws InvalidException
	{
		boolean result = dbInterf.editProfile(userDetails);
		
		return result;
	}
}
