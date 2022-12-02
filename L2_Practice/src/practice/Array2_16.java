package practice;

public class Array2_16
{
	public static void main(String[] args)
	{
		int n = 28;
		System.out.println(findPerfectNumber(n));
	}
	
	public static int findPerfectNumber(int n)
	{
		StringBuilder strBuil = new StringBuilder();
		strBuil.append(n);
		int temp = 0;
		
		for(int i = 0; i < strBuil.length(); i++)
		{
			temp += Integer.parseInt(String.valueOf(strBuil.charAt(i)));
		}
		
		int digit = 10 - temp;
		if(digit != 0)
		{
			strBuil.append(digit);
		}
		
		int perfectNumber = Integer.parseInt(strBuil.toString());
		
		return perfectNumber;
	}

}
