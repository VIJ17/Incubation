package practice;

import java.util.ArrayList;
import java.util.List;

public class Array2_5
{
	public static void main(String[] args)
	{
		char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		char[] arr2 ={ 'a', 'b', 'd', 'e', 'e', 'g', 'g', 'i', 'i'};
		mismatchedElements(arr1, arr2);
	}
	
	public static void mismatchedElements(char[] arr1, char[] arr2)
	{
		int length1 = arr1.length;
		int length2 = arr2.length;
		List<String> list = new ArrayList<>();
		
		if(length1 != length2)
		{
			System.out.println("Given 2 arrays have different length.");
		}
		
		for(int i = 0; i < length1; i++)
		{
			if(arr1[i] != arr2[i])
			{
				list.add("" + arr1[i] + arr2[i]);
			}
		}
		
		System.out.println(list);
	}

}
