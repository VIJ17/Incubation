package practice;

import java.util.ArrayList;
import java.util.List;

public class Array_19
{
	public static void main(String[] args)
	{
		int[] nums = {-1, 3, -7, 8, 2, 3, 4, 0, 12};
		
		int[] localMinima = localMinima(nums);
		for(int i = 0; i < localMinima.length; i++)
		{
			System.out.println(localMinima[i]);
		}
	}
	
	public static int[] localMinima(int[] nums)
	{
		int length = nums.length;
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < length; i++)
		{
			if(i == 0)
			{
				if(nums[i] <= nums[i+1])
				{
					list.add(nums[i]);
				}
			}
			else if(i == length-1 && nums[i] <= nums[i-1])
			{
				list.add(nums[i]);
			}
			else if(nums[i] <= nums[i-1] && nums[i] <= nums[i+1])
			{
				list.add(nums[i]);
			}
		}
		
		int[] localMinima =new int[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{
			localMinima[i] = list.get(i);
		}
		
		return localMinima;
	}

}
