package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

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
					System.out.println("Week Day for Current Time : " + obj.getCurrentWeekDay());
					
					long milliSeconds = runner.getmilliseconds();
					System.out.println("Week Day for given time : " + obj.getWeekDay(milliSeconds));
					break;
				}
				case 5:
				{
					System.out.println("Month of the current Time : " + obj.getCurrentMonth());
					
					long milliSeconds = runner.getmilliseconds();
					System.out.println("Month of the given Time : " + obj.getMonth(milliSeconds));
					break;
				}
				case 6:
				{
					System.out.println("Current Year : " + obj.getCurrentYear());
					
					long milliSeconds = runner.getmilliseconds();
					System.out.println("Year of given Time : " + obj.getYear(milliSeconds));
					break;
				}
				default:
				{
					System.out.println("Invalid case number...");
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
