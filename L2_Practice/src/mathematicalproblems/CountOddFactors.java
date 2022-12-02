package mathematicalproblems;

public class CountOddFactors
{
	public static void main(String[] args)
	{
		System.out.println(count(5));
	}
	
	public static long count(int N)        
    {
        if(N == 1 || N == 0)
        {
            return N;
        }
        
        int oddNoOfFactorsCount = 0;
        
        for(int i = 1; i <= N; i++)
        {
            int count = 0;
            
            for(int k = 1; k <= i; k++)
            {
                if(i % k == 0)
                {
                    count++;
                }
            }
            
            if(count % 2 != 0)
            {
                oddNoOfFactorsCount++;
            }
        }
        
        return oddNoOfFactorsCount;
    }

}
