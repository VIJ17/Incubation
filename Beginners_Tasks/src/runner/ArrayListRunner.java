package runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import beginnersTask.ArrayLists;
import exceptions.WrongEntryException;

public class ArrayListRunner
{
	public static Scanner sc = new Scanner(System.in);

	public List<String> getArrayStringElements()
	{
		List<String> arrayList = new ArrayList<String>();
		System.out.println("Enter the number of Elements...");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Strings one by one...");
		for(int i = 0; i<n; i++)
		{
			String str = sc.nextLine();
			arrayList.add(str);
		}
		return arrayList;
	}
	public List<Object> getArrayObjects()
	{
		List<Object> arrayList = new ArrayList<Object>();
		System.out.println("Enter the number of Elements...");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i<n; i++)
		{
			arrayList.add(new StringRunner());
		}
		return arrayList;
	}
	public List<Integer> getArrayIntegerElements()
	{
		List<Integer> arrayList = new ArrayList<Integer>();
		System.out.println("Enter the number of Elements...");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Integers one by one...");
		for(int i = 0; i<n; i++)
		{
			int value = sc.nextInt();
			arrayList.add(value);
		}
		return arrayList;
	}
	public List<Double> getArrayDecimalElements()
	{
		List<Double> arrayList = new ArrayList<Double>();
		System.out.println("Enter the number of Elements...");
		double n = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the Decimal values one by one...");
		for(int i = 0; i<n; i++)
		{
			double value = sc.nextDouble();
			arrayList.add(value);
		}
		return arrayList;
	}
	public List<Long> getArrayLongElements()
	{
		List<Long> arrayList = new ArrayList<Long>();
		System.out.println("Enter the number of Elements...");
		long n = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the Long values one by one...");
		for(int i = 0; i<n; i++)
		{
			long value = sc.nextLong();
			arrayList.add(value);
		}
		return arrayList;
	}
	public <T> void forLoopToPrint(List<T> arrayList)
	{
		System.out.println("The ArrayList is :");
		for(T element : arrayList)
		{
			System.out.println(element);
		}
	}
	public void iteratorToPrint(List<String> arrayList)
	{
		Iterator<String> iter = arrayList.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	public int getIndex()
	{
		int index = sc.nextInt();
		sc.nextLine();										//To overcome the scanner bug...
		return index;
	}
	public String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	public static void main(String[] args)
	{
		ArrayListRunner tester = new ArrayListRunner();
		ArrayLists list = new ArrayLists(); 
		System.out.println("Enter a case number to execute...");
		int caseValue = sc.nextInt();
		sc.nextLine();
		try
		{
		switch(caseValue)
		{
		case 1:
		{
			List<String> arrayList = list.getArrayList("String");
			int length = list.arrayLength(arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 2:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 3:
		{
			List<Integer> arrayList = list.getArrayList(1);
			arrayList = tester.getArrayIntegerElements();
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 4:
		{
			List<Object> arrayList = list.getArrayList(tester);
			arrayList = tester.getArrayObjects();
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 5:
		{
			List<Object> arrayList = list.getArrayList(tester);
			arrayList.addAll(tester.getArrayIntegerElements());
			arrayList.addAll(tester.getArrayStringElements());
			arrayList.addAll(tester.getArrayObjects());
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 6:
		{

			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			System.out.println("Enter the string to find it's index");
			String str = tester.getString();
			int index = list.findIndexOf(arrayList, str);
			System.out.println("Index of '"+str+"' is : "+(index+1));
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 7:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			System.out.println("Using for loop to print the ArrayList");
			tester.forLoopToPrint(arrayList);
			System.out.println("Using iterator to print the ArrayList");
			tester.iteratorToPrint(arrayList);
			break;
		}
		case 8:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			System.out.println("Enter the index to find");
			int index = tester.getIndex();
			String str = list.findElement(arrayList, index-1);
			System.out.println("The Element at the given index is : "+str);
			int length = list.arrayLength(arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 9:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			System.out.println("Enter the duplicate string to find the index");
			String str = tester.getString();
			int firstIndex = list.findIndexOf(arrayList, str);
			System.out.println("The First index of the duplicate string is : "+(firstIndex+1));
			int lastIndex = list.greatestPosition(arrayList, str);
			System.out.println("The last index of the duplicate string is : "+(lastIndex+1));
			break;
		}
		case 10:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			System.out.println("Enter the string to add");
			String str = tester.getString();
			System.out.println("Enter the position to add the string");
			int index = tester.getIndex();
			list.addElement(arrayList, str, index-1);
			System.out.println("ArrayList after adding the string : "+arrayList);
			int length = list.arrayLength(arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 11:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			List<String> arrayList1 = list.getArrayList("Strings");
			System.out.println("Enter the start index to copy from the arraylist");
			int startIndex = tester.getIndex();
			System.out.println("Enter the end index to copy from the arraylist");
			int endIndex = tester.getIndex();
			arrayList1 = list.CreateSubArray(arrayList, startIndex-1, endIndex);
			System.out.println("Second arraylist is : "+arrayList1);
			break;
		}
		case 12:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			List<String> arrayList1 = list.getArrayList("String");
			arrayList1 = tester.getArrayStringElements();
			List<String> arrayList2 = list.getArrayList("String");
			arrayList2 = list.combineArrayLists(arrayList, arrayList1);
			System.out.println("Third ArrayList after adding the two ArrayLists : "+arrayList2);
			int length = list.arrayLength(arrayList2);
			System.out.println("Length of third ArrayList is : "+length);
			break;
		}
		case 13:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			List<String> arrayList1 = list.getArrayList("String");
			arrayList1 = tester.getArrayStringElements();
			List<String> arrayList2 = list.getArrayList("String");
			arrayList2 = list.combineArrayListsInReverse(arrayList, arrayList1);
			System.out.println("Third ArrayList after adding the two ArrayLists : "+arrayList2);
			int length = list.arrayLength(arrayList2);
			System.out.println("Length of third ArrayList is : "+length);
			break;
		}
		case 14:
		{
			List<Double> arrayList = list.getArrayList(1.2);
			arrayList = tester.getArrayDecimalElements();
			System.out.println("Enter the Decimal value to remove from the list");
			double value = sc.nextDouble();
			list.removeElement(arrayList, value);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 15:
		{
			List<Double> arrayList = list.getArrayList(1.2);
			arrayList = tester.getArrayDecimalElements();
			System.out.println("Enter the index to remove from the list");
			int index = tester.getIndex();
			list.removeElementAtIndex(arrayList, index-1);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 16:
		{
			List<Long> arrayList = list.getArrayList(1L);
			arrayList = tester.getArrayLongElements();
			System.out.println("Enter the start index to remove from the arraylist");
			int startIndex = tester.getIndex();
			System.out.println("Enter the end index to remove from the arraylist");
			int endIndex = tester.getIndex();
			list.removeRangeOfElements(arrayList, startIndex-1, endIndex);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 17:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			List<String> arrayList1 = list.getArrayList("Strings");
			System.out.println("Create a subList you want to remove from the list..");
			arrayList1 = tester.getArrayStringElements();
			list.removeList(arrayList, arrayList1);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 18:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			List<String> arrayList1 = list.getArrayList("Strings");
			System.out.println("Create a subList you want to retain from the list..");
			arrayList1 = tester.getArrayStringElements();
			list.retainList(arrayList, arrayList1);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 19:
		{
			List<Long> arrayList = list.getArrayList(1L);
			arrayList = tester.getArrayLongElements();
			list.removeAll(arrayList);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		case 20:
		{
			List<String> arrayList = list.getArrayList("String");
			arrayList = tester.getArrayStringElements();
			System.out.println("Enter a string to check the list...");
			String str = tester.getString();
			boolean result = list.checkTheList(arrayList, str);
			System.out.println(result);
			int length = list.arrayLength(arrayList);
			System.out.println("The ArrayList is : "+arrayList);
			System.out.println("Length of the ArrayList is : "+length);
			break;
		}
		default:
		{
			System.out.println("XXX...Invalid case number...XXX");
		}
		
		}
		}
		catch(WrongEntryException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(InputMismatchException e)
		{
			System.out.println("...Invalid Data type entered...");
		}
	}
}
