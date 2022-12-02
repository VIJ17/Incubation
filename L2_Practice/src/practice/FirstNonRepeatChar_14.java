package practice;

public class FirstNonRepeatChar_14 
{
	public static void main(String[] args)
	{
		String str1 = "character";
		System.out.println(findNonRepeateChar(str1));
	}
	
	public static String findNonRepeateChar(String str)
	{
		int length = str.length();
		
		for(int i = 0; i < length; i++)
		{
			char ch = str.charAt(i);
			int index = str.lastIndexOf(ch);
			
			if(i == index)
			{
				return String.valueOf(ch);
			}
		}
		
		return "no matching character";
	}
}
