package logiclayer;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import exceptions.InvalidException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class FacultyLayer extends UserLayer
{
	VirtualClassRoomInterface dbInterf = UserLayer.dbInterf;
	
	public boolean uploadMaterials(MaterialDetails materialDetails) throws InvalidException
	{
		boolean result = dbInterf.uploadMaterials(materialDetails);
		
		return result;
	}
	
	public void removeMaterial(long materialID) throws InvalidException
	{
		dbInterf.removeMaterial(materialID);
	}
	
	public Map<Integer, QADetails> showQuestions(long postedBy) throws InvalidException
	{
		Map<Integer, QADetails> qaMap = dbInterf.showQuestions(postedBy);
		
		return qaMap;
	}
	
	public void uploadAnswers(QADetails qaDetails) throws InvalidException
	{
		dbInterf.uploadAnswers(qaDetails);
	}
}
