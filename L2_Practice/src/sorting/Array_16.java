package sorting;

public class Array_16
{
	public static void main(String[] args)
	{
		long[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		int n = arr.length;
		bitonicGenerator(arr, n);
	}
	
	static void bitonicGenerator(long arr[], int n)
    {
        int length = arr.length;
        int n1;
        int n2;
        if(length % 2 == 0)
        {
            n1 = length/2;
            n2 = n1;
        }
        else
        {
            n2 = length/2;
            n1 = n2+1;
        }
        long[] evenPlacedNumbers = new long[n1];
        long[] oddPlacedNumbers = new long[n2];
        int k = 0;
        
        for(int i = 0; i < length; i = i+2)
        {
            evenPlacedNumbers[k] = arr[i];
            k++;
        }
        
        k = 0;
        
        for(int i = 1; i < length; i = i+2)
        {
            oddPlacedNumbers[k] = arr[i];
            k++;
        }
        
        sort(evenPlacedNumbers, 0, n1-1);
        sort(oddPlacedNumbers, 0, n2-1);
        
        oddPlacedNumbers = reverse(oddPlacedNumbers);
        
        System.arraycopy(evenPlacedNumbers, 0, arr, 0, n1);
        System.arraycopy(oddPlacedNumbers, 0, arr, n1, n2);
        
    }
    
    private static long[] reverse(long[] arr)
    {
        int n = arr.length;
        long[] reverse = new long[n];
        int k = 0;
        
        for(int i = n-1; i >= 0; i--)
        {
            reverse[k] = arr[i];
            k++;
        }
        
        return reverse;
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
