package practice;

import java.util.Arrays;

public class Array2_14
{
	public static void main(String[] args)
	{
		int[] arr = {15, 5, 20, 10, 35, 15, 10};
		System.out.println(findWhetherCanBePartitioned(arr));
	}
	
	public static boolean findWhetherCanBePartitioned(int[] arr)
	{
		int length = arr.length;
		Arrays.sort(arr);
		int i = 0;
		int j = length-1;
		int subArray1Sum = 0;
		int subArray2Sum = 0;
		
		while(i < j)
		{
			subArray1Sum += arr[i];
			subArray2Sum += arr[j];
			
			if(subArray1Sum > subArray2Sum)
			{
				
			}
		}
		
		return true;
	}
}
