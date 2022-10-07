package beginnersTask;

import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
	
	public LocalDate getLocalDate(long milliSeconds)
	{
		Instant instant = Instant.ofEpochMilli(milliSeconds);				   //Obtains an instance of Instant using milliseconds from the epoch of 1970-01-01T00:00:00Z.
		ZonedDateTime zoneDateTime = instant.atZone(ZoneId.systemDefault());   //Combines this instant with a time-zone to create a ZonedDateTime.
																			   //This returns an ZonedDateTime formed from this instant at the specified time-zone.
		LocalDate date = zoneDateTime.toLocalDate();						   //Gets the LocalDate part of this date-time.Returns the date part of this date-time.
		return date;
	}
	
	public String getWeekDay(long milliSeconds)
	{
		LocalDate date = getLocalDate(milliSeconds);
		DayOfWeek day = DayOfWeek.from(date);
		return day.name();
	}
	
	public Month getMonth(long milliSeconds)
	{
		LocalDate date = getLocalDate(milliSeconds);
		return date.getMonth();
	}
	
	public int getYear(long milliSeconds)
	{
		LocalDate date = getLocalDate(milliSeconds);
		return date.getYear();
	}
}
