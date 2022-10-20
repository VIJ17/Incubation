package util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GetTimeFromMillisecond
{
	public String getInstantTimeAndDate(long millisecond)
	{
		
		Instant instant = Instant.ofEpochMilli(millisecond);
		ZonedDateTime zoneDateTime = instant.atZone(ZoneId.systemDefault());
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MMMM/YYYY HH:mm:ss");
		
		LocalDateTime dateWithTime = zoneDateTime.toLocalDateTime();
		String dateAndTime = format.format(dateWithTime);
		
		return dateAndTime;
	}
}
