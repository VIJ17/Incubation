package practice;

public class Array2_3
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};
		int x = 10;
		int[] pair = findClosestSumPair(arr, x);
		
		for(int i = 0; i < pair.length; i++)
		{
			System.out.println(pair[i]);
		}
	}
	
	public static int[] findClosestSumPair(int[] arr, int x)
	{
		int length = arr.length;
		int[] pair = new int[2];
		int minDiff = Integer.MAX_VALUE;
		int i = 0;
		int j = length-1;
		
		while(i < j)
		{
			int currentSum = arr[i] + arr[j];
			if(currentSum < x)
			{
				if((x - currentSum) < minDiff)
				{
					minDiff = x - currentSum;
					pair[0] = arr[i];
					pair[1] = arr[j];
				}
				i++;
			}
			else if(currentSum > x)
			{
				if((currentSum - x) < minDiff)
				{
					minDiff = currentSum - x;
					pair[0] = arr[i];
					pair[1] = arr[j];
				}
				j--;
			}
			else
			{
				pair[0] = arr[i];
				pair[1] = arr[j];
			}
		}
		
		return pair;
	}

}
