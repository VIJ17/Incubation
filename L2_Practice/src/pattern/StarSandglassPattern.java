package pattern;

public class StarSandglassPattern
{
	public static void main(String[] args)
	{
		printSandglassPattern(10);
	}
	
	public static void printSandglassPattern(int n)
	{
		int half = n / 2;
		int star = half;
		int space = 0;
		
		for(int i = 0; i < half; i++)
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
			star--;
			space++;
		}
		
		star++;
		space--;
		
		for(int i = 0; i < half; i++)
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
			star++;
			space--;
		}
	}

}
