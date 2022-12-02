package pattern;

public class NumberDiamondPattern
{
	public static void main(String[] args)
	{
		printDiamondPattern(7);
	}
	
	public static void printDiamondPattern(int n)
	{
		int bottom = n / 2;
		int top = bottom + 1;
		int space = top - 1;
		
		for(int i = 1; i <= top; i++)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			for(int k = i; k >= 1; k--)
			{
				System.out.print(k);
			}
			
			for(int k = 2; k <= i; k++)
			{
				System.out.print(k);
			}
			
			System.out.println();
			space--;
		}
		
		space += 2;
		
		for(int i = bottom; i >= 0; i--)
		{
			for(int k = 0; k < space; k++)
			{
				System.out.print(" ");
			}
			
			for(int k = i; k >= 1; k--)
			{
				System.out.print(k);
			}
			
			for(int k = 2; k <=i; k++)
			{
				System.out.print(k);
			}
			
			System.out.println();
			space++;
		}
	}

}
