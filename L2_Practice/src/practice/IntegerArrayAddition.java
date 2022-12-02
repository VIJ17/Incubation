package practice;

import java.util.ArrayList;
import java.util.List;

public class IntegerArrayAddition
{
	public static void main(String[] args)
	{
		int[] arr = {9};
		
		arr = addOneToArrayOfDigits(arr);
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static int[] addOneToArrayOfDigits(int[] arr)
	{
		int length = arr.length;
		StringBuilder strBuil = new StringBuilder();
		
		for(int i = 0; i < length; i++)
		{
			strBuil.append(arr[i]);
		}
		
		int number = Integer.parseInt(strBuil.toString());
		number++;
		strBuil.setLength(0);
		strBuil.append(number);
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < strBuil.length(); i++)
		{
			list.add(Integer.parseInt(String.valueOf(strBuil.charAt(i))));
		}
		
		int[] arr1 = new int[list.size()];
		
		for(int i = 0; i < arr1.length; i++)
		{
			arr1[i] = list.get(i);
		}
		
		return arr1;
	}

}
