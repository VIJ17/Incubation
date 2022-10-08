package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import beginnersTask.SingletonUsingEnum;
import beginnersTask.SingletonWithoutEnum;
import beginnersTask.UsingEnum.RainbowColors;

public class EnumRunner
{
	public static void main(String args[])
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		String decision;
		do
		{
			System.out.println("Enter the case value to execute...");
			int caseValue = sc.nextInt();
			sc.nextLine();
			switch(caseValue)
			{
				case 1:
				{
					for(RainbowColors color : RainbowColors.values())
					{
						System.out.println("Color code of " + color + " is " + color.getValue());
						System.out.println("Index of color " + color + " is " + color.ordinal());
					}
					break;
				}
				case 2:
				{
					SingletonUsingEnum singleton = SingletonUsingEnum.INSTANCE;
					System.out.println("Enter the value...");
					int value = sc.nextInt();
					sc.nextLine();
					singleton.setValue(value);
					System.out.println("Printing the value stored in singleton : " + singleton.getValue());
					break;
				}
				case 3:
				{
					SingletonWithoutEnum singleton = SingletonWithoutEnum.createInstance();
					SingletonWithoutEnum singleton1 = SingletonWithoutEnum.createInstance();    //For checking of singleton...

					System.out.println("Enter the value...");
					int value = sc.nextInt();
					sc.nextLine();
					singleton.setValue(value);
					System.out.println("Printing the value stored in singleton : " + singleton.getValue());
					System.out.println("Printing the value stored in singleton : " + singleton1.getValue());
					break;
				}
				default:
				{
					System.out.println("XXX...Invalid case value...XXX");
					break;
				}
			}
			
			System.out.println("Enter 'Yes' to continue. \n'No' to exit.");
			decision = sc.nextLine();
			
		}while(decision.equalsIgnoreCase("Yes"));
		
		sc.close();
		}
		catch(InputMismatchException e)
		{
			e.printStackTrace();
		}
	}
}
