package sorting;

public class MergeSorting
{
	public static void main(String[] args)
	{
		int[] arr = {9,8,7,6,5,2,4,1,3};
		sort(arr, 0, arr.length-1);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] arr, int left, int right)
	{
		if(left < right)
		{
			int middle = left + (right - left)/2;
			
			sort(arr, left, middle);
			sort(arr, middle+1, right);
			
			merge(arr, left, middle, right);
		}
	}
	
	private static void merge(int[] arr, int left, int middle, int right)
	{
		int n1 = middle - left + 1;
		int n2 = right - middle;
		
		int[] subArray1 = new int[n1];
		int[] subArray2 = new int[n2];
		
		for(int i = 0; i < n1; i++)
		{
			subArray1[i] = arr[left + i];
		}
		
		for(int i = 0; i < n2; i++)
		{
			subArray2[i] = arr[middle + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		int k = left;
		
		while(i < n1 && j < n2)
		{
			if(subArray1[i] <= subArray2[j])
			{
				arr[k] = subArray1[i];
				i++;
			}
			else
			{
				arr[k] = subArray2[j];
				j++;
			}
			
			k++;
		}
		
		while(i < n1)
		{
			arr[k] = subArray1[i];
			i++;
			k++;
		}
		
		while(j < n2)
		{
			arr[k] = subArray2[j];
			j++;
			k++;
		}
	}

}
