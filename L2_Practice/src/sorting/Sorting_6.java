package sorting;

public class Sorting_6 {

	public static void main(String[] args)
	{
		int[] arr = {2, 8, 5, 4};
		System.out.println(minSwaps(arr));
	}
	
	public static int minSwaps(int nums[])
    {
        int n = nums.length;
		int count = 0;
		
		for(int i = 0; i < (n-1); i++)
		{
			int minimumIndex = i;
			
			for(int k = i+1; k < n; k++)
			{
				if(nums[k] < nums[minimumIndex])
				{
					minimumIndex = k;
				}
			}
			
			if(minimumIndex > i)
			{
			    count++;
			}
			
			int temp = nums[minimumIndex];
			nums[minimumIndex] = nums[i];
			nums[i] = temp;
		}
		
		return count;
    }

}
