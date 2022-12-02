package pattern;

public class NumberPascalTrianglePattern
{
	public static void main(String[] args)
	{
		printPascalTrianglePattern(5);
	}
	
	public static void printPascalTrianglePattern(int n)
	{
		int space = n - 1;
		
		for(int i = 1; i <= n; i++)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			int num = 1;
			
			for(int k = 1; k < (i+1); k++)
			{
				System.out.print(num + " ");
				num = num * (i - k) / k;
			}
			
			System.out.println();
			space--;
		}
	}

}
