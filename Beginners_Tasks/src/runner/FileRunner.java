package runner;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import beginnersTask.Files_Properties;

public class FileRunner
{
	public static Scanner sc = new Scanner(System.in);
	
	public void setProperties(Properties prop)
	{
		System.out.println("Enter the number of Elements...");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Key & Value alternatively...");
		for(int i = 0; i<n; i++)
		{
			String key = sc.nextLine();
			String value = sc.nextLine();
			prop.setProperty(key,value);
		}
	}
	
	public String[] createArrayOfLines()
	{
		System.out.println("Enter the no of lines to write in the files...");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the lines one by one...");
		String[] strArray = new String[n];
		for(int i = 0; i<n; i++)
		{
			strArray[i] = sc.nextLine();
		}
		return strArray;
	}
	
	public static void main(String[] args)
	{
		FileRunner base = new FileRunner();
		Files_Properties obj = new Files_Properties();
		String decision;
		do
		{
		try
		{
		System.out.println("Enter the case value to execute...");
		int caseValue = sc.nextInt();
		sc.nextLine();
		switch(caseValue)
		{
		case 1:
			{
				System.out.println("Enter the file name to create...");
				String fileName = sc.nextLine();
				String[] strArray = base.createArrayOfLines();
				
				//writer.write("Programmatically created file.");
				//writer.write("These words were written programmatically.");
				//writer.write("All is Well. Be happy & enjoy the moment.");
				
				obj.createTextFile(fileName, strArray);
				break;
			}
		case 2:
		{
			Properties prop = obj.getProperties();
			base.setProperties(prop);
			System.out.println("Enter the File name to create text file...");
			String fileName = sc.nextLine();
			obj.storePropertiesInTextFile(prop, fileName);			
			break;
			
		}
		case 3:
		{
			Properties prop = obj.getProperties();
			System.out.println("Enter the File name to load back...");
			String fileName = sc.nextLine();
			obj.restoreProperties(prop, fileName);
//			System.out.println(prop);			implicitly calls toString method to print...
			prop.list(System.out);
			break;
		}
		case 4:
		{
//			Case 1:
			System.out.println("Enter the path where you want to create a folder...");
			String path = sc.nextLine();
			System.out.println("Enter the name of the desired directory...");
			path += sc.nextLine();
			File file = new File(path);
			if(file.mkdir())
			{
				System.out.println("Folder is created successfully.");
			}
			else
			{
				System.out.println("Folder is not created.");
			}
			System.out.println("Enter the File name to create...");
			String fileName = path + "/" + sc.nextLine();
			String[] strArray = base.createArrayOfLines();
			obj.createTextFile(fileName, strArray);
			
//			Case 2:
			Properties prop = obj.getProperties();
			base.setProperties(prop);
			System.out.println("Enter the File name to create text file...");
			fileName = path + "/" + sc.nextLine();
			obj.storePropertiesInTextFile(prop, fileName);
			
//			Case 3:
			Properties prop1 = obj.getProperties();
			System.out.println("Enter the File name to load back...");
			fileName = path + "/" + sc.nextLine();
			obj.restoreProperties(prop1, fileName);
			prop.list(System.out);
			break;
		}
		default:
		{
			System.out.println("XXX...Invalid case value...XXX");
		}
		}
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		catch(InputMismatchException e)
		{
			System.out.println("...Invalid Data type entered...");
		}
		
		System.out.println("Enter 'Yes' to continue. \n'No' to exit.");
		decision = sc.nextLine();
	}while(decision.equalsIgnoreCase("Yes"));
		
		sc.close();
	}
}
