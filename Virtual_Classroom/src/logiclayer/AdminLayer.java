package logiclayer;

import java.util.Map;

import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class AdminLayer
{
	VirtualClassRoomInterface dbInterf = new VirtualClassRoomDataBase();
	
	public Map<Integer, UserDetails> getUsersList() throws WrongEntryException
	{
		Map<Integer, UserDetails> usersMap = dbInterf.getUsersList();
		
		return usersMap;
	}
	
	public Map<Integer, UserDetails> showRequest() throws WrongEntryException
	{
		Map<Integer, UserDetails> usersMap = dbInterf.showRequest();
		
		return usersMap;
	}
	
	public Map<Integer, QADetails> showQuestionsAndAnswers() throws WrongEntryException
	{
		Map<Integer, QADetails> qaMap = dbInterf.showQuestionsAndAnswers();
		
		return qaMap;
	}
	
	public void deleteQADetails(long questionID) throws WrongEntryException
	{
		dbInterf.deleteQADetails(questionID);
	}
}
