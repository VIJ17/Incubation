package beginnersTask;

public class Pojo2
{
	private String str;
	private int intValue;
	
	public Pojo2()
	{
		
	}
	
	public Pojo2(String str, int intValue)
	{
		this.str = str;
		this.intValue = intValue;
	}
	
	@Override
	public String toString()
	{
		return "String = " + str + "\n" + "Integer = " + intValue;
	}
	
	public void setString(String str)
	{
		this.str = str;
	}
	public void setIntValue(int intValue)
	{
		this.intValue = intValue;
	}
	public String getString()
	{
		return str;
	}
	public int getIntValue()
	{
		return intValue;
	}
}
