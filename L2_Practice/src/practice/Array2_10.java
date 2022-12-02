package practice;

import java.util.ArrayList;
import java.util.List;

public class Array2_10
{
	public static void main(String[] args)
	{
		int[] arr = {1,5,2,3,4};
		System.out.println(longestIncreasingSubSequence(arr));
	}
	
	public static int longestIncreasingSubSequence(int[] arr)
	{
		int length = arr.length;
		List<Integer> list = new ArrayList<>();
		int maxLength = Integer.MIN_VALUE;
		int i = 0;
		int k = 0;
		
		while(i < length)
		{
			int temp = arr[i];
			list.add(temp);
			k = i + 1;
			
			while(k < length)
			{
				if(temp < arr[k])
				{
					list.add(arr[k]);
					temp = arr[k];
					k++;
				}
				else
				{
					if(list.size() > maxLength)
					{
						maxLength = list.size();
					}
					list.clear();
					if(k == length-1)
					{
						i++;
					}
				}
			}
			if(list.size() > maxLength)
			{
				maxLength = list.size();
			}
			list.clear();
		}
		return 0;
	}

}
