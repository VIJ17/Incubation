package practice;

import java.util.Arrays;

public class Array2_15
{
	public static void main(String[] args)
	{
		int[] arr = {-10, -10, 5, 2};
		System.out.println(getLargestProduct(arr));
	}
	
	public static int getLargestProduct(int[] arr)
	{
		int length = arr.length;
		Arrays.sort(arr);
		int product1 = arr[0] * arr[1] * arr[length-1];
		int product2 = arr[length-1] * arr[length-2] * arr[length-3];
		
		if(product1 > product2)
		{
			return product1;
		}
		else
		{
			return product2;
		}
	}

}
