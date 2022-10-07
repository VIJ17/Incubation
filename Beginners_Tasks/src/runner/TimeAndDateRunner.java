package runner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import beginnersTask.TimeAndDate;

public class TimeAndDateRunner
{
	
	static Scanner sc = new Scanner(System.in);
		
	public long getmilliseconds() throws InputMismatchException
	{
		System.out.println("Enter the Time in milliseconds...");
		long milliSeconds = sc.nextLong();
	
		return milliSeconds;
	}
	
	public static void main(String[] args)
	{ 
		TimeAndDate obj = new TimeAndDate();
		TimeAndDateRunner runner = new TimeAndDateRunner();
		Logger logger = Logger.getAnonymousLogger();
		
		try
		{
		
			System.out.println("Enter a case number to execute...");
			int caseValue = sc.nextInt();
			sc.nextLine();
			
			switch(caseValue)
			{
				case 1:
				{
					System.out.println(obj.getCurrentTimeAndDate());
					break;
				}
				case 2:
				{
					System.out.println(obj.getCurrentMilliSeconds());
					break;
				}
				case 3:
				{
					System.out.println("New_York Time & Date :" + obj.getCurrentTimeAndDateInNewYork());
					System.out.println("London Time & Date :" + obj.getCurrentTimeAndDateInLondon());
					break;
				}
				case 4:
				{
					System.out.println("Enter 1 to get Week Day for current time.\nEnter 2 to get Week Day for given time.");
					int decision = sc.nextInt();
					long milliSeconds;
					switch(decision)
					{
						case 1:
						{
							milliSeconds = obj.getCurrentMilliSeconds();
							logger.info("Week Day for Current Time : " + obj.getWeekDay(milliSeconds));
							break;
						}
						case 2:
						{
							milliSeconds = runner.getmilliseconds();
							logger.info("Week Day for given time : " + obj.getWeekDay(milliSeconds));
							break;
						}
						default:
						{
							logger.info("Invalid Case Number.");
							break;
						}
					}
					break;
				}
				case 5:
				{
					System.out.println("Enter 1 to get Month of the current time.\nEnter 2 to get Month of the given time.");
					int decision = sc.nextInt();
					long milliSeconds;
					switch(decision)
					{
						case 1:
						{
							milliSeconds = obj.getCurrentMilliSeconds();
							logger.info("Month of the current Time : " + obj.getMonth(milliSeconds));
							break;
						}
						case 2:
						{
							milliSeconds = runner.getmilliseconds();
							logger.info("Month of the given Time : " + obj.getMonth(milliSeconds));
							break;
						}
						default:
						{
							logger.info("Invalid Case Number.");
							break;
						}
					}
					break;
				}
				case 6:
				{
					System.out.println("Enter 1 to get Current Year.\nEnter 2 to get Year of the given time.");
					int decision = sc.nextInt();
					long milliSeconds;
					switch(decision)
					{
						case 1:
						{
							milliSeconds = obj.getCurrentMilliSeconds();
							logger.info("Current Year : " + obj.getYear(milliSeconds));
							break;
						}
						case 2:
						{
							milliSeconds = runner.getmilliseconds();
							logger.info("Year of given Time : " + obj.getYear(milliSeconds));
							break;
						}
						default:
						{
							logger.info("Invalid Case Number.");
							break;
						}
					}
					break;
				}
				default:
				{
					System.out.println("Invalid case number...");
					logger.info("Invalid Case Number.");
					break;
				}
			}
			
		}
		catch(InputMismatchException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(sc != null)
			{
				sc.close();
			}
		}
	}
	
}
