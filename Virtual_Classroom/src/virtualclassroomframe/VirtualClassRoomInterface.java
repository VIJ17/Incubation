package virtualclassroomframe;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.InvalidException;

public interface VirtualClassRoomInterface
{
	UserDetails userRegistration(UserDetails userDetails) throws InvalidException;
	
	UserDetails userLogin(long userID, String password) throws InvalidException;
	
	boolean editProfile(UserDetails userDetails) throws InvalidException;
	
	Map<Integer, MaterialDetails> showMaterials() throws InvalidException;
	
	boolean uploadMaterials(MaterialDetails materialDetails) throws InvalidException;
	
	void removeMaterial(long materialID) throws InvalidException;
	
	void askQuestion(QADetails qaDetails) throws InvalidException;
	
	Map<Integer, QADetails> showAnswers() throws InvalidException;
	
	Map<Integer, QADetails> showQuestions(long postedBy) throws InvalidException;
	
	void uploadAnswers(QADetails qaDetails) throws InvalidException;
	
	Map<Integer, UserDetails> getUsersList() throws InvalidException;
	
	Map<Integer, UserDetails> showRequest() throws InvalidException;
	
	Map<Integer, QADetails> showQuestionsAndAnswers() throws InvalidException;
	
	void deleteQADetails(long questionID) throws InvalidException;
	
}
