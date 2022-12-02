package sorting;

import java.util.Arrays;

public class Sorting_11
{
	public static void main(String[] args)
	{
		long[] A = {1, 2, 5, 4, 0};
		long[] B = {2, 4, 5, 0, 1};
		int N = 5;
		System.out.println(check(A, B, N));
	}
	
	public static boolean check(long A[],long B[],int N)
    {
        sort(A, 0, N-1);
        sort(B, 0, N-1);
        
        if(Arrays.equals(A, B))
        {
            return true;
        }
        
        return false;
    }
    
    public static void sort(long[] arr, int left, int right)
    {
        if(left < right)
        {
            int middle = left + (right - left)/2;
            
            sort(arr, left, middle);
            sort(arr, middle+1, right);
            
            merge(arr, left, middle, right);
        }
    }
    
    private static void merge(long[] arr, int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        long[] subArray1 = new long[n1];
        long[] subArray2 = new long[n2];
        
        for(int i = 0; i < n1; i++)
        {
            subArray1[i] = arr[left + i];
        }
        
        for(int i = 0; i < n2; i++)
        {
            subArray2[i] = arr[middle + 1 + i];
        }
        
        int i = 0, j = 0;
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
