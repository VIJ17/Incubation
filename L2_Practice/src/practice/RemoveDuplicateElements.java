package practice;

public class RemoveDuplicateElements
{
	public static void main(String[] args)
	{
		int[] A = {1, 3, 4, 5, 6, 12, 13, 17, 19, 22, 23, 25, 27, 28, 28, 35, 36, 37, 39, 43, 46, 48, 54, 59, 62, 63, 65, 68, 68, 70, 70, 72, 79, 82, 83, 92, 92, 93, 95, 96, 96, 100};
		int N = 42;
		int x = removeDuplicate(A, N);
		for(int i = 0; i < x; i++)
		{
			System.out.print(A[i] + " ");
		}
	}
	
	public static int removeDuplicate(int A[],int N)
    {
        int length = A.length;
        
        for(int i = 0; i < length; i++)
        {
            int temp1 = A[i];
            
            while((i+1) < length && temp1 == A[i+1])
            {
                A[i+1] = 0;
                i++;
            }
        }
        
        int index = 1;
        
        for(int i = 1; i < length; i++)
        {
            if(A[i] != 0)
            {
                if(index != i)
                {
	            	A[index] = A[i];
	                A[i] = 0;
                }
                index++;
            }
        }
        
        return index;
    }
}
