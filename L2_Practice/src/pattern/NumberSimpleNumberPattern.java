package pattern;

public class NumberSimpleNumberPattern
{
	public static void main(String[] args)
	{
		printSimpleNumberPattern(5);
	}
	
	public static void printSimpleNumberPattern(int n)
	{
		
		for(int i = 0; i < n; i++)
		{
			for(int k = 0; k < (i+1); k++)
			{
				System.out.print(k + 1);
			}
			
			System.out.println();
		}
	}

}
