package practice;

import java.util.Arrays;

public class NthLargestNumber
{
	public static void main(String[] args)
	{
		int[] arr = {7, 10, 4, 3, 20, 15};
		int n = 2;
		int k = 3;
		System.out.println(nthSmallest(arr, k, n));
	}
	
	public static int nthSmallest(int[] arr, int k, int n)
	{
		Arrays.sort(arr);
        
		int length = arr.length;
        int kthElement = arr[k-1];
        int nthElement = arr[length-n];
        
        return (kthElement + nthElement);
	}

}
