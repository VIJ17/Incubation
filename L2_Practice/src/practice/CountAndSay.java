package practice;

import java.util.Scanner;

public class CountAndSay
{
	
	public static String countAndSay(int n)
	{
		if(n == 1)
		{
			return "1";
		}
		
		String str1 = countAndSay(n-1);
		int length = str1.length();
		int count = 1;
		String str2 = "";
		
		for(int i = 0; i < length; i++)
		{
			char temp1 = str1.charAt(i);
			
			if((i+1) < length)
			{
				char temp2 = str1.charAt(i+1);
				
				if(temp1 == temp2)
				{
					count++;
				}
				else
				{
					str2 += count + String.valueOf(temp1);
					count = 1;
				}
			}
			
			str2 += count + String.valueOf(temp1);
		}
		
		return str2;
	}

	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter a number to see nth element in count and say series...");
			int n = sc.nextInt();
			
			System.out.println(countAndSay(n));
		}
	}

}
