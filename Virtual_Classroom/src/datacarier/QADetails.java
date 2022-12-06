package datacarier;

public class QADetails extends MaterialDetails
{
	private long questionID;
	private String question;
	private String answer;
	
	public long getQuestionID()
	{
		return questionID;
	}
	public void setQuestionID(long questionID)
	{
		this.questionID = questionID;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
}