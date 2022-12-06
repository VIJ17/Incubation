package logiclayer;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import exceptions.InvalidException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class StudentLayer extends UserLayer
{
	VirtualClassRoomInterface dbInterf = UserLayer.dbInterf;
	
	public Map<Integer, MaterialDetails> showMaterials() throws InvalidException
	{
		Map<Integer, MaterialDetails> materialMap = dbInterf.showMaterials();
		
		return materialMap;
	}
	
	public void askQuestion(QADetails qaDetails) throws InvalidException
	{
		dbInterf.askQuestion(qaDetails);
	}
	
	public Map<Integer, QADetails> showAnswers() throws InvalidException
	{
		Map<Integer, QADetails> qaMap = dbInterf.showAnswers();
		
		return qaMap;
	}
}
