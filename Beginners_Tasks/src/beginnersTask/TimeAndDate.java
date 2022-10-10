package beginnersTask;

import java.time.format.DateTimeFormatter;

import exceptions.WrongEntryException;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeAndDate
{
	
	Strings word = new Strings();
	
	public DateTimeFormatter getFormat(String dateTimeFormat) throws WrongEntryException
	{
		word.nullCheck(dateTimeFormat);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern(dateTimeFormat);
		return format;
	}
	
	public String getCurrentTimeAndDate(String dateTimeFormat) throws WrongEntryException
	{
		DateTimeFormatter formate = getFormat(dateTimeFormat);
		LocalDateTime now = LocalDateTime.now();
		return formate.format(now);
	}
	
	public long getCurrentMilliSeconds()
	{
//		 Date date = new Date();
//		 long timeMilli = date.getTime();
		
//		Clock clock = Clock.systemDefaultZone();
//		long milliSeconds = clock.millis();
		
		 return System.currentTimeMillis();  //swami
	}
	
	public String getCurrentTimeAndDateInGivenZone(ZoneId zoneId, String dateTimeFormat) throws WrongEntryException
	{
		DateTimeFormatter formate = getFormat(dateTimeFormat);
		LocalDateTime now = LocalDateTime.now(zoneId);
		return formate.format(now);
	}
	
	public ZoneId getZoneId(String zone) throws WrongEntryException
	{
		word.nullCheck(zone);
		
		ZoneId zoneId = ZoneId.of(zone);
		return zoneId;
	}
	
	public ZoneId getSystemZoneId()
	{
		ZoneId zoneId = ZoneId.systemDefault();
		return zoneId;
	}
	
	public LocalDate getLocalDate(long milliSeconds, ZoneId zoneId)
	{
		Instant instant = Instant.ofEpochMilli(milliSeconds);				   //Obtains an instance of Instant using milliseconds from the epoch of 1970-01-01T00:00:00Z.
		ZonedDateTime zoneDateTime = instant.atZone(zoneId);   	   			   //Combines this instant with a time-zone to create a ZonedDateTime.
																			   //This returns an ZonedDateTime formed from this instant at the specified time-zone.
		LocalDate date = zoneDateTime.toLocalDate();						   //Gets the LocalDate part of this date-time.Returns the date part of this date-time.
		return date;
	}
	
	public String getWeekDay(long milliSeconds, ZoneId zoneId)
	{
		LocalDate date = getLocalDate(milliSeconds, zoneId);
		DayOfWeek day = DayOfWeek.from(date);
		return day.name();
	}
	
	public Month getMonth(long milliSeconds, ZoneId zoneId)
	{
		LocalDate date = getLocalDate(milliSeconds, zoneId);
		return date.getMonth();
	}
	
	public int getYear(long milliSeconds, ZoneId zoneId)
	{
		LocalDate date = getLocalDate(milliSeconds, zoneId);
		return date.getYear();
	}
}
