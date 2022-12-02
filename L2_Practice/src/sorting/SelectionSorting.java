package sorting;

public class SelectionSorting
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
			int minimumIndex = i;
			
			for(int k = i+1; k < n; k++)
			{
				if(arr[k] < arr[minimumIndex])
				{
					minimumIndex = k;
				}
			}
			
			int temp = arr[minimumIndex];
			arr[minimumIndex] = arr[i];
			arr[i] = temp;
		}
	}

}
