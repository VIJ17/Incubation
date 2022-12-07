package beginnersTask;

public class SingletonWithoutEnum
{
	private int value;
	private static SingletonWithoutEnum instance;

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
		if(instance == null)
		{
			synchronized(instance)
			{
				if(instance == null)
				{
					instance = new SingletonWithoutEnum();
				}
			}
		}
		return instance;
	}
	
}
