package logiclayer;

import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import exceptions.WrongEntryException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class StudentLayer extends UserLayer
{
	VirtualClassRoomInterface dbInterf = new VirtualClassRoomDataBase();
	
	public Map<Integer, MaterialDetails> showMaterials() throws WrongEntryException
	{
		Map<Integer, MaterialDetails> materialMap = dbInterf.showMaterials();
		
		return materialMap;
	}
	
	public void askQuestion(QADetails qaDetails) throws WrongEntryException
	{
		dbInterf.askQuestion(qaDetails);
	}
	
	public Map<Integer, QADetails> showAnswers() throws WrongEntryException
	{
		Map<Integer, QADetails> qaMap = dbInterf.showAnswers();
		
		return qaMap;
	}
}
