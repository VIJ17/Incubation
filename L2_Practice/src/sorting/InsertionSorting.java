package sorting;

public class InsertionSorting
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
		
		for(int i = 1; i < n; i++)
		{
			int key = arr[i];
			int j = i-1;
			
			while(j >= 0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
	}

}
