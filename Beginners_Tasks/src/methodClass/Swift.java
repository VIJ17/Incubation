package methodClass;

public class Swift extends Car
{
	private int noOfSeats, noOfAirBags;
	private String model, color;
	
	public void setNoOfSeats(int noOfSeats)
	{
		this.noOfSeats = noOfSeats;
	}
	public void setNoOfAirBags(int noOfAirBags)
	{
		this.noOfAirBags = noOfAirBags;
	}
	public void setCarModelName(String model)
	{
		this.model = model;
	}
	public void setCarColor(String color)
	{
		this.color = color;
	}
	public int getNoOfSeats()
	{
		return noOfSeats;
	}
	public int getNoOfAirBags()
	{
		return noOfAirBags;
	}
	public String getCarModelName()
	{
		return model;
	}
	public String getCarColor()
	{
		return color;
	}
}
