package logiclayer;

import java.util.Map;

import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.InvalidException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class AdminLayer extends UserLayer
{
	VirtualClassRoomInterface dbInterf = UserLayer.dbInterf;
	
	public Map<Integer, UserDetails> getUsersList() throws InvalidException
	{
		Map<Integer, UserDetails> usersMap = dbInterf.getUsersList();
		
		return usersMap;
	}
	
	public Map<Integer, UserDetails> showRequest() throws InvalidException
	{
		Map<Integer, UserDetails> usersMap = dbInterf.showRequest();
		
		return usersMap;
	}
	
	public Map<Integer, QADetails> showQuestionsAndAnswers() throws InvalidException
	{
		Map<Integer, QADetails> qaMap = dbInterf.showQuestionsAndAnswers();
		
		return qaMap;
	}
	
	public void deleteQADetails(long questionID) throws InvalidException
	{
		dbInterf.deleteQADetails(questionID);
	}
}
