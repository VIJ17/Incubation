package virtualclassroomframe;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public interface VirtualClassRoomInterface
{
	UserDetails userRegistration(UserDetails userDetails) throws WrongEntryException;
	
	UserDetails userLogin(long userID, String password) throws WrongEntryException;
	
	boolean editProfile(UserDetails userDetails) throws WrongEntryException;
	
	Map<Integer, MaterialDetails> showMaterials() throws WrongEntryException;
	
	boolean uploadMaterials(MaterialDetails materialDetails) throws WrongEntryException;
	
	void removeMaterial(long materialID) throws WrongEntryException;
	
	void askQuestion(QADetails qaDetails) throws WrongEntryException;
	
	Map<Integer, QADetails> showAnswers() throws WrongEntryException;
	
	Map<Integer, QADetails> showQuestions(long postedBy) throws WrongEntryException;
	
	void uploadAnswers(QADetails qaDetails) throws WrongEntryException;
	
	Map<Integer, UserDetails> getUsersList() throws WrongEntryException;
	
	Map<Integer, UserDetails> showRequest() throws WrongEntryException;
	
	Map<Integer, QADetails> showQuestionsAndAnswers() throws WrongEntryException;
	
	void deleteQADetails(long questionID) throws WrongEntryException;
	
}
