package beginnersTask;

public class SingletonWithoutEnum
{
	private int value;
	static SingletonWithoutEnum instance = new SingletonWithoutEnum();

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	private SingletonWithoutEnum()
	{
		
	}
	
	public static SingletonWithoutEnum createInstance()
	{
		return instance;
	}
	
}
