package pattern;

public class StarPyramidPattern
{
	public static void main(String[] args)
	{
		printPyramidPattern(5);
	}
	
	public static void printPyramidPattern(int n)
	{
		int space = n-1;
		int star = 1;
		
		for(int i = 0; i < n; i++)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			for(int k = 0; k < star; k++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
			space--;
			star++;
		}
	}

}
