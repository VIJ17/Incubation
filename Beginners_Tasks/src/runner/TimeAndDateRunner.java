package runner;

import java.time.ZoneId;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import beginnersTask.TimeAndDate;
import exceptions.WrongEntryException;

public class TimeAndDateRunner
{
	
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Scanner sc = new Scanner(System.in);
		
	public long getmilliseconds() throws InputMismatchException
	{
		logger.info("Enter the Time in milliseconds...");
		long milliSeconds = sc.nextLong();
	
		return milliSeconds;
	}
	
	public String getZone()
	{
		logger.info("Give the ZoneId...\nEnter:\nLon-London\nNyk-NewYork");
		String zoneId = sc.nextLine();
		if(zoneId.equalsIgnoreCase("Lon"))
		{
			zoneId = "Europe/London";
		}
		else if(zoneId.equalsIgnoreCase("Nyk"))
		{
			zoneId = "America/New_York";
		}
		return zoneId;
	}
	
	public String getFormatString()
	{
		logger.info("Ender 'd' for default format.\nor\nEnter 'm' to give manual format");
		String decision = sc.nextLine().toLowerCase();
		switch(decision)
		{
		case "d":
		{
			String dateTimeFormat = "YYYY/MMMM/dd HH:mm:ss";
			return dateTimeFormat;
		}
		case "m":
		{
			logger.info("Enter the Format of Date & Time to display...");
			String dateTimeFormat = sc.nextLine();
			return dateTimeFormat;
		}
		default:
		{
			logger.info("Input Invalid.");
			break;
		}
		}
		return null;
	}
	
	public static void main(String[] args)
	{ 
		TimeAndDate obj = new TimeAndDate();
		TimeAndDateRunner runner = new TimeAndDateRunner();
		
		try
		{
		
			logger.info("Enter a case number to execute...");
			int caseValue = sc.nextInt();
			sc.nextLine();
			
			switch(caseValue)
			{
				case 1:
				{
					String dateTimeFormat = runner.getFormatString();
					logger.info(obj.getCurrentTimeAndDate(dateTimeFormat));
					break;
				}
				case 2:
				{
					logger.info("Current Milli Seconds is : " + obj.getCurrentMilliSeconds());
					break;
				}
				case 3:
				{
					String zone1 = runner.getZone();
					ZoneId zoneId = obj.getZoneId(zone1);
					String dateTimeFormat = runner.getFormatString();
					logger.info("New_York Time & Date :" + obj.getCurrentTimeAndDateInGivenZone(zoneId, dateTimeFormat));
					String zone2 = runner.getZone();
					zoneId = obj.getZoneId(zone2);
					logger.info("London Time & Date :" + obj.getCurrentTimeAndDateInGivenZone(zoneId, dateTimeFormat));
					break;
				}
				case 4:
				{
					logger.info("Enter 1 to get Week Day for current time.\nEnter 2 to get Week Day for given millisecond.");
					int decision = sc.nextInt();
					ZoneId zoneId;
					long milliSeconds;
					switch(decision)
					{
						case 1:
						{
							zoneId = obj.getSystemZoneId();
							milliSeconds = obj.getCurrentMilliSeconds();
							logger.info("Week Day for Current Time : " + obj.getWeekDay(milliSeconds, zoneId));
							break;
						}
						case 2:
						{
							String zone = runner.getZone();
							zoneId = obj.getZoneId(zone);
							milliSeconds = runner.getmilliseconds();
							logger.info("Week Day for given time : " + obj.getWeekDay(milliSeconds, zoneId));
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
					logger.info("Enter 1 to get Month of the current time.\nEnter 2 to get Month of the given time.");
					int decision = sc.nextInt();
					ZoneId zoneId;
					long milliSeconds;
					switch(decision)
					{
						case 1:
						{
							zoneId = obj.getSystemZoneId();
							milliSeconds = obj.getCurrentMilliSeconds();
							logger.info("Month of the current Time : " + obj.getMonth(milliSeconds, zoneId));
							break;
						}
						case 2:
						{
							String zone = runner.getZone();
							zoneId = obj.getZoneId(zone);
							milliSeconds = runner.getmilliseconds();
							logger.info("Month of the given Time : " + obj.getMonth(milliSeconds, zoneId));
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
					logger.info("Enter 1 to get Current Year.\nEnter 2 to get Year of the given time.");
					int decision = sc.nextInt();
					ZoneId zoneId;
					long milliSeconds;
					switch(decision)
					{
						case 1:
						{
							zoneId = obj.getSystemZoneId();
							milliSeconds = obj.getCurrentMilliSeconds();
							logger.info("Current Year : " + obj.getYear(milliSeconds, zoneId));
							break;
						}
						case 2:
						{
							String zone = runner.getZone();
							zoneId = obj.getZoneId(zone);
							milliSeconds = runner.getmilliseconds();
							logger.info("Year of given Time : " + obj.getYear(milliSeconds, zoneId));
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
					logger.info("Invalid Case Number.");
					break;
				}
			}
			
		}
		catch(WrongEntryException e)
		{
			logger.warning(e.getMessage());
		}
		catch(InputMismatchException e)
		{
			logger.warning("Wrong Data Type Entered.");
//			e.printStackTrace();
		}
		finally
		{
			try
			{
				sc.close();
			}
			catch(Exception e) {}
		}
	}
	
}
