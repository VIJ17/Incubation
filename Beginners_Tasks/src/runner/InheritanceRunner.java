package runner;

import java.util.Scanner;

import beginnersTask.Car;
import beginnersTask.Duck;
import beginnersTask.ParrotMod;
import beginnersTask.SCross;
import beginnersTask.Swift;
import beginnersTask.XUV;

public class InheritanceRunner
{
	public void swiftMethod(Swift swift)
	{
		System.out.println("Done");
	}
	public void parentMethod(Car car)
	{
		if(car instanceof Swift)
		{
			System.out.println("Hatch");
		}
		else if(car instanceof SCross)
		{
			System.out.println("Sedan");
		}
		else if (car instanceof XUV)
		{
			System.out.println("SUV");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		InheritanceRunner runner = new InheritanceRunner();
		Car car = new Car();
		Swift swift = new Swift();
		XUV xuv = new XUV();
		SCross scross = new SCross();
		
		System.out.println("Enter the no. of seats for Swift car...");
		int seats = sc.nextInt();
		swift.setNoOfSeats(seats);
		System.out.println("Enter the no. of airbags for Swift car...");
		int airBags = sc.nextInt();
		swift.setNoOfAirBags(airBags);
		System.out.println("Enter the model name for Swift car...");
		sc.nextLine();
		String model = sc.nextLine();
		swift.setCarModelName(model);
		System.out.println("Enter the color for Swift car...");
		String color = sc.nextLine();
		swift.setCarColor(color);
		System.out.println("No. of seats for Swift car is : "+swift.getNoOfSeats());
		System.out.println("No. of airbags for Swift car is : "+swift.getNoOfAirBags());
		System.out.println("Model of the Swift car is : "+swift.getCarModelName());
		System.out.println("Color of the Swift car is : "+swift.getCarColor());
		
		System.out.println("Enter the no. of seats for SCross caar...");
		seats = sc.nextInt();
		scross.setNoOfSeats(seats);
		System.out.println("Enter the no. of airbags for SCross caar...");
		airBags = sc.nextInt();
		scross.setNoOfAirBags(airBags);
		System.out.println("Enter the model name for SCross car...");
		sc.nextLine();
		model = sc.nextLine();
		scross.setCarModelName(model);
		System.out.println("Enter the color for SCross car...");
		color = sc.nextLine();
		scross.setCarColor(color);
		System.out.println("No. of seats for SCross car is : "+scross.getNoOfSeats());
		System.out.println("No. of airbags for SCross car is : "+scross.getNoOfAirBags());
		System.out.println("Model of the SCross car is : "+scross.getCarModelName());
		System.out.println("Color of the SCross car is : "+scross.getCarColor());
		System.out.println("Enter the manufactured year of SCross car...");
		int yearOfMake = sc.nextInt();
		scross.setCarManufactureYear(yearOfMake);
		System.out.println("Enter the engine number of SCross car...");
		sc.nextLine();
		String engineNumber = sc.nextLine();
		scross.setCarEngineNumber(engineNumber);
		System.out.println("Enter the type of SCross car...");
		String type = sc.nextLine();
		scross.setCarType(type);
		System.out.println("Manufactured year of SCross car is :"+scross.getCarManufactureYear());
		System.out.println("Engine number of SCross car is :"+scross.getCarEngineNumber());
		System.out.println("Type of the SCross car is :"+scross.getCarType());
		
		runner.parentMethod(swift);
		runner.parentMethod(scross);
		runner.parentMethod(xuv);
		
		runner.swiftMethod(swift);
		Car obj = new Swift();
		//runner.swiftMethod(obj);
		//runner.swiftMethod(scross);
		//runner.swiftMethod(xuv);
		
		scross.maintenance();
		obj = new SCross();
		obj.maintenance();
		car.maintenance();
		swift.maintenance();
		
		//XUV xuv1 = new XUV("Overload");
		
		//BirdAbstract bird = new BirdAbstract();
		
		ParrotMod parrot = new ParrotMod();
		parrot.fly();
		parrot.speak();
		
		Duck duck = new Duck();
		duck.fly();
		duck.speak();
		
	sc.close();	
	}
}
