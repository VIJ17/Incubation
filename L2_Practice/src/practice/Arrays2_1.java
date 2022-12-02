package practice;

import java.util.Arrays;

public class Arrays2_1
{
	public static void main(String[] args)
	{
		int[] A = {7, 3, 2, 4, 9, 12, 56};
		int m = 3;
		System.out.println(minimumDifference(A, m));
	}
	
	public static int minimumDifference(int[] A, int m)
	{
		int length = A.length;
		Arrays.sort(A);
		int minValue = A[m-1] - A[0];
		
		for(int i = 1; i < (length-m+1); i++)
		{
			int currentMinimum = A[m-1+i] - A[i];
			
			if(currentMinimum < minValue)
			{
				minValue = currentMinimum;
			}
		}
		
		return minValue;
	}

}
