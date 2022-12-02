package practice;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class ConvertNumberToWord_04
{
	public static void main(String[] args)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(System.in);
			System.out.println("Enter a number...");
			int n = sc.nextInt();
			System.out.println(convertToWords(n));
		}
		finally
		{
			try
			{
				sc.close();
			}
			catch(Exception e){}
		}
	}
	
	public static String convertToWords(int n)
    {
        Map<Integer,Map<Integer,String>> map = new Hashtable<>();
        Map<Integer,String> innerMap1 = new Hashtable<>();
        innerMap1.put(1, "one");
        innerMap1.put(2, "two");
        innerMap1.put(3, "three");
        innerMap1.put(4, "four");
        innerMap1.put(5, "five");
        innerMap1.put(6, "six");
        innerMap1.put(7, "seven");
        innerMap1.put(8, "eight");
        innerMap1.put(9, "nine");
        innerMap1.put(10, "ten");
        innerMap1.put(11, "eleven");
        innerMap1.put(12, "twelve");
        innerMap1.put(13, "thirteen");
        innerMap1.put(14, "fourteen");
        innerMap1.put(15, "fifteen");
        innerMap1.put(16, "sixteen");
        innerMap1.put(17, "seventeen");
        innerMap1.put(18, "eighteen");
        innerMap1.put(19, "nineteen");
        map.put(1, innerMap1);
        Map<Integer,String> innerMap2 = new Hashtable<>();
        innerMap2.put(1, "ten");
        innerMap2.put(2, "twenty");
        innerMap2.put(3, "thirty");
        innerMap2.put(4, "forty");
        innerMap2.put(5, "fifty");
        innerMap2.put(6, "sixty");
        innerMap2.put(7, "seventy");
        innerMap2.put(8, "eighty");
        innerMap2.put(9, "ninety");
        map.put(2, innerMap2);
        
        String word = "";
        String number = "" + n;
        char[] numArray = number.toCharArray();
        int length = number.length();
        int i = 0;
        
        while(0 < length)
        {
        	char ch = numArray[i];
        	switch(length)
        	{
	        	case 4:
	        	{
	        		int key = Integer.parseInt(String.valueOf(ch));
	        		word += map.get(1).get(key) + " thousand ";
	        		break;
	        	}
	        	case 3:
	        	{
	        		int key = Integer.parseInt(String.valueOf(ch));
	        		word += map.get(1).get(key) + " hundred and ";
	        		break;
	        	}
	        	case 2:
	        	{
	        		if(ch == '1')
	        		{
	        			if(numArray[i+1] == 0)
	        			{
	        				word += "ten";
	        			}
	        			else
	        			{
	        				char ch2 = numArray[i+1];
	        				int key = Integer.parseInt(String.valueOf(ch2));
	        				word += map.get(1).get(10 + key);
	        			}
	        			length--;
	        		}
	        		else
	        		{
	        			int key = Integer.parseInt(String.valueOf(ch));
	        			word += map.get(2).get(key) + " ";
	        		}
	        		break;
	        	}
	        	case 1:
	        	{
	        		int key = Integer.parseInt(String.valueOf(ch));
	        		word += map.get(1).get(key);
	        		break;
	        	}
        	}
        	
        	length--;
    		i++;
        }
        
        return word;
    }
}