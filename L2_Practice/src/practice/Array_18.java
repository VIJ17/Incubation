package practice;

import java.util.ArrayList;
import java.util.List;

public class Array_18
{
	public static void main(String[] args)
	{
		int[] nums = {18, 21, 32, 49, 17, 1, 35, 5};
		
		int[] sevenUpElements = sevenUpElement(nums);
		for(int i = 0; i < sevenUpElements.length; i++)
		{
			System.out.println(sevenUpElements[i]);
		}
		
	}
	
	public static int[] sevenUpElement(int[] nums)
	{
		int length = nums.length;
		List<Integer> list = new ArrayList<>();
		list.add(nums[0]);
		
		for(int i = 0; i < length-1; i++)
		{
			if(nums[i] % 7 == 0)
			{
				list.add(nums[i+1]);
			}
		}
		
		int[] sevenUpElements = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{
			sevenUpElements[i] = list.get(i);
		}
		
		return sevenUpElements;
	}

}
