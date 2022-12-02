package pattern;

public class StarRightTrianglePattern
{
	public static void main(String[] args)
	{
		printRightTrianglePattern(5);
	}
	
	public static void printRightTrianglePattern(int n)
	{
		int star = 1;
		
		for(int i = 0; i < n; i++)
		{
			for(int k = 0; k < star; k++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
			star++;
		}
	}

}
