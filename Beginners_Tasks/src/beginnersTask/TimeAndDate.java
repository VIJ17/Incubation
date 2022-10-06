package beginnersTask;

import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

public class TimeAndDate
{
	
	public String getCurrentTimeAndDate()
	{
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MMMM-YYYY HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return formate.format(now);
	}
	
	public long getCurrentMilliSeconds()
	{
//		 Date date = new Date();
//		 long timeMilli = date.getTime();
		 return System.currentTimeMillis();
	}
	
	public String getCurrentTimeAndDateInNewYork()
	{
		ZoneId londonId = ZoneId.of("America/New_York");
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MMMM-YYYY HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(londonId);
		return formate.format(now);
	}
	
	public String getCurrentTimeAndDateInLondon()
	{
		ZoneId londonId = ZoneId.of("Europe/London");
		DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MMMM-YYYY HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(londonId);
		return formate.format(now);
	}
	
	public String getCurrentWeekDay()
	{
		LocalDate date = LocalDate.now();
		DayOfWeek day = DayOfWeek.from(date);
		return day.name();
	}
	
	public String getWeekDay(long milliSeconds)
	{
		LocalDate date = Instant.ofEpochMilli(milliSeconds).atZone(ZoneId.systemDefault()).toLocalDate();
		DayOfWeek day = DayOfWeek.from(date);
		return day.name();
	}
	
	public Month getCurrentMonth()
	{
		LocalDate date = LocalDate.now();
		return date.getMonth();
	}
	
	public Month getMonth(long milliSeconds)
	{
		LocalDate date = Instant.ofEpochMilli(milliSeconds).atZone(ZoneId.systemDefault()).toLocalDate();
		return date.getMonth();
	}
	
	public int getCurrentYear()
	{
		LocalDate date = LocalDate.now();
		return date.getYear();
	}
	
	public int getYear(long milliSeconds)
	{
		LocalDate date = Instant.ofEpochMilli(milliSeconds).atZone(ZoneId.systemDefault()).toLocalDate();
		return date.getYear();
	}
}
