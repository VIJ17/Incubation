package practice;

import java.util.Arrays;

public class Array2_4
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5};
		int n = 1;
		int[] rotateArr = rotateArrayClockwise(arr, n);
		
		for(int i = 0; i < rotateArr.length; i++)
		{
			System.out.println(rotateArr[i]);
		}
	}
	
	public static int[] rotateArrayClockwise(int[] arr, int n)
	{
		int length = arr.length;
		int[] subArray1 = Arrays.copyOfRange(arr, length-n, length);
		int[] subArray2 = Arrays.copyOfRange(arr,0,(length-n));
		int[] rotateArray = new int[length];
		
		System.arraycopy(subArray1, 0, rotateArray, 0, subArray1.length);
		System.arraycopy(subArray2, 0, rotateArray, subArray1.length, subArray2.length);
		
		return rotateArray;
	}

}
