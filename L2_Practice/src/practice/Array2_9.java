package practice;

import java.util.Arrays;

public class Array2_9
{
	public static void main(String[] args)
	{
		int[] arr = {2 ,3, 6,2,2,1,6};
		countNoOfDuplicates(arr);
	}
	
	public static void countNoOfDuplicates(int[] arr)
	{
		Arrays.sort(arr);
		int count = 1;
		
		for(int i = 0; i < arr.length; i++)
		{
			if((i+1) < arr.length && arr[i] == arr[i+1])
			{
				count++;
			}
			else
			{
				System.out.println(arr[i] + " - " + count);
				count = 1;
			}
		}
	}

}
