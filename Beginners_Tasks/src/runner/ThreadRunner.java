package runner;

import java.util.Scanner;

import beginnersTask.ThreadRunnable;
import beginnersTask.Threads;

public class ThreadRunner
{
	static Scanner sc = new Scanner(System.in);

	public long getSleepTime()
	{
		System.out.println("Enter the sleep time in milliseconds...");
		long sleepTime = sc.nextLong();
		return sleepTime;
	}
	
	public static void main(String[] args)
	{
		ThreadRunner runner = new ThreadRunner();
		System.out.println("Enter the case number to execute...");
		int caseValue = sc.nextInt();
		sc.nextLine();
		switch(caseValue)
		{
			case 1:
			{
				Threads thread = new Threads();
				System.out.println("Thread Name : " +thread.getName() +
								   "\nPriority : " + thread.getPriority() +
								   "\nState : " + thread.getState());
				thread.start();
		
				System.out.println("Thread Name : " +thread.getName() +
			    		     	   "\nPriority : " + thread.getPriority() +
			    		     	   "\nState : " + thread.getState());
				break;
			}
			case 2:
			{
				ThreadRunnable threadRun = new ThreadRunnable();
				Thread thread = new Thread(threadRun);
				
				System.out.println("Thread Name : " + thread.getName() +
								   "\nPriority : " + thread.getPriority() +
								   "\nState : " + thread.getState());
				
				thread.start();
				
				System.out.println("Thread Name : " + thread.getName() +
							       "\nPriority : " + thread.getPriority() +
							       "\nState : " + thread.getState());
				break;
			}
			case 3:
			{
				Threads thread = new Threads("ExtendedThread");
				System.out.println("Thread Name : " +thread.getName() +
								   "\nPriority : " + thread.getPriority() +
								   "\nState : " + thread.getState());
				thread.start();
		
				System.out.println("Thread Name : " +thread.getName() +
			    		     	   "\nPriority : " + thread.getPriority() +
			    		     	   "\nState : " + thread.getState());
				
				ThreadRunnable threadRun = new ThreadRunnable();
				Thread thread1 = new Thread(threadRun, "RunnableThread");
				
				System.out.println("Thread Name : " + thread1.getName() +
								   "\nPriority : " + thread1.getPriority() +
								   "\nState : " + thread1.getState());
				
				thread1.start();
				
				System.out.println("Thread Name : " + thread1.getName() +
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
				Threads thread1 = new Threads("ExtendedThread-1");
				long sleepTime = runner.getSleepTime();
				thread1.setSleepTime(sleepTime);
				Threads thread2 = new Threads("ExtendedThread-2");
				sleepTime = runner.getSleepTime();
				thread2.setSleepTime(sleepTime);
				Threads thread3 = new Threads("ExtendedThread-3");
				sleepTime = runner.getSleepTime();
				thread3.setSleepTime(sleepTime);
				Threads thread4 = new Threads("ExtendedThread-4");
				sleepTime = runner.getSleepTime();
				thread4.setSleepTime(sleepTime);
				Threads thread5 = new Threads("ExtendedThread-5");
				sleepTime = runner.getSleepTime();
				thread5.setSleepTime(sleepTime);
				thread1.start();
				thread2.start();
				thread3.start();
				thread4.start();
				thread5.start();
				
				ThreadRunnable threadRun1 = new ThreadRunnable();
				Thread runnableThread1 = new Thread(threadRun1, "RunnableThread-1");
				sleepTime = runner.getSleepTime();
				threadRun1.setSleepTime(sleepTime);
				ThreadRunnable threadRun2 = new ThreadRunnable();
				Thread runnableThread2 = new Thread(threadRun2, "RunnableThread-2");
				sleepTime = runner.getSleepTime();
				threadRun2.setSleepTime(sleepTime);
				ThreadRunnable threadRun3 = new ThreadRunnable();
				Thread runnableThread3 = new Thread(threadRun3, "RunnableThread-3");
				sleepTime = runner.getSleepTime();
				threadRun3.setSleepTime(sleepTime);
				ThreadRunnable threadRun4 = new ThreadRunnable();
				Thread runnableThread4 = new Thread(threadRun4, "RunnableThread-4");
				sleepTime = runner.getSleepTime();
				threadRun4.setSleepTime(sleepTime);
				ThreadRunnable threadRun5 = new ThreadRunnable();
				Thread runnableThread5 = new Thread(threadRun5, "RunnableThread-5");
				sleepTime = runner.getSleepTime();
				threadRun5.setSleepTime(sleepTime);
				runnableThread1.start();
				runnableThread2.start();
				runnableThread3.start();
				runnableThread4.start();
				runnableThread5.start();
				
				break;
			}
			default:
			{
				System.out.println("XXX...Invalid case number...XXX");
				break;
			}
			
		}
		
		sc.close();
		
	}

}
