package practice;

public class Array2_19
{
	public static void main(String[] args)
	{
		int[] arr = {901, 40, 35, 0, 60, 900, 903, 1000};
		int[] pair = findMinimumDifferencePair(arr);
		
		System.out.println("(" + pair[0] + ", " + pair[1] + ")");
	}
	
	public static int[] findMinimumDifferencePair(int[] arr)
	{
		int length = arr.length;
		int[] pair = new int[2];
		int minDiff = Integer.MAX_VALUE;
		
		for(int i = 0; i < length; i++)
		{
			int temp = arr[i];
			
			for(int k = i+1; k < length; k++)
			{
				int currentDiff = temp - arr[k];
				
				if(currentDiff < 0)
				{
					currentDiff *= -1;
				}
				if(currentDiff < minDiff)
				{
					minDiff = currentDiff;
					pair[0] = temp;
					pair[1] = arr[k];
				}
			}
		}
		
		return pair;
	}

}
