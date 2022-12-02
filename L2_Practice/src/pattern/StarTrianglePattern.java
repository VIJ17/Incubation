package pattern;

public class StarTrianglePattern
{
	public static void main(String[] args)
	{
		printTrianglePattern(5);
	}
	
	public static void printTrianglePattern(int n)
	{
		int space = n-1;
		int middleSpace = -1;
		
		for(int i = 0; i < n; i++)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			System.out.print("*");
			if(i == n-1)
			{
				int temp = (n*2) - 1;
				
				for(int k = 1; k < temp; k++)
				{
					System.out.print("*");
				}
			}
			else if(i > 0)
			{
				for(int k = 0; k < middleSpace; k++)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
			}
			
			System.out.println();
			space--;
			middleSpace += 2;
		}
	}

}
