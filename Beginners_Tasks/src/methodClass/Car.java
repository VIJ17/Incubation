package methodClass;

public class Car
{
	private int yearOfMake;
	private String engineNumber, type;
	
	public Car()
	{
		
	}
	Car(String str)
	{
		System.out.println(str);
	}
	public void maintenance()
	{
		System.out.println("Car under maintenance");
	}
	public void setCarManufactureYear(int yearOfMake)
	{
		this.yearOfMake = yearOfMake;
	}
	public void setCarEngineNumber(String engineNumber)
	{
		this.engineNumber = engineNumber;
	}
	public void setCarType(String type)
	{
		this.engineNumber = type;
	}
	public int getCarManufactureYear()
	{
		return yearOfMake;
	}
	public String getCarEngineNumber()
	{
		return engineNumber;
	}
	public String getCarType()
	{
		return type;
	}
}
