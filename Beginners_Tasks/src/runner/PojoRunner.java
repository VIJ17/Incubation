package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import beginnersTask.Pojo1;
import beginnersTask.Pojo2;

public class PojoRunner
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[])
	{
		String decision;
		do
		{
		try
		{
		System.out.println("Enter the case number to execute...");
		int caseValue = sc.nextInt();
		sc.nextLine();
		switch(caseValue)
		{
			case 1:
			{
				System.out.println("Enter a String...");
				String str = sc.nextLine();
				System.out.println("Calling Pojo1 Constructor...");
				Pojo1 pojo1Obj = new Pojo1(str);
				System.out.println("Printing the Pojo1 object...");
				System.out.println(pojo1Obj);
				break;
			}
			case 2:
			{
				System.out.println("Enter a String...");
				String str = sc.nextLine();
				System.out.println("Enter a integer value...");
				int intValue = sc.nextInt();
				System.out.println("Calling Pojo2 Constructor...");
				Pojo2 pojo2Obj = new Pojo2(str, intValue);
				System.out.println("Printing the Pojo2 object...");
				System.out.println(pojo2Obj);
				break;
			}
			case 3:
			{
				System.out.println("Enter a String...");
				String str = sc.nextLine();
				System.out.println("Enter a integer value...");
				int intValue = sc.nextInt();
				System.out.println("Calling Pojo2 Default Constructor...");
				Pojo2 pojo2Obj = new Pojo2();
				pojo2Obj.setString(str);
				pojo2Obj.setIntValue(intValue);
				System.out.println("String stored in Object : " + pojo2Obj.getString());
				System.out.println("Integer stored in Object : " + pojo2Obj.getIntValue());
				break;
			}
			default:
			{
				System.out.println("XXX...Invalid case value...XXX");
				break;
			}
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("...Invalid Data type entered...");
		}
		
		System.out.println("Enter 'Yes' to continue. \n'No' to exit.");
		decision = sc.nextLine();
	}while(decision.equalsIgnoreCase("Yes"));
	}
}
