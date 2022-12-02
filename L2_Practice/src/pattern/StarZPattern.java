package pattern;

public class StarZPattern
{
	public static void main(String[] args)
	{
		printZPattern(5);
	}
	
	public static void printZPattern(int n)
	{
		int space = n - 2;
		
		for(int i = 0; i < n; i++)
		{
			if(i == 0 || i == n-1)
			{
				System.out.println();
				
				for(int k = 0; k < n; k++)
				{
					System.out.print("*");
				}
			}
			else
			{
				System.out.println();
				
				for(int k = 0; k < space; k++)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
				space--;
			}
		}
	}

}
