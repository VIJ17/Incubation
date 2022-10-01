package beginnersTask;

public class PojoReflection
{
	private String str;
	private int intValue;
	
	public PojoReflection()
	{
		
	}
	
	public PojoReflection(String str, int intValue)
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
