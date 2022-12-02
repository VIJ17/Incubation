package practice;

public class Array2_18
{
	public static void main(String[] args)
	{
		int[] arr = {17, 85, 23, 60};
//		arr = sortBasedOnSumOfDigits(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	private static int findProductOfDigits(int number)
	{
		int product = 1;
		
		while(number != 0)
		{
			int lastDigit = number % 10;
			product *= lastDigit;
			number /= 10;
		}
		
		return product;
	}
	
//	public static int[] sortBasedOnSumOfDigits(int[] arr)
//	{
//		int length = arr.length;
//		
//		for(int i = 0; i < length; i++)
//		{
//			int number = arr[i];
//			int product = findProductOfDigits(number);
//			
//			for(int j = i+1; j < length; j++)
//			{
//				
//			}
//			
//		}
//		
//	}

}
