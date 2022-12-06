package logiclayer;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import exceptions.WrongEntryException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class FacultyLayer extends UserLayer
{
	VirtualClassRoomInterface dbInterf = new VirtualClassRoomDataBase();
	
	public boolean uploadMaterials(MaterialDetails materialDetails) throws WrongEntryException
	{
		boolean result = dbInterf.uploadMaterials(materialDetails);
		
		return result;
	}
	
	public void removeMaterial(long materialID) throws WrongEntryException
	{
		dbInterf.removeMaterial(materialID);
	}
	
	public Map<Integer, QADetails> showQuestions(long postedBy) throws WrongEntryException
	{
		Map<Integer, QADetails> qaMap = dbInterf.showQuestions(postedBy);
		
		return qaMap;
	}
	
	public void uploadAnswers(QADetails qaDetails) throws WrongEntryException
	{
		dbInterf.uploadAnswers(qaDetails);
	}
}
