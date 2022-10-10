package beginnersTask;

import java.util.logging.Logger;

public class Threads extends Thread
{
	
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private long sleepTime = 5000;
	private boolean condition;
	
	public void setWhileCondition(boolean condition)
	{
		this.condition = condition;
	}
	
	public Threads(String name,long sleepTime)
	{
		setName(name);
		this.sleepTime = sleepTime;
	}
	
	public Threads()
	{
		super();
	}
	
	public Threads(String name)
	{
		setName(name);
	}
	
	@Override
	public void run()
	{
		while(condition)
		{
			logger.info("Thread Name : " +Thread.currentThread().getName() +
							   "\nPriority : " + Thread.currentThread().getPriority() +
							   "\nState : " + Thread.currentThread().getState());
			logger.info("Going to Sleep : " + Thread.currentThread().getName());
			try
			{
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e){}
			logger.info("After Sleeping : " + Thread.currentThread().getName());
		}
		
	}
	
//	case 6 & 7:
	
//	@Override
//	public void run()
//	{
//		
//		while(condition)
//		{
//			logger.info("Thread Name : " +Thread.currentThread().getName() +
//							   "\nPriority : " + Thread.currentThread().getPriority() +
//							   "\nState : " + Thread.currentThread().getState());
//			
//		}
//		
//	}
	
}
