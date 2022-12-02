package practice;

public class Array2_12
{
	public static void main(String[] args)
	{
		int[] arr = {3, 4, 2, 5};
		System.out.println(nonDecreasingCheck(arr));
	}
	
	public static boolean nonDecreasingCheck(int[] arr)
	{
		int length = arr.length;
		int count = 0;
		
		for(int i = 0; i < length-1; i++)
		{
			if(arr[i] >= arr[i+1])
			{
				count++;
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
			if(count > 1)
			{
				return false;
			}
		}
		
		return true;
	}

}
