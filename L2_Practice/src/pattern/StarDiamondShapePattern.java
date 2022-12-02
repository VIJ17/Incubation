package pattern;

public class StarDiamondShapePattern
{
	public static void main(String[] args)
	{
		printDiamondShapePattern(10);
	}
	
	public static void printDiamondShapePattern(int n)
	{
//		if(n % 2 == 0)
//		{
//			n--;
//		}
		
		int bottom = n/2;
		int top = bottom + 1;
		int space = top - 1;
		int star = 1;
		
		for(int i = 0; i < top; i++)
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
		
		space += 2;
		star -= 2;
		
		for(int i = 0; i < bottom; i++)
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
			space++;
			star--;
		}
	}
}
