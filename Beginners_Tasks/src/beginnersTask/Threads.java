package beginnersTask;

public class Threads extends Thread
{
	private long sleepTime;
	
	public void setSleepTime(long sleepTime)
	{
		this.sleepTime = sleepTime;
	}
	
	public Threads()
	{
		
	}
	
	public Threads(String name)
	{
		setName(name);
	}
	
	@Override
	public void run()
	{
		System.out.println("Thread Name : " +Thread.currentThread().getName() +
						   "\nPriority : " + Thread.currentThread().getPriority() +
						   "\nState : " + Thread.currentThread().getState());
		System.out.println("Going to Sleep : " + Thread.currentThread().getName());
		try
		{
			Thread.sleep(sleepTime);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("After Sleeping : " + Thread.currentThread().getName());
	}
	
}
