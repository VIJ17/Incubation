package practice;

public class Array_17
{
	public static void main(String[] args)
	{
		int[] nums = {4,1,2,1,2};
		System.out.println(findSingleElement(nums));
	}
	
	public static int findSingleElement(int[] nums)
	{
		int length = nums.length;
		
		for(int i = 0; i < length; i++)
		{
			int count = 0;
			
			for(int j = 0; j < length; j++)
			{
				if(nums[i] == nums[j])
				{
					count++;
				}
			}
			
			if(count == 1)
			{
				return nums[i];
			}
		}
		return -1;
	}

}