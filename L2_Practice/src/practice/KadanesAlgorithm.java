package practice;

public class KadanesAlgorithm
{
	public static void main(String[] args)
	{
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int n = 9;
		System.out.println(maxSubarraySum(arr, n));
	}
	
	public static long maxSubarraySum(int arr[], int n)
    {
        int maxSum = arr[0];
        
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            
            for(int j = i; j < n; j++)
            {
                sum += arr[j];
                
                if(sum > maxSum)
                {
                    maxSum = sum;
                }
            }
        }
        
        return maxSum;
    }

}
