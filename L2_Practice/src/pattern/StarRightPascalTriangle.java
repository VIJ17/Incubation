package pattern;

public class StarRightPascalTriangle
{
	public static void main(String[] args)
	{
		printRightPascalTriangle(8);
	}
	
	public static void printRightPascalTriangle(int n)
	{
//		if(n % 2 == 0)
//		{
//			n--;
//		}
		
		int bottom = n/2;
		int top = bottom + 1;
		int star = 1;
		
		for(int i = 0; i < top; i++)
		{
			for(int k = 0; k < star; k++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
			star++;
		}
		
		star -= 2;
		
		for(int i = 0; i < bottom; i++)
		{
			for(int k = 0; k < star; k++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
			star--;
		}
	}

}
