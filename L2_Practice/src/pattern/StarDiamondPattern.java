package pattern;

public class StarDiamondPattern
{
	public static void main(String[] args)
	{
		printDiamondPattern(7);
	}
	
	public static void printDiamondPattern(int n)
	{
//		if(n % 2 == 0)
//		{
//			n--;
//		}
		
		int bottom = n / 2;
		int top = bottom + 1;
		int space = top - 1;
		int middleSpace = -1;
		
		for(int i = 0; i < top; i++)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			System.out.print("*");
			
			if(i > 0)
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
		
		space += 2;
		middleSpace -= 4;
		
		for(int i = 0; i < bottom; i++)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			System.out.print("*");
			
			if(i != bottom-1)
			{
				for(int k = 0; k < middleSpace; k++)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
			}
			
			System.out.println();
			space++;
			middleSpace -= 2;
		}
	}

}
