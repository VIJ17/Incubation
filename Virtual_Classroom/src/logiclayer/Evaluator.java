package logiclayer;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public class Evaluator
{
	private UserLayer user = new UserLayer();
	private StudentLayer student = new StudentLayer();
	private FacultyLayer faculty = new FacultyLayer();
	private AdminLayer admin = new AdminLayer();
	
	public UserDetails userRegistration(UserDetails userDetails) throws WrongEntryException
	{
		userDetails = user.userRegistration(userDetails);
		return userDetails;
	}

	public UserDetails userLogin(long userID, String password) throws WrongEntryException
	{
		UserDetails userDetails = user.userLogin(userID, password);
		return userDetails;
	}

	public boolean editProfile(UserDetails userDetails) throws WrongEntryException
	{
		boolean result = user.editProfile(userDetails);
		return result;
	}

	
	public Map<Integer, MaterialDetails> showMaterials() throws WrongEntryException
	{
		Map<Integer, MaterialDetails> materialMap = student.showMaterials();
		return materialMap;
	}

	
	public boolean uploadMaterials(MaterialDetails materialDetails) throws WrongEntryException
	{
		boolean result = faculty.uploadMaterials(materialDetails);
		return result;
	}

	
	public void removeMaterial(long materialID) throws WrongEntryException
	{
		faculty.removeMaterial(materialID);
	}

	
	public void askQuestion(QADetails qaDetails) throws WrongEntryException
	{
		student.askQuestion(qaDetails);
	}

	
	public Map<Integer, QADetails> showAnswers() throws WrongEntryException
	{
		Map<Integer, QADetails> qaMap = student.showAnswers();
		return qaMap;
	}

	
	public Map<Integer, QADetails> showQuestions(long postedBy) throws WrongEntryException
	{
		Map<Integer, QADetails> qaMap = faculty.showQuestions(postedBy);
		return qaMap;
	}

	
	public void uploadAnswers(QADetails qaDetails) throws WrongEntryException
	{
		faculty.uploadAnswers(qaDetails);
	}

	
	public Map<Integer, UserDetails> getUsersList() throws WrongEntryException
	{
		Map<Integer, UserDetails> usersMap = admin.getUsersList();
		return usersMap;
	}

	
	public Map<Integer, UserDetails> showRequest() throws WrongEntryException
	{
		Map<Integer, UserDetails> usersMap = admin.showRequest();
		return usersMap;
	}

	
	public Map<Integer, QADetails> showQuestionsAndAnswers() throws WrongEntryException
	{
		Map<Integer, QADetails> qaMap = admin.showQuestionsAndAnswers();
		return qaMap;
	}

	
	public void deleteQADetails(long questionID) throws WrongEntryException
	{
		admin.deleteQADetails(questionID);
	}
	
}
