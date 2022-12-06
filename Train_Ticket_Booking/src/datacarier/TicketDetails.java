package datacarier;

import java.io.Serializable;

public class TicketDetails implements Serializable
{
	private static final long serialVersionUID = -3371007769802287766L;
	
	private long pnrNo;
	private long waitingID;
	private long bookedByAadharNo;
	private String passengerName;
	private String gender;
	private int age;
	private String seatPreference;
	private String specialCase;
	private int seatNo;
	private String coach;
	private String fromPlace = "KARAIKUDI";
	private String toPlace = "CHENNAI";
	
	public long getPnrNo()
	{
		return pnrNo;
	}
	public void setPnrNo(long pnrNo)
	{
		this.pnrNo = pnrNo;
	}
	public String getPassengerName()
	{
		return passengerName;
	}
	public void setPassengerName(String passengerName)
	{
		this.passengerName = passengerName;
	}
	public int getSeatNo()
	{
		return seatNo;
	}
	public void setSeatNo(int seatNo)
	{
		this.seatNo = seatNo;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getSpecialCase() {
		return specialCase;
	}
	public void setSpecialCase(String specialCase)
	{
		this.specialCase = specialCase;
	}
	public String getSeatPreference()
	{
		return seatPreference;
	}
	public void setSeatPreference(String seatPreference)
	{
		this.seatPreference = seatPreference;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public long getWaitingID()
	{
		return waitingID;
	}
	public void setWaitingID(long waitingID)
	{
		this.waitingID = waitingID;
	}
	public String getFromPlace()
	{
		return fromPlace;
	}
	public void setFromPlace(String fromPlace)
	{
		this.fromPlace = fromPlace;
	}
	public String getToPlace()
	{
		return toPlace;
	}
	public void setToPlace(String toPlace)
	{
		this.toPlace = toPlace;
	}
	public String getCoach()
	{
		return coach;
	}
	public void setCoach(String coach)
	{
		this.coach = coach;
	}
	public long getBookedByAadharNo()
	{
		return bookedByAadharNo;
	}
	public void setBookedByAadharNo(long bookedByAadharNo)
	{
		this.bookedByAadharNo = bookedByAadharNo;
	}
	
}
