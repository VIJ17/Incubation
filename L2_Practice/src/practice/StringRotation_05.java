package practice;

public class StringRotation_05
{
	public static void main(String[] args)
	{
		String str1 = "Hello from here";
		String str2 = "erHello from he";
		System.out.println(StringRotate(str1, str2));
	}
	
	public static boolean StringRotate(String str1, String str2)
	{
		if(str1.equals(str2))
		{
			return true;
		}
		
		int length1 = str1.length();
		int length2 = str2.length();
		
		if(length1 != length2)
		{
			return false;
		}
		
		for(int i = 1; i < length1; i++)
		{
			String check = str1.substring(i, length1) + str1.substring(0, i);
			
			if(str2.equals(check))
			{
				return true;
			}
		}
		
		return false;
	}

}
