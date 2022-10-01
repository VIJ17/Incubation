package runner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class PojoReflectionRunner
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[])
	{
		try {
			System.out.println("Enter a String...");
			String str = sc.nextLine();
			System.out.println("Enter a integer value...");
			int intValue = sc.nextInt();
			
			Class<?> cls = Class.forName("beginnersTask.PojoReflection");
			
			Constructor<?> defaultConst = cls.getConstructor();
			Object defaultObj = defaultConst.newInstance();			//invoking default constructor...
			
			Constructor<?> overLoadedConst = cls.getConstructor(String.class, int.class);
			Object overLoadedObj = overLoadedConst.newInstance(str, intValue);	//invoking Overloaded constructor...
			
			Method method = cls.getDeclaredMethod("setString", String.class);
			method.setAccessible(true);					//If the specified method is private, make it accessible by this code...
			method.invoke(defaultObj, str);				//invoking setString method...
			
			Method method1 = cls.getDeclaredMethod("getString");
			method1.setAccessible(true);				//If the specified method is private, make it accessible by this code...
			System.out.println("Getting the String Value using Reflection : " + method1.invoke(overLoadedObj));		//invoking getString method...
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
}
