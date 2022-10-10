package runner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import beginnersTask.ThreadRunnable;
import beginnersTask.Threads;

public class ThreadRunner
{
	
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Scanner sc = new Scanner(System.in);

	public long getSleepTime()
	{
		logger.info("Enter the sleep time in milliseconds...");
		long sleepTime = sc.nextLong();
		return sleepTime;
	}
	
	public static void main(String[] args)
	{
		ThreadRunner runner = new ThreadRunner();
		int caseValue = 0;
		try
		{
			logger.info("Enter the case number to execute...");
			caseValue = sc.nextInt();
			sc.nextLine();
		}
		catch(InputMismatchException e)
		{
			logger.warning("Invalid Data Type.");
		}
		switch(caseValue)
		{
			case 1:
			{
				Threads thread = new Threads();
				logger.info("Thread Name : " +thread.getName() +
								   "\nPriority : " + thread.getPriority() +
								   "\nState : " + thread.getState());
				thread.start();
		
				logger.info("Thread Name : " +thread.getName() +
			    		     	   "\nPriority : " + thread.getPriority() +
			    		     	   "\nState : " + thread.getState());
				break;
			}
			case 2:
			{
				ThreadRunnable threadRun = new ThreadRunnable();
				Thread thread = new Thread(threadRun);
				
				logger.info("Thread Name : " + thread.getName() +
								   "\nPriority : " + thread.getPriority() +
								   "\nState : " + thread.getState());
				
				thread.start();
				
				logger.info("Thread Name : " + thread.getName() +
							       "\nPriority : " + thread.getPriority() +
							       "\nState : " + thread.getState());
				break;
			}
			case 3:
			{
				Threads thread = new Threads("ExtendedThread");
				logger.info("Thread Name : " +thread.getName() +
								   "\nPriority : " + thread.getPriority() +
								   "\nState : " + thread.getState());
				thread.start();
		
				logger.info("Thread Name : " +thread.getName() +
			    		     	   "\nPriority : " + thread.getPriority() +
			    		     	   "\nState : " + thread.getState());
				
				ThreadRunnable threadRun = new ThreadRunnable();
				Thread thread1 = new Thread(threadRun, "RunnableThread");
				
				logger.info("Thread Name : " + thread1.getName() +
								   "\nPriority : " + thread1.getPriority() +
								   "\nState : " + thread1.getState());
				
				thread1.start();
				
				logger.info("Thread Name : " + thread1.getName() +
							       "\nPriority : " + thread1.getPriority() +
							       "\nState : " + thread1.getState());
				break;
			}
			case 4:
			{
				Threads thread1 = new Threads("ExtendedThread-1");
				Threads thread2 = new Threads("ExtendedThread-2");
				Threads thread3 = new Threads("ExtendedThread-3");
				Threads thread4 = new Threads("ExtendedThread-4");
				Threads thread5 = new Threads("ExtendedThread-5");
				thread1.start();
				thread2.start();
				thread3.start();
				thread4.start();
				thread5.start();
				
				ThreadRunnable threadRun1 = new ThreadRunnable();
				Thread runnableThread1 = new Thread(threadRun1, "RunnableThread-1");
				ThreadRunnable threadRun2 = new ThreadRunnable();
				Thread runnableThread2 = new Thread(threadRun2, "RunnableThread-2");
				ThreadRunnable threadRun3 = new ThreadRunnable();
				Thread runnableThread3 = new Thread(threadRun3, "RunnableThread-3");
				ThreadRunnable threadRun4 = new ThreadRunnable();
				Thread runnableThread4 = new Thread(threadRun4, "RunnableThread-4");
				ThreadRunnable threadRun5 = new ThreadRunnable();
				Thread runnableThread5 = new Thread(threadRun5, "RunnableThread-5");
				runnableThread1.start();
				runnableThread2.start();
				runnableThread3.start();
				runnableThread4.start();
				runnableThread5.start();
				
				break;
			}
			case 5:
			{
				Threads thread1 = new Threads("ExtendedThread-1", runner.getSleepTime());
				Threads thread2 = new Threads("ExtendedThread-2", runner.getSleepTime());
				Threads thread3 = new Threads("ExtendedThread-3", runner.getSleepTime());
				Threads thread4 = new Threads("ExtendedThread-4", runner.getSleepTime());
				Threads thread5 = new Threads("ExtendedThread-5", runner.getSleepTime());
				thread1.start();
				thread2.start();
				thread3.start();
				thread4.start();
				thread5.start();
				
				ThreadRunnable threadRun1 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread1 = new Thread(threadRun1, "RunnableThread-1");
				ThreadRunnable threadRun2 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread2 = new Thread(threadRun2, "RunnableThread-2");
				ThreadRunnable threadRun3 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread3 = new Thread(threadRun3, "RunnableThread-3");
				ThreadRunnable threadRun4 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread4 = new Thread(threadRun4, "RunnableThread-4");
				ThreadRunnable threadRun5 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread5 = new Thread(threadRun5, "RunnableThread-5");
				runnableThread1.start();
				runnableThread2.start();
				runnableThread3.start();
				runnableThread4.start();
				runnableThread5.start();
				
				break;
			}
			case 6:
			{
				Threads thread1 = new Threads("ExtendedThread-1", runner.getSleepTime());
				thread1.setWhileCondition(true);
				Threads thread2 = new Threads("ExtendedThread-2", runner.getSleepTime());
				thread2.setWhileCondition(true);
				Threads thread3 = new Threads("ExtendedThread-3", runner.getSleepTime());
				thread3.setWhileCondition(true);
				thread1.start();
				thread2.start();
				thread3.start();
				
				ThreadRunnable threadRun1 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread1 = new Thread(threadRun1, "RunnableThread-1");
				threadRun1.setWhileCondition(true);
				ThreadRunnable threadRun2 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread2 = new Thread(threadRun2, "RunnableThread-2");
				threadRun2.setWhileCondition(true);
				ThreadRunnable threadRun3 = new ThreadRunnable(runner.getSleepTime());
				Thread runnableThread3 = new Thread(threadRun3, "RunnableThread-3");
				threadRun3.setWhileCondition(true);
				runnableThread1.start();
				runnableThread2.start();
				runnableThread3.start();
				
				break;
			}
			case 7:
			{
				Threads thread1 = new Threads("ExtendedThread-1");
				thread1.setWhileCondition(true);
				Threads thread2 = new Threads("ExtendedThread-2");
				thread2.setWhileCondition(true);
				Threads thread3 = new Threads("ExtendedThread-3");
				thread3.setWhileCondition(true);
				thread1.start();
				thread2.start();
				thread3.start();
				
				ThreadRunnable threadRun1 = new ThreadRunnable();
				Thread runnableThread1 = new Thread(threadRun1, "RunnableThread-1");
				threadRun1.setWhileCondition(true);
				ThreadRunnable threadRun2 = new ThreadRunnable();
				Thread runnableThread2 = new Thread(threadRun2, "RunnableThread-2");
				threadRun2.setWhileCondition(true);
				ThreadRunnable threadRun3 = new ThreadRunnable();
				Thread runnableThread3 = new Thread(threadRun3, "RunnableThread-3");
				threadRun3.setWhileCondition(true);
				runnableThread1.start();
				runnableThread2.start();
				runnableThread3.start();
				
				try
				{
					Thread.sleep(30000);
					thread1.setWhileCondition(false);
					
					Thread.sleep(30000);
					thread2.setWhileCondition(false);

					Thread.sleep(30000);
					thread3.setWhileCondition(false);
					
					Thread.sleep(30000);
					threadRun1.setWhileCondition(false);
					
					Thread.sleep(30000);
					threadRun2.setWhileCondition(false);
					
					Thread.sleep(30000);
					threadRun3.setWhileCondition(false);
					
					int count = Thread.activeCount();
					System.out.println("Number of threads active : "+count);
					
					Thread.sleep(5000);
					if(!(thread1.isAlive() && thread2.isAlive() && thread3.isAlive() &&
							runnableThread1.isAlive() && runnableThread2.isAlive() && runnableThread3.isAlive()))
					{
						logger.info("Tasks Completed.");
					}
					
					Thread.sleep(20000);
				}
				catch (InterruptedException e)
				{
					logger.info("Data type mismatch...");
					e.printStackTrace();
				}
				
				break;
			}
			default:
			{
				logger.info("XXX...Invalid case number...XXX");
				break;
			}
			
		}
		
		sc.close();
		
	}

}
