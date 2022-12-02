package sorting;

public class Sorting_7
{
	public static void main(String[] args)
	{
		long[] arr1 = {1, 3, 5, 7};
		long[] arr2 = {0, 2, 6, 8, 9};
		int n = arr1.length;
		int m = arr2.length;
		
		merge(arr1, arr2, n, m);
	}
	
	public static void merge(long arr1[], long arr2[], int n, int m) 
	{
		for(int i = 0; i < n; i++)
		{
			if(arr2[0] <= arr1[i])
			{
				long temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
				
				if(m == 1)
				{
					continue;
				}
				
				for(int k = 1; k < m; k++)
				{
					if(arr2[k] < temp)
					{
						long temp1 = arr2[k];
						arr2[k] = arr2[k-1];
						arr2[k-1] = temp1;
					}
				}
			}
		}
		
	}

}
