package beginnersTask;

import java.util.ArrayList;
import java.util.List;

import exceptions.WrongEntryException;

public class ArrayLists
{
	public <T> void nullCheck(List<T> arrayList) throws WrongEntryException
	  {
	    if(arrayList == null)
	    {
	      throw new WrongEntryException("ArrayList is null.");
	    }
	  }
	public <T> List<T> getArrayList(T type)
	{
		List<T> arrayList = new ArrayList<T>();
		return arrayList;
	}
	public <T> int arrayLength(List<T> arrayList) throws WrongEntryException
	{
		nullCheck(arrayList);
		int length = arrayList.size();
		return length;
	}
	public int findIndexOf(List<String> arrayList, String str) throws WrongEntryException
	{
		nullCheck(arrayList);
		int index = arrayList.indexOf(str);
		if(index == -1)
		{
			throw new WrongEntryException("String not exists in the array...");
		}
		return index;
	}
	public String findElement(List<String> arrayList, int index) throws WrongEntryException
	{
		if(index >= arrayList.size())
		{
			throw new WrongEntryException("Entered index is greater than the size of the ArrayList.");
		}
		nullCheck(arrayList);
		return arrayList.get(index);
	}
	public int greatestPosition(List<String> arrayList, String str) throws WrongEntryException
	{
		nullCheck(arrayList);
		int lastIndex = arrayList.lastIndexOf(str);
		if(lastIndex == -1)
		{
			throw new WrongEntryException("String not exists in the array...");
		}
		return lastIndex;
	}
	public void addElement(List<String> arrayList, String str, int index) throws WrongEntryException
	{
		nullCheck(arrayList);
		arrayList.add(index, str);
	}
	public List<String> CreateSubArray(List<String> arrayList, int startIndex, int endIndex) throws WrongEntryException
	{
		nullCheck(arrayList);
		return arrayList.subList(startIndex, endIndex);
	}
	public List<String> combineArrayLists(List<String> arrayList, List<String> arrayList1) throws WrongEntryException
	{
		nullCheck(arrayList);
		arrayList.addAll(arrayList1);
		return arrayList;
	}
	public List<String> combineArrayListsInReverse(List<String> arrayList, List<String> arrayList1) throws WrongEntryException
	{
		nullCheck(arrayList);
		arrayList.addAll(0,arrayList1);
		return arrayList;
	}
	public void removeElement(List<Double> arrayList, double value) throws WrongEntryException
	{
		if(arrayList.indexOf(value) == -1)
		{
			throw new WrongEntryException("Entered value is not exists in the list");
		}
		nullCheck(arrayList);
		arrayList.remove(value);
	}
	public void removeElementAtIndex(List<Double> arrayList, int index) throws WrongEntryException
	{
		if(index >= arrayList.size())
		{
			throw new WrongEntryException("Entered index is greater than the size of the ArrayList");
		}
		nullCheck(arrayList);
		arrayList.remove(index);
	}
	public <T> void removeRangeOfElements(List<T> arrayList, int startIndex, int endIndex) throws WrongEntryException
	{
		//int length = arrayLength(arrayList);						Another method to do this...
		//List<T> arrayList1 = arrayList.subList(0, startIndex);	But little clumsy...
		//List<T> arrayList2 = arrayList.subList(endIndex, length);
		//arrayList1.addAll(arrayList2);
		arrayList.subList(startIndex, endIndex).clear();
	}
	public void removeList(List<String> arrayList, List<String> arrayList1) throws WrongEntryException
	{
		nullCheck(arrayList);
		arrayList.removeAll(arrayList1);
	}
	public void retainList(List<String> arrayList, List<String> arrayList1) throws WrongEntryException
	{
		nullCheck(arrayList);
		arrayList.retainAll(arrayList1);
	}
	public <T> void removeAll(List<T> arrayList) throws WrongEntryException
	{
		nullCheck(arrayList);
		arrayList.clear();
	}
	public boolean checkTheList(List<String> arrayList, String str) throws WrongEntryException
	{
		nullCheck(arrayList);
		return arrayList.contains(str);
	}
}
