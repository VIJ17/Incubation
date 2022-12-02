package practice;

public class Array_20
{
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int sum = 15;
		int[] positions = contiguousSubArraySum(nums, sum);
		for(int i = 0; i < positions.length; i++)
		{
			System.out.println(positions[i]);
		}
	}
	
	public static int[] contiguousSubArraySum(int[] nums, int sum)
	{
		int length = nums.length;
		int[] positions = new int[2];
		
		for (int i = 0; i < length; i++)
        {
            int currentSum = nums[i];
 
            if (currentSum == sum)
            {
            	positions[0] = (i+1);
            	positions[1] = (i+1);
                return positions;
            }
            else
            {
                for (int j = i + 1; j < length; j++)
                {
                    currentSum += nums[j];
 
                    if (currentSum == sum)
                    {
                    	positions[0] = (i+1);
                    	positions[1] = (j+1);
                        return positions;
                    }
                }
            }
        }
		positions[0] = (-1);
        
        return positions;
	}

}