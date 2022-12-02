package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2_6
{
	public static void main(String[] args)
	{
		int[] arr = {10, 9, 5, 9, 0, 10, 2, 10, 1, 9};
		int sum = 12;
		List<int[]> list = PairsOfArrayEqualToSum(arr, sum);
		
		for(int i = 0; i < list.size(); i++)
		{
			int[] array = list.get(i);
			
			System.out.println("[" + array[0] + ", " + array[1] + "]");
		}
	}
	
	public static List<int[]> PairsOfArrayEqualToSum(int[] arr, int sum)
	{
		int length = arr.length;
		Arrays.sort(arr);
		List<int[]> list = new ArrayList<>();
		int i = 0;
		int j = length-1;
		
		while(i < j)
		{
			int currentSum = arr[i] + arr[j];
			int[] array = new int[2];
			
			if(currentSum == sum)
			{
				array[0] = arr[i];
				array[1] = arr[j];
				list.add(array);
				
				if(arr[i] == arr[i+1])
				{
					i++;
				}
				else if(arr[j] == arr[j-1])
				{
					j--;
				}
				else
				{
					i++;
				}
			}
			if(currentSum > sum)
			{
				j--;
			}
			else if(currentSum < sum)
			{
				i++;
			}
			
		}
		
		return list;
	}

}
