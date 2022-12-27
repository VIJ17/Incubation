package sorting;

public class BubbleSorting
{
	public static void main(String[] args)
	{
		int[] arr = {9,8,7,6,5,2,4,1,3};
		sort(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] arr)
	{
		int n = arr.length;
		
		for(int i = 0; i < (n-1); i++)
		{
			for(int k = 0; k < (n-1-i); k++)
			{
				if(arr[k] > arr[k+1])
				{
					int temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
				}
			}
		}
	}

}
